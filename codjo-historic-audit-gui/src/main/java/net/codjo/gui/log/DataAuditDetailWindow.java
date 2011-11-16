/*
 * codjo.net
 *
 * Common Apache License 2.0
 */
package net.codjo.gui.log;
import net.codjo.mad.gui.request.DetailDataSource;
import net.codjo.mad.gui.request.util.ButtonPanelLogic;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 */
public class DataAuditDetailWindow extends JInternalFrame {
    ButtonPanelLogic buttonPanel1 = new ButtonPanelLogic();
    JTextField functionalKey = new JTextField();
    JTextField status = new JTextField();
    JTextField userName = new JTextField();
    JTextField insertionDate = new JTextField();
    JTextField oldValue = new JTextField();
    JTextField newValue = new JTextField();
    JTextField dbTableName = new JTextField();
    JTextField dbFieldName = new JTextField();
    private DetailDataSource dataSource;
    private JPanel upPanel = new JPanel();
    private JLabel pkLabel = new JLabel();
    private JLabel fieldNameLabel = new JLabel("Champ");
    private JLabel statusLabel = new JLabel();
    private JLabel userLabel = new JLabel();
    private JLabel periodLabel = new JLabel();
    private JLabel newValueLabel = new JLabel();
    private JLabel oldValueLabel = new JLabel();
    private JLabel tableNameLabel = new JLabel();
    private GridBagLayout gridBagLayout1 = new GridBagLayout();
    private BorderLayout borderLayout1 = new BorderLayout();


    public DataAuditDetailWindow(DetailDataSource dataSource) throws Exception {
        super("detail des entrees", true, false, true, true);
        this.dataSource = dataSource;
        dataSource.declare("functionalKey", functionalKey);

        dataSource.declare("functionalKey", functionalKey);
        dataSource.declare("status", status);
        dataSource.declare("userName", userName);
        dataSource.declare("insertionDate", insertionDate);
        dataSource.declare("oldValue", oldValue);
        dataSource.declare("newValue", newValue);
        dataSource.declare("dbTableName", dbTableName);
        dataSource.declare("dbFieldName", dbFieldName);

        dataSource.load();

        jbInit();
        pack();
    }


    private void jbInit() {
        buttonPanel1.setMainDataSource(dataSource);
        this.getContentPane().setLayout(borderLayout1);
        upPanel.setLayout(gridBagLayout1);
        newValueLabel.setText("Nouvelle valeur");
        oldValueLabel.setText("Ancienne valeur");
        tableNameLabel.setText("Table");
        upPanel.add(tableNameLabel,
                    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                                           GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        upPanel.add(dbTableName,
                    new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
                                           GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        upPanel.add(pkLabel,
                    new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                                           GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        upPanel.add(functionalKey,
                    new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
                                           GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        upPanel.add(statusLabel,
                    new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                                           GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        upPanel.add(status,
                    new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
                                           GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        upPanel.add(periodLabel,
                    new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                                           GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        upPanel.add(insertionDate,
                    new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
                                           GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        upPanel.add(userLabel,
                    new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                                           GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        upPanel.add(userName,
                    new GridBagConstraints(1, 4, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
                                           GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        upPanel.add(oldValueLabel,
                    new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
                                           GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        upPanel.add(oldValue,
                    new GridBagConstraints(1, 6, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
                                           GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        upPanel.add(newValueLabel,
                    new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
                                           GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        upPanel.add(newValue,
                    new GridBagConstraints(1, 7, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                                           GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        upPanel.add(fieldNameLabel,
                    new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
                                           GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        upPanel.add(dbFieldName,
                    new GridBagConstraints(1, 8, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH,
                                           GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        this.getContentPane().add(buttonPanel1.getGui(), BorderLayout.SOUTH);

        this.getContentPane().add(upPanel, BorderLayout.CENTER);
        this.setMaximizable(true);
        this.setClosable(true);
        this.setResizable(true);
        this.setIconifiable(true);
        this.setTitle("Audit des données");
        this.setPreferredSize(new Dimension(750, 550));
        pkLabel.setText("Clé");
        statusLabel.setText("Statut");
        userLabel.setText("Lancé par");
        periodLabel.setText("Date d\'insertion");
    }
}
