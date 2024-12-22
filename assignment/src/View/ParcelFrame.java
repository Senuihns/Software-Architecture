package View;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.Log;
import Controller.ParcelController;
import Model.Parcel;
import Model.ParcelMap;

public class ParcelFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;
    
    private JButton loadParcelButton;

    public ParcelFrame() {
        super("MVC Pattern Example ");
        cardLayout = new CardLayout();
        ParcelForm form = new ParcelForm();
        ParcelDetails parcelDetails = new ParcelDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
		new ParcelController(form, parcelDetails);
        
        // adds view to card layout with unique constraints
        add(form, "form");
        add(parcelDetails, "parcel details");
        // switch view according to its constraints on click
        form.viewParcels(e -> {
        	Log.write("load customers csv");
        	cardLayout.show(ParcelFrame.this.getContentPane(), "parcel details");
        });
        parcelDetails.backButton(e -> cardLayout.show(ParcelFrame.this.getContentPane(), "form"));
        
        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
    
    
}
