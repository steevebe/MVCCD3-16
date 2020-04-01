package window.editor.reserve;


import newEditor.PanelButtons;

public class LinkButtons extends PanelButtons {


    public LinkButtons(LinkEditor linkEditor) {
        super(linkEditor);
        super.setButtonsContent (new LinkButtonsContent(this));
    }

}