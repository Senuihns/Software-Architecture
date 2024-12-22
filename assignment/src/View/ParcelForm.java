package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ParcelForm extends JPanel {

    private JTextField parcelNoField;
    private JTextField daysField;
    private JTextField weightField;
    private JTextField lengthField;
    private JTextField widthField;
    private JTextField heightField;
    private JButton addButton;
    private JButton viewButton;

    public ParcelForm() {

        JLabel parcelNoLabel = new JLabel("Parcel No: ");
        JLabel daysLabel = new JLabel("Days: ");
        JLabel weightLabel = new JLabel("Weight: ");
        JLabel lengthLabel = new JLabel("Length: ");
        JLabel widthLabel = new JLabel("Width: ");
        JLabel heightLabel = new JLabel("Height: ");

        parcelNoField = new JTextField(25);
        daysField = new JTextField(25);
        weightField = new JTextField(25);
        lengthField = new JTextField(25);
        widthField = new JTextField(25);
        heightField = new JTextField(25);
//
        addButton = new JButton("Add Parcel");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Parcels");
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

        add(parcelNoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(parcelNoField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        
        add(daysLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        
        add(daysField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        
        add(weightLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        
        add(weightField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        
        add(lengthLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        
        add(lengthField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        
        add(widthLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        
        add(widthField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        
        add(heightLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        
        add(heightField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = buttonInset;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.insets = buttonInset;

        add(viewButton, gridBagConstraints);
    }
    
    public void submitParcel(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

	public String getParcelNoField() {
		return parcelNoField.getText();
	}

    public String getDaysField() {
		return daysField.getText();
	}

    public String getWeightField() {
		return weightField.getText();
	}
    
    public String getLengthField() {
		return lengthField.getText();
	}
    
    public String getWidthField() {
		return widthField.getText();
	}
    
    public String getHeightField() {
		return heightField.getText();
	}
    
	public void viewParcels(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
        	parcelNoField.setText("");
        	daysField.setText("");
        	weightField.setText("");
        	lengthField.setText("");
        	widthField.setText("");
        	heightField.setText("");
        }
    }
}
