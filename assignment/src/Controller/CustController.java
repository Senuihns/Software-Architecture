package Controller;

import java.io.File;

import javax.swing.JOptionPane;

import Model.Cust;
import Model.QueofCustomers;
import View.CustDetails;
import View.CustForm;

public class CustController {
    // data file
    private String databaseFile = "Custs.csv";
    private QueofCustomers database;
    private CustForm form;
    private CustDetails custDetails;

    public CustController(CustForm form, CustDetails custDetails) {
        this.database = new QueofCustomers();
        this.form = form;
        this.custDetails = custDetails;

        // submit Cust
        this.form.submitCust(e -> {
        	Log.write("add customer");
            String name = this.form.getNameField().trim();
            String parcelNo = this.form.getParcelNoField().trim();

            // simple validations
            if(name.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(parcelNo.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Parcel No Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            this.database.addCust(new Cust(name, parcelNo));
            this.database.saveCust(new File(databaseFile));
            this.form.reset(true);
            
        });

        // load Custs
        this.form.viewCusts(e -> {
        	Log.write("load cust csv");
            this.custDetails.getCusts(this.database.loadCusts(new File(databaseFile)));
        });
        
        this.custDetails.deleteButton(e -> {
        	Log.write("delete customer");
        	Object[] list1 = this.database.loadCusts(new File(databaseFile));
        	this.database.deleteCust(new File(databaseFile),list1, this.custDetails.getName());
        	new JOptionPane().showMessageDialog(null, "Delete Customer Success£¡");
        });
    }
}

