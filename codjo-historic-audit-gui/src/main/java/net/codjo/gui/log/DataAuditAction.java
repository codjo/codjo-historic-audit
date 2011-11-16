/*
 * codjo.net
 *
 * Common Apache License 2.0
 */
package net.codjo.gui.log;
import net.codjo.gui.toolkit.util.ErrorDialog;
import net.codjo.gui.toolkit.util.GuiUtil;
import net.codjo.mad.gui.framework.AbstractGuiAction;
import net.codjo.mad.gui.framework.GuiContext;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
/**
 *
 */
public class DataAuditAction extends AbstractGuiAction {
    private CleanUpListener cleanUpListener = new CleanUpListener();
    private JInternalFrame frame;


    public DataAuditAction(GuiContext ctxt) {
        super(ctxt, "IHM audit des données", "IHM audit des données");
    }


    public void actionPerformed(ActionEvent evt) {
        if (frame == null) {
            displayNewWindow();
        }
        else {
            try {
                frame.setSelected(true);
            }
            catch (PropertyVetoException ex) {
                //normal
            }
        }
    }


    private void displayNewWindow() {
        try {
            frame = new DataAuditWindow(getGuiContext());
            frame.addInternalFrameListener(cleanUpListener);
            getDesktopPane().add(frame);
            frame.pack();
//            frame.setMaximum(true);
            GuiUtil.centerWindow(frame);
            frame.setVisible(true);
            frame.setSelected(true);
        }
        catch (Exception ex) {
            ErrorDialog.show(getDesktopPane(), "Impossible d'afficher la liste", ex);
        }
    }


    private class CleanUpListener extends InternalFrameAdapter {
        @Override
        public void internalFrameActivated(InternalFrameEvent evt) {
        }


        @Override
        public void internalFrameClosed(InternalFrameEvent evt) {
            evt.getInternalFrame().removeInternalFrameListener(this);
            frame = null;
        }


        @Override
        public void internalFrameClosing(InternalFrameEvent evt) {
            evt.getInternalFrame().removeInternalFrameListener(this);
            frame = null;
        }
    }
}
