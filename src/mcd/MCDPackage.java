package mcd;

import m.IMCompletness;
import mcd.compliant.MCDCompliant;
import mcd.interfaces.*;
import project.ProjectElement;
import project.ProjectService;

import java.util.ArrayList;

public class MCDPackage extends MCDElement implements IMCDTraceability, IMCDNamePathParent,
        IMCDContPackages, IMCDContContainer, IMCDContainer, IMCompletness {

    private static final long serialVersionUID = 1000;

    private boolean mcdJournalization = false;
    private boolean mcdJournalizationException = false;
    private boolean mcdAudit = false;
    private boolean mcdAuditException = false;

    public MCDPackage(ProjectElement parent, String name) {

        super(parent,name);
    }

    public MCDPackage(ProjectElement parent) {

        super(parent);
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


    public ArrayList<MCDEntity> getMCDEntities(){
        return ProjectService.getMCDEntities(this);
    }

    public ArrayList<String> treatCompliant(){
        MCDCompliant mcdCompliant = new MCDCompliant();
        ArrayList<String> resultat = mcdCompliant.check(getMCDEntities(), false);

        return resultat;

    }


}
