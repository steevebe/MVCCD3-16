package repository.editingTreat.mcd;

import main.MVCCDElement;
import main.MVCCDWindow;
import mcd.MCDModel;
import mcd.MCDPackage;
import mcd.interfaces.IMCDContContainer;
import mcd.interfaces.IMCDContainer;
import repository.editingTreat.EditingTreat;
import utilities.window.editor.DialogEditor;
import utilities.window.editor.PanelInputContent;
import window.editor.entity.EntityInputContent;
import window.editor.model.ModelEditor;
import window.editor.model.ModelInputContent;

import java.awt.*;
import java.util.ArrayList;

public class MCDModelEditingTreat extends EditingTreat {


    @Override
    protected PanelInputContent getPanelInputContent(MVCCDElement element) {

        return new ModelInputContent(element, ModelEditor.MODEL);
    }

    @Override
    protected DialogEditor getDialogEditor(Window owner, MVCCDElement parent, MVCCDElement element, String mode) {
        return new ModelEditor(owner , (IMCDContContainer) parent, (IMCDContainer) element,
                mode, ModelEditor.MODEL, new MCDModelEditingTreat());
    }

    @Override
    protected String getPropertyTheElement() {
        return "the.model";
    }

    @Override
    public ArrayList<String> treatCompliant(Window owner, MVCCDElement mvccdElement) {
        MCDModel mcdModel = (MCDModel) mvccdElement;
        ArrayList<String> resultat = mcdModel.treatCompliant();
        return resultat;
    }

}
