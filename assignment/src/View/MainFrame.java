package View;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private CardLayout cardLayout;
	
	private JButton custsButton;
    private JButton parcelButton;
    
	public MainFrame() {
		
		super("Main Frame");
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        
		custsButton = new JButton("Deal Customer");
		custsButton.setPreferredSize(new Dimension(278, 40));
		parcelButton = new JButton("Deal Parcel");
		parcelButton.setPreferredSize(new Dimension(278, 40));
		
		setLayout(new GridBagLayout());
		Insets buttonInset = new Insets(20,0,0,0);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.NONE;
		
		gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;

        add(custsButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = buttonInset;

        add(parcelButton, gridBagConstraints);
        
        custsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustFrame frm=new CustFrame();
				frm.setVisible(true);
			}
		});
        
        parcelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ParcelFrame frm=new ParcelFrame();
				frm.setVisible(true);
			}
		});
       
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}

}
