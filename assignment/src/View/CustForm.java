package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustForm extends JPanel {

    private JTextField nameField;
    private JTextField parcelNoField;
//
    private JButton addButton;
    private JButton viewButton;


    public CustForm() {

        JLabel nameLabel = new JLabel("Name: ");
        JLabel parcelNoLabel = new JLabel("Parcel No: ");
        

        nameField = new JTextField(25);
        parcelNoField = new JTextField(25);
//
        addButton = new JButton("Add Customer");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Customers");
        viewButton.setPreferredSize(new Dimension(278, 40));

        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(nameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(nameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(parcelNoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(parcelNoField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = buttonInset;

        add(viewButton, gridBagConstraints);
    }
    
    public void submitCust(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public String getNameField() {
		return nameField.getText();
	}

	public String getParcelNoField() {
		return parcelNoField.getText();
	}

	public void viewCusts(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
        	nameField.setText("");
        	parcelNoField.setText("");
        }
    }
}
