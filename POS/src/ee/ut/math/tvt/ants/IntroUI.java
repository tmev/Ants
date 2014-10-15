package ee.ut.math.tvt.ants;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroUI {

	public static void introUI() {
		JFrame raam = new JFrame("Beerhouse by ANTS"); // raami loomine
	    raam.setSize(750, 260); // 
	    raam.setLocation(100, 100); // 
	    raam.getContentPane().setBackground(Color.WHITE);
	    raam.setLayout(new GridLayout(1,3)); // paigutushalduri kasutamine

	    JPanel logo = new JPanel(new GridLayout(1, 1));
	   	JLabel imgLabel = new JLabel(new ImageIcon("beerhouse.jpg"));
	   	logo.setBackground(Color.WHITE);
	   	logo.add(imgLabel);
	    
	// 
	   	
	    JPanel sisu = new JPanel(new GridLayout(1, 2));
	    JLabel tekst = new JLabel("<html>"
	    		+ "<b>Team name<br/>"
	    		+ "Team leader<br/>"
	    		+ "Team leader email<br/>"
	    		+ "Team members<br/><b/>"
	    		+ "Software version number</html>");
	    sisu.add(tekst);
	    
	    
	    
	    JPanel sisu2 = new JPanel(new GridLayout(1, 3));
	    JLabel tekst2 = new JLabel("<html>"
	    		+ "ANTS<br/>"
	    		+ "Tanel Aamer<br/>"
	    		+ "tanel.aamer@eesti.ee<br/>"
	    		+ "Toomas Ounmaa, Umar Zarip, Tanel Aamer<br/></html>"
	    		+ "tba");
	    sisu2.add(tekst2);
	    
	    raam.add(logo);
	    raam.add(tekst);
	    raam.add(tekst2);

	// 
	         raam.setVisible(true); 

	   
	         
	}
}
