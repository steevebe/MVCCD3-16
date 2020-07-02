package repository.editingTreat.mcd;

import main.MVCCDElement;
import main.MVCCDWindow;
import mcd.MCDNID;
import mcd.MCDPackage;
import mcd.MCDParameter;
import repository.editingTreat.EditingTreat;
import utilities.window.editor.DialogEditor;
import utilities.window.editor.PanelInputContent;
import window.editor.operation.parameter.ParameterEditor;
import window.editor.operation.parameter.ParameterInputContent;

import java.awt.*;
import java.util.ArrayList;

public class MCDNIDParameterEditingTreat extends EditingTreat {


    @Override
    protected PanelInputContent getPanelInputContent(MVCCDElement element) {
        return new ParameterInputContent(element, ParameterEditor.NID);
    }

    @Override
    protected DialogEditor getDialogEditor(Window owner, MVCCDElement parent, MVCCDElement element, String mode) {
        return new ParameterEditor(owner, (MCDNID) parent, (MCDParameter) element, mode,
                ParameterEditor.NID, new MCDNIDParameterEditingTreat());

    }

    @Override
    protected String getPropertyTheElement() {
        return "the.operation.parameter";
    }

    @Override
    public ArrayList<String> treatCompliant(MVCCDWindow mvccdWindow, MVCCDElement mvccdElement) {
        return null;
    }

}
