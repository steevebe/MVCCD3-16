package mcd;

import m.IMCompliant;
import main.MVCCDElement;
import mcd.interfaces.*;

import java.util.ArrayList;

public class MCDModel extends MCDElement implements IMCDModel, IMCDTraceability,
        IMCDContContainer, IMCDNamePathParent, IMCDContPackages, IMCDContainer, IMCompliant {

    private static final long serialVersionUID = 1000;

    private boolean packagesAutorizeds = false;
    private boolean mcdJournalization = false;
    private boolean mcdJournalizationException = false;
    private boolean mcdAudit = false;
    private boolean mcdAuditException = false;


    public MCDModel(MCDContModels parent, String name) {

        super(parent, name);
    }

    public MCDModel(MCDContModels parent) {

        super (parent);
    }

    public boolean isPackagesAutorizeds() {
        return packagesAutorizeds;
    }

    public void setPackagesAutorizeds(boolean packagesAutorizeds) {
        this.packagesAutorizeds = packagesAutorizeds;
    }

    public boolean isMcdJournalization() {
        return mcdJournalization;
    }

    public void setMcdJournalization(boolean mcdJournalization) {
        this.mcdJournalization = mcdJournalization;
    }

    public boolean isMcdJournalizationException() {
        return mcdJournalizationException;
    }

    public void setMcdJournalizationException(boolean mcdJournalizationException) {
        this.mcdJournalizationException = mcdJournalizationException;
    }

    public boolean isMcdAudit() {
        return mcdAudit;
    }

    public void setMcdAudit(boolean mcdAudit) {
        this.mcdAudit = mcdAudit;
    }

    public boolean isMcdAuditException() {
        return mcdAuditException;
    }

    public void setMcdAuditException(boolean mcdAuditException) {
        this.mcdAuditException = mcdAuditException;
    }


    public ArrayList<String> treatCompliant(){
        ArrayList<String> resultat =new ArrayList<String>();
        System.out.println("Contrôle de conformité");
        return resultat;
    }


}
