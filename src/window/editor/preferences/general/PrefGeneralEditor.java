package window.editor.preferences.general;

import main.MVCCDElement;
import main.MVCCDWindow;
import newEditor.DialogEditor;
import preferences.Preferences;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class PrefGeneralEditor extends DialogEditor {


    //TODO-0 Il faut appuyer 2 * pour fermer la fenêtre!
    public PrefGeneralEditor(Window owner,
                             MVCCDElement parent,
                             Preferences preferences,
                             String mode)  {
        super(owner, parent, preferences, mode);
        super.setSize(Preferences.PREFERENCES_WINDOW_WIDTH, Preferences.PREFERENCES_WINDOW_HEIGHT);
        super.setInput(new PrefGeneralInput(this));
        super.setButtons (new PrefGeneralButtons(this));

        super.start();
    }

    @Override
    protected String getPropertyTitleNew() {
        return null;
    }

    @Override
    protected String getPropertyTitleUpdate() {
        return "preferences.project.general.update";
    }




}