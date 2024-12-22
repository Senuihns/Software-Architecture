package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import Model.Parcel;
import Model.ParcelMap;

public class ParcelDetails extends JPanel {

    // Table for parcel data
    private JTable parcelTable;
    // table column
    private String[] parcelTableColumn = {"PARCEL NO", "DAYS", "WEIGHT", "LENGTH", "WIDTH", "HEIGHT"};

    // back button
    private JButton backButton, doneButton;
    
    String parcelNo;

    public ParcelDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        parcelTable = new JTable();
        // scroll bar for table
        JScrollPane parcelTableScroll = new JScrollPane(parcelTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        doneButton = new JButton("Delivery to Customer");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.add(doneButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(parcelTableScroll);
    }

    // gets parcels from database and loads to table
    public void getParcels(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) parcelTable.getModel();
        defaultTableModel.setColumnIdentifiers(parcelTableColumn);
        defaultTableModel.setRowCount(0);
        int i = 0;
        while(i < objects.length) {
            String row = objects[i].toString().trim();
            String[] rows = row.split(",");
            defaultTableModel.addRow(rows);
            i++;
        }
    }
    
    public void removeParcel(ActionListener actionListener) {
    	doneButton.addActionListener(actionListener);
    }
    
    public String getParcelNo () {
    	int index = parcelTable.getSelectedRow();
    	return parcelTable.getValueAt(index, 0).toString();
    }

    // event listener for back button
    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
    
    public void doneButton(ActionListener actionListener) {
    	doneButton.addActionListener(actionListener);
    }
}
