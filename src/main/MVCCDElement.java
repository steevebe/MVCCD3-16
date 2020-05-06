package main;

import mcd.MCDElement;
import org.apache.commons.lang.StringUtils;
import preferences.PreferencesManager;
import project.ProjectElement;
import project.ProjectService;
import utilities.Debug;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public abstract class MVCCDElement implements Serializable, Comparable<MVCCDElement>{

    private static final long serialVersionUID = 1000;

    public static final int SCOPENAME = 1;
    public static final int SCOPESHORTNAME = 2;
    public static final int SCOPELONGNAME = 3;
    public static final int SCOPENOTNAME = 4;

    private MVCCDElement parent;
    private String name;
    private String shortName;
    private String longName;
    private int order;
    private int firstValueOrder = 10;
    private int intervalOrder = 10;
    //private boolean uniqueInParent = true;

    private ArrayList<MVCCDElement> childs = new ArrayList<MVCCDElement>();


    public MVCCDElement(MVCCDElement parent) {
        this.parent = parent;
        init();
    }

    public MVCCDElement(MVCCDElement parent, String name) {
        this.parent = parent;
        this.name = name;
        init();
    }

    private void init(){
        if (parent != null) {
            if (parent.getChilds().size() == 0){
                order = firstValueOrder;
            } else {
                int valueMax = 0 ;
                for (MVCCDElement child : parent.getChilds()){
                    if (child.getOrder() > valueMax){
                        valueMax = child.getOrder();
                    }
                }
                order = valueMax + intervalOrder;
            }
            parent.getChilds().add(this);
        } else {
            order = firstValueOrder;
        }
    }

    public MVCCDElement getParent() {
        return parent;
    }

    public void setOrChangeParent(MVCCDElement parent) {
        if (this.getParent() != null){
            this.getParent().getChilds().remove(this);
        }
        this.parent = parent;
        parent.getChilds().add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortNameSmart() {
        if (shortName != null) {
            return shortName;
        } else {
            return name;
        }
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }


    public String getLongNameSmart() {
        if (longName != null) {
            return longName;
        } else {
            return name;
        }
    }


    public ArrayList<MVCCDElement> getChilds() {
        Collections.sort(childs, MVCCDElement::compareTo);
        return childs;
    }

    public ArrayList<MVCCDElement> getChildsWithout(MVCCDElement child) {
        ArrayList<MVCCDElement> resultat = new ArrayList<MVCCDElement>() ;
        for (MVCCDElement aChild : getChilds()){
            if (aChild != child){
                resultat.add(aChild);
            }
        }
        return resultat;
    }

    public ArrayList<MVCCDElement> getDescendants(){
        return MVCCDElementService.getDescendants(this);
    }

    public ArrayList<MVCCDElement> getDescendantsWithout(MVCCDElement child) {
        ArrayList<MVCCDElement> resultat = new ArrayList<MVCCDElement>() ;
        for (MVCCDElement aChild : getDescendants()){
            if (aChild != child){
                resultat.add(aChild);
            }
        }
        return resultat;
    }



    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    // Peut être surchargé par les descendants si nécessaire (p.exemple, les relations
    // est utilisé par toString()
    public abstract String getNameTree() ;

    public String toString(){
       if (StringUtils.isNotEmpty(getNameTree())){
            return getNameTree();
        } else {
            if (StringUtils.isNotEmpty(name)) {
                return name;
            } else {
                //TODO-1 A voir s'il faut enlever getClass() lorsque le produit sera stable
                return "Sans nom  " + getClass().getName();
            }
        }
    }


    public void debugCheckLoad(){
        if (PreferencesManager.instance().preferences().isDEBUG()) {
            if (PreferencesManager.instance().preferences().isDEBUG_BACKGROUND_PANEL()) {
                String childsToString = "";
                for (MVCCDElement child : childs) {
                    if (!StringUtils.isEmpty(childsToString)) {
                        childsToString = childsToString + ", ";
                    }
                    childsToString = childsToString + " " + child.getName();
                }
                String parent;
                if (getParent() != null) {
                    parent = getParent().getName();
                } else {
                    parent = "-";
                }
                Debug.println("Element :" + name + "  | Parent : " + parent + " | Childs : " + childsToString);
            }
        }
    }

    public void debugCheckLoadDeep(){
        if (PreferencesManager.instance().preferences().isDEBUG()) {
            if (PreferencesManager.instance().preferences().isDEBUG_BACKGROUND_PANEL()) {
                debugCheckLoad();
                for (MVCCDElement child : childs) {
                    child.debugCheckLoadDeep();
                }
            }
       }
    }

    public int compareTo(MVCCDElement o) {
        if ( this.getOrder() > o.getOrder()){
            return 1;
        } else if (this.getOrder() == o.getOrder()){
            return 0;
        } else {
            return -1;
        }
    }

    public boolean implementsInterface(String className) {
        for (Class anInterface : this.getClass().getInterfaces()) {
            if (anInterface.getName().equals(className)) {
                return true;
            }
        }
        return false;
    }

    public String getNameId() {
        return getName();
    }

    public String getShortNameId() {
        return getShortName();
    }

    public String getLongNameId() {
        return getLongName();
    }

}
