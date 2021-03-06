package mcd;

import main.MVCCDElement;

import java.util.ArrayList;

public class MCDContRelEnds extends MCDElement{

    private static final long serialVersionUID = 1000;

    public MCDContRelEnds(MCDElement parent, String name) {
        super(parent,name);
    }

    public ArrayList<MCDRelEnd> getMCDRelEnds(){
        ArrayList<MCDRelEnd> resultat = new ArrayList<MCDRelEnd>();
        for (MVCCDElement mvccdElement: getChilds()){
            resultat.add((MCDRelEnd) mvccdElement);
        }
        return resultat;
    }

}
