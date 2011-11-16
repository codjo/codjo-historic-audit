/*
 * codjo.net
 *
 * Common Apache License 2.0
 */
package net.codjo.gui.log;
import net.codjo.gui.toolkit.util.ErrorDialog;
import net.codjo.mad.client.request.RequestException;
import net.codjo.mad.gui.framework.GuiContext;
import net.codjo.mad.gui.request.Preference;
import net.codjo.mad.gui.request.PreferenceFactory;
import net.codjo.mad.gui.request.RequestTable;
import net.codjo.mad.gui.request.RequestToolBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
/**
 *
 */
public class DataAuditWindow extends JInternalFrame {
    private JScrollPane jScrollPane1 = new JScrollPane();
    private BorderLayout borderLayout1 = new BorderLayout();
    private RequestTable requestTable = new RequestTable();
    private RequestToolBar requestToolBar = new RequestToolBar();


    public DataAuditWindow(GuiContext ctxt) {
        this(ctxt, new Dimension(800, 440));
    }


    public DataAuditWindow(GuiContext ctxt, Dimension preferredSize) {
        super("Audit des données", true, true, true, true);
        jbInit();

        Preference preference = PreferenceFactory.getPreference("DataAuditWindow");
        requestTable.setPreference(preference);
        requestToolBar.init(ctxt, requestTable);
        this.setPreferredSize(preferredSize);
        this.setMinimumSize(preferredSize);
        try {
            requestTable.load();
        }
        catch (RequestException ex) {
            ErrorDialog.show(this, ex.getLocalizedMessage(), ex);
        }
    }


    private void jbInit() {
        this.getContentPane().setLayout(borderLayout1);
        this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        this.getContentPane().add(requestToolBar, BorderLayout.SOUTH);
        jScrollPane1.getViewport().add(requestTable, null);
    }
}
