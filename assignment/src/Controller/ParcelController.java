package Controller;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Parcel;
import Model.ParcelMap;
import View.ParcelDetails;
import View.ParcelForm;

public class ParcelController {
    // data file
    private String databaseFile = "Parcels.csv";
    private ParcelMap database;
    private ParcelForm form;
    private ParcelDetails parcelDetails;

    public ParcelController(ParcelForm form, ParcelDetails parcelDetails) {
        this.database = new ParcelMap();
        this.form = form;
        this.parcelDetails = parcelDetails;

        // submit Parcel
        this.form.submitParcel(e -> {
        	Log.write("add parcel");
            String parcelNo = this.form.getParcelNoField().trim();
            String days = this.form.getDaysField().trim();
            String weight = this.form.getWeightField().trim();
            String length = this.form.getLengthField().trim();
            String width = this.form.getWidthField().trim();
            String height = this.form.getHeightField().trim();

            // simple validations
            if(parcelNo.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Parcel No Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(days.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Days Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(weight.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Weight No Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(length.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "length No Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(width.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Width No Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(height.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Height No Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            this.database.addParcel(new Parcel(parcelNo, Integer.parseInt(days), Integer.parseInt(weight), Integer.parseInt(length), Integer.parseInt(width), Integer.parseInt(height)));
            this.database.saveParcel(new File(databaseFile));
            this.form.reset(true);
        });

        // load Parcels
        this.form.viewParcels(e -> {
        	Log.write("load parcels csv");
            this.parcelDetails.getParcels(this.database.loadParcels(new File(databaseFile)));
        });
        
        this.parcelDetails.doneButton(e -> {
        	Log.write("parcel status changed to done");
        	Object[] list1 = this.database.loadParcels(new File(databaseFile));
        	this.database.removeParcel(new File(databaseFile),list1, this.parcelDetails.getParcelNo());
        	new JOptionPane().showMessageDialog(null, "Delivery Success£¡");
        });
    }

	public ParcelMap getParcelList() {
		return database;
	}

	public void setParcelList(ParcelMap database) {
		this.database = database;
	}
    
}

