package View;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controller.CustController;
import Controller.Log;

public class CustFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;
    
    private JButton loadCustsButton;
    private JButton loadParcelButton;

    public CustFrame() {
        super("Customer Frame");
        cardLayout = new CardLayout();
        CustForm form = new CustForm();
        CustDetails custDetails = new CustDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        new CustController(form, custDetails);

        // adds view to card layout with unique constraints
        add(form, "form");
        add(custDetails, "cust details");
        // switch view according to its constraints on click
        form.viewCusts(e -> {
        	Log.write("load customers csv");
        	cardLayout.show(CustFrame.this.getContentPane(), "cust details");
        });
        custDetails.backButton(e -> cardLayout.show(CustFrame.this.getContentPane(), "form"));
       
        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}
