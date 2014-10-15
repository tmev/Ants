package ee.ut.math.tvt.ants;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class IntroUI {
	private static final Logger log = Logger.getLogger(IntroUI.class);
	
	public static void introUI()  {
		
		PropertyConfigurator.configure("log4j.properties");
		
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
	    
	    Properties buildProps = new Properties();
	    buildProps.getProperty("build.xml");
	    System.out.println(buildProps);
	    
	    JPanel sisu2 = new JPanel(new GridLayout(1, 3));
	    JLabel tekst2 = new JLabel("<html>"
	    		+ "ANTS<br/>"
	    		+ "Tanel Aamer<br/>"
	    		+ "tanel.aamer@eesti.ee<br/>"
	    		+ "Toomas Ounmaa, Umar Zarip, Tanel Aamer<br/></html>"
	    		+ buildProps);
	    sisu2.add(tekst2);
	    
	    raam.add(logo);
	    raam.add(tekst);
	    raam.add(tekst2);

	// 
	         raam.setVisible(true); 

	         log.info("IntroUi window opened");  
	         
	}
}
