package repository.editingTreat.mcd;

import main.MVCCDElement;
import main.MVCCDManager;
import mcd.*;
import project.ProjectService;
import repository.editingTreat.EditingTreat;
import utilities.window.editor.DialogEditor;
import utilities.window.editor.PanelInputContent;
import utilities.window.scomponents.services.SComboBoxService;
import window.editor.relation.association.AssociationEditor;
import window.editor.relation.association.AssociationInputContent;
import window.editor.relation.genspec.GenSpecEditor;
import window.editor.relation.genspec.GenSpecInputContent;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;

public class MCDGeneralizationEditingTreat extends EditingTreat {


    public  MCDGeneralization treatNew(Window owner,
                                    MCDContRelations parent) {

        MCDGeneralization mcdGeneralizationNew = (MCDGeneralization) super.treatNew( owner, parent);

        if (mcdGeneralizationNew != null) {
            addGSEndInRepository(mcdGeneralizationNew.getGen());
            addGSEndInRepository(mcdGeneralizationNew.getSpec());
        }
        return mcdGeneralizationNew;
    }

    public  MCDGeneralization treatNew(Window owner,
                                    MCDContRelations parent,
                                    MCDEntity entityGen,
                                    MCDEntity entitySpec) {

        DialogEditor fen = getDialogEditor(owner, parent, null, DialogEditor.NEW);
        GenSpecInputContent content = (GenSpecInputContent) fen.getInput().getInputContent();

        if (entityGen  != null){
            SComboBoxService.selectByText(content.getFieldGenEntity(), entityGen.getNamePath(content.getModePathName()));
        }
        if (entitySpec  != null) {
            SComboBoxService.selectByText(content.getFieldSpecEntity(), entitySpec.getNamePath(content.getModePathName()));
        }


        fen.setVisible(true);
        MCDGeneralization mcdGeneralizationNew = (MCDGeneralization)  fen.getMvccdElementNew();

        if (mcdGeneralizationNew != null) {
            addGSEndInRepository(mcdGeneralizationNew.getGen());
            addGSEndInRepository(mcdGeneralizationNew.getSpec());
        }
        return mcdGeneralizationNew;
    }

    private void addGSEndInRepository(MCDGSEnd mcdGSEnd) {
        MCDContEndRels parent = (MCDContEndRels) mcdGSEnd.getParent();
        DefaultMutableTreeNode nodeParent = ProjectService.getNodeById((int) parent.getId());
        MVCCDManager.instance().addNewMVCCDElementInRepository(mcdGSEnd, nodeParent);
    }



       @Override
    protected ArrayList<String> checkCompliant(MVCCDElement mvccdElement) {
        ArrayList<String> resultat = new ArrayList<String>();
        return resultat;
    }

    @Override
    protected PanelInputContent getPanelInputContent(MVCCDElement element) {
        return new AssociationInputContent(element);
    }

    @Override
    protected DialogEditor getDialogEditor(Window owner,
                                           MVCCDElement parent,
                                           MVCCDElement element,
                                           String mode) {
        return new GenSpecEditor(owner, (MCDContRelations) parent, (MCDGeneralization) element,
                mode, new MCDGeneralizationEditingTreat());
    }

    @Override
    protected String getPropertyTheElement() {
        return "the.generalization";
    }

}
