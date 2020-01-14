package utilities.window;

import window.preferences.PrefEditor;
import preferences.Preferences;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class PanelBorderLayout extends JPanel implements MouseListener, MouseInputListener{

    private boolean resizable = true;
    private PrefEditor prefEditor;
    private String borderLayoutPosition;
    private PanelBorderLayoutResizer panelBLResizer;
    private PanelContent content;

    public PanelBorderLayout() {
   }

    public void start(){
        panelBLResizer.getPanels().add(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, Preferences.JPANEL_HGAP,Preferences.JPANEL_VGAP);
        this.setLayout(fl);
        colorBackground();
    }

    protected  void colorBackground() {
        Color color = Preferences.BACKGROUND_PANEL;
        if (Preferences.DEBUG_BACKGROUND_PANEL){
            if (this.borderLayoutPosition.equals(BorderLayout.NORTH)) color = Color.RED;
            if (this.borderLayoutPosition.equals(BorderLayout.EAST)) color = Color.YELLOW;
            if (this.borderLayoutPosition.equals(BorderLayout.CENTER)) color = Color.GREEN;
            if (this.borderLayoutPosition.equals(BorderLayout.WEST)) color = Color.BLUE;
            if (this.borderLayoutPosition.equals(BorderLayout.SOUTH)) color = Color.MAGENTA;
        }
        this.setBackground(color);
    }


    public void setPanelBLResizer(PanelBorderLayoutResizer panelBLResizer) {
        this.panelBLResizer = panelBLResizer;
    }

    public PanelBorderLayoutResizer getPanelBLResizer() {
        return panelBLResizer;
    }

    public void  resizeContent(){
        content.resizeContent();
    };

    public PanelContent getContent() {
        return content;
    }

    public void setContent(PanelContent content) {
        this.content = content;
    }

    public void setBorderLayoutPosition(String borderLayoutPosition) {
        this.borderLayoutPosition = borderLayoutPosition;
    }

    public String getBorderLayoutPosition() {
        return borderLayoutPosition;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        getPanelBLResizer().mouseReleaseSubPanel(mouseEvent);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        getPanelBLResizer().mouseEnterSubPanel(mouseEvent);
     }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        getPanelBLResizer().mouseExitSubPanel(mouseEvent);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        getPanelBLResizer().mouseDraggedSubPanel(mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        getPanelBLResizer().mouseMoveSubPanel(mouseEvent);
    }

    public int correctedMinimaleWidth(int delta){
        Dimension dim = this.getSize();
        if ((dim.width - delta) < (3 * Preferences.JPANEL_HGAP)){
            return delta = dim.width -3 * Preferences.JPANEL_HGAP;
        } else {
            return delta;
        }
    }

    public int correctedMinimaleHeight(int delta){
        Dimension dim = this.getSize();
        if ((dim.height - delta) < (3 * Preferences.JPANEL_VGAP)){
            return delta = dim.height -3 * Preferences.JPANEL_VGAP;
        } else {
            return delta;
        }
    }

    public void increaseWidth(int delta){
        Dimension dim = this.getSize();
        setSize(dim.width + delta, dim.height);
    }

    public void increaseHeight(int delta){
        Dimension dim = this.getSize();
        setSize(dim.width, dim.height + delta);
    }

    public void increaseLocationX(int delta){
        Point loc = this.getLocation();
        setLocation(loc.x + delta, loc.y);
    }

    public void increaseLocationY(int delta){
        Point loc = this.getLocation();
        setLocation(loc.x, loc.y  + delta);
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }
}
