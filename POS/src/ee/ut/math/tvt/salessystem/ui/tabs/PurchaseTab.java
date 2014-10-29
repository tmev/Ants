package ee.ut.math.tvt.salessystem.ui.tabs;


import ee.ut.math.tvt.ants.appProp;
import ee.ut.math.tvt.ants.verProp;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.panels.PurchaseItemPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "Point-of-sale" in the menu).
 */
public class PurchaseTab {

  private static final Logger log = Logger.getLogger(PurchaseTab.class);

  private final SalesDomainController domainController;
 
  private JButton newPurchase;

  private JButton submitPurchase;

  private JButton cancelPurchase;

  private PurchaseItemPanel purchasePane;

  private SalesSystemModel model;


  public PurchaseTab(SalesDomainController controller,
      SalesSystemModel model)
  {
    this.domainController = controller;
    this.model = model;
  }


  /**
   * The purchase tab. Consists of the purchase menu, current purchase dialog and
   * shopping cart table.
   */
  public Component draw() {
    JPanel panel = new JPanel();

    // Layout
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    panel.setLayout(new GridBagLayout());

    // Add the purchase menu
    panel.add(getPurchaseMenuPane(), getConstraintsForPurchaseMenu());

    // Add the main purchase-panel
    purchasePane = new PurchaseItemPanel(model);
    panel.add(purchasePane, getConstraintsForPurchasePanel());

    return panel;
  }




  // The purchase menu. Contains buttons "New purchase", "Submit", "Cancel".
  private Component getPurchaseMenuPane() {
    JPanel panel = new JPanel();

    // Initialize layout
    panel.setLayout(new GridBagLayout());
    GridBagConstraints gc = getConstraintsForMenuButtons();

    // Initialize the buttons
    newPurchase = createNewPurchaseButton();
    submitPurchase = createConfirmButton();
    cancelPurchase = createCancelButton();

    // Add the buttons to the panel, using GridBagConstraints we defined above
    panel.add(newPurchase, gc);
    panel.add(submitPurchase, gc);
    panel.add(cancelPurchase, gc);

    return panel;
  }


  // Creates the button "New purchase"
  private JButton createNewPurchaseButton() {
    JButton b = new JButton("New purchase");
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        newPurchaseButtonClicked();
      }
    });

    return b;
  }

  // Creates the "Confirm" button
  private JButton createConfirmButton() {
    JButton b = new JButton("Confirm");
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        submitPurchaseButtonClicked();
      }
    });
    // Confirm button screen
    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          popup();
        }
      });
    b.setEnabled(false);

    return b;
  }


  // Creates the "Cancel" button
  private JButton createCancelButton() {
    JButton b = new JButton("Cancel");
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cancelPurchaseButtonClicked();
      }
    });
    b.setEnabled(false);

    return b;
  }





  /* === Event handlers for the menu buttons
   *     (get executed when the buttons are clicked)
   */


  /** Event handler for the <code>new purchase</code> event. */
  protected void newPurchaseButtonClicked() {
    log.info("New sale process started");
    try {
      domainController.startNewPurchase();
      startNewSale();
    } catch (VerificationFailedException e1) {
      log.error(e1.getMessage());
    }
  }


  /**  Event handler for the <code>cancel purchase</code> event. */
  protected void cancelPurchaseButtonClicked() {
    log.info("Sale cancelled");
    try {
      domainController.cancelCurrentPurchase();
      endSale();
      model.getCurrentPurchaseTableModel().clear();
    } catch (VerificationFailedException e1) {
      log.error(e1.getMessage());
    }
  }


  /** Event handler for the <code>submit purchase</code> event. */
  protected void submitPurchaseButtonClicked() {
    log.info("Sale complete");
    try {
      log.debug("Contents of the current basket:\n" + model.getCurrentPurchaseTableModel());
      domainController.submitCurrentPurchase(
          model.getCurrentPurchaseTableModel().getTableRows()
      );
      endSale();
      model.getCurrentPurchaseTableModel().clear();
    } catch (VerificationFailedException e1) {
      log.error(e1.getMessage());
    }
  }
  
  // Text fields
  private JTextField totalSum;
  private JTextField paymentAmount;
  private JTextField changeAmount;
  private JButton CalculateMoney;
  private JButton Accept;
  private JButton Cancel;
  
  //private JTextField acceptCancel;
  
  protected void popup() {

	  PropertyConfigurator.configure("log4j.properties");
		
		JFrame raam = new JFrame("Information"); // raami loomine
	    raam.setSize(750, 260); // 
	    raam.setLocation(100, 100); // 
	    raam.getContentPane().setBackground(Color.WHITE);
	    raam.setLayout(new GridLayout(1,2)); // paigutushalduri kasutamine
	    
	    CalculateMoney = new JButton("Calculate");
	    Accept = new JButton("Accept");
	    Cancel = new JButton("Cancel");
	   	
	    JPanel sisu = new JPanel(new GridLayout(6, 2));
	    /* JLabel tekst = new JLabel("<html>"
	    		+ "<b>Order total sum<br/>"
	    		+ "Enter payment amount<br/>"
	    		+ "Change amount<br/>"
	    		+ "Accept/Cancel</html>");
	    sisu.add(tekst);*/
	    
	    sisu.add(new JLabel("<html><b>Order total sum<br/></html>"));
	    sisu.add(new JLabel("<html><b>Enter payment amount<br/></html>"));
	    sisu.add(new JLabel("<html><b>Calculate Change<br/></html>"));
	    sisu.add(new JLabel("<html><b>Change amount<br/></html>"));
	    sisu.add(new JLabel("<html><b>Accept/Cancel<br/></html>"));
	    
	 // Initialize the textfield
        totalSum = new JTextField();
        paymentAmount = new JTextField();
        changeAmount = new JTextField();
        //acceptCancel = new JTextField();
        
        JPanel sisu2 = new JPanel(new GridLayout(6, 2));
	    sisu2.add(totalSum);
	    sisu2.add(paymentAmount);
	    sisu2.add(CalculateMoney);
	    sisu2.add(changeAmount);
	    sisu2.add(Accept);
	    sisu2.add(Cancel);
        totalSum.setEditable(false);
        changeAmount.setEditable(false);
        
	    	StockItem stockItem = getStockItemByName();
	        if (stockItem != null) {
	        	Integer i = 0;
	        	double Sum = 0;
	            while(i < model.getCurrentPurchaseTableModel().getRowCount()){
	            	Sum += (double) model.getCurrentPurchaseTableModel().getValueAt(i, 4);
	            	i += 1;
	            }
	            String SumNew = String.valueOf(Sum);
	            totalSum.setText(SumNew);
	        } else {
	            reset();
	        }
	        
	    CalculateMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeAmount.setText(CalculateMoneySum());
            }
        });
	    Accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
            	log.info("Date: " +date+ " Price: "+totalSum.getText());
            }
        });


        
	    raam.add(sisu);
	    raam.add(sisu2);
	         raam.setVisible(true); 
	         
	         log.info("Confirm window opened");  
	  }
  
	private String CalculateMoneySum() {
			double payment = Double.parseDouble(paymentAmount.getText());
			double totalsumN = Double.parseDouble(totalSum.getText());
			String Change = String.valueOf(payment-totalsumN);
		return Change;
		}
  
  
  


		private List<StockItem> a; 
  		private JComboBox dropItemMenu;
  		private int lisaHind;
  		private StockItem getStockItemByName() {
  		
  		
      dropItemMenu = new JComboBox();
      lisaHind = 0;
      a=model.getWarehouseTableModel().getTableRows();
      for (StockItem i : a) {
      	dropItemMenu.addItem(i.getName());
//      	//lisaHind.add(i.getPrice().intValue());
      	}
	  
	  
      try {
      	
      	for (StockItem i : a) {
      	if (i.getName() == (String) dropItemMenu.getSelectedItem()){
          int j = i.getId().intValue();
          return model.getWarehouseTableModel().getItemById(j);}
      	}
      	 return null;} 
     
      catch (NumberFormatException ex) {
          return null;
      } catch (NoSuchElementException ex) {
          return null;
      }
      
   
  }

  	    public void fillDialogFields() {
  	       // StockItem stockItem = getStockItemByBarcode();
  	    	StockItem stockItem = getStockItemByName();
  	        if (stockItem != null) {
  	            String priceString = String.valueOf(stockItem.getPrice());
  	            totalSum.setText(priceString);
  	        } else {
  	            reset();
  	        }
  	    }
  	  public void reset() {
  		  totalSum.setText("");
  	  }
  		
  		
  		
  		
  /* === Helper methods that bring the whole purchase-tab to a certain state
   *     when called.
   */

  // switch UI to the state that allows to proceed with the purchase
  private void startNewSale() {
    purchasePane.reset();

    purchasePane.setEnabled(true);
    submitPurchase.setEnabled(true);
    cancelPurchase.setEnabled(true);
    newPurchase.setEnabled(false);
  }

  // switch UI to the state that allows to initiate new purchase
  private void endSale() {
    purchasePane.reset();

    cancelPurchase.setEnabled(false);
    submitPurchase.setEnabled(false);
    newPurchase.setEnabled(true);
    purchasePane.setEnabled(false);
  }




  /* === Next methods just create the layout constraints objects that control the
   *     the layout of different elements in the purchase tab. These definitions are
   *     brought out here to separate contents from layout, and keep the methods
   *     that actually create the components shorter and cleaner.
   */

  private GridBagConstraints getConstraintsForPurchaseMenu() {
    GridBagConstraints gc = new GridBagConstraints();

    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.anchor = GridBagConstraints.NORTH;
    gc.gridwidth = GridBagConstraints.REMAINDER;
    gc.weightx = 1.0d;
    gc.weighty = 0d;

    return gc;
  }


  private GridBagConstraints getConstraintsForPurchasePanel() {
    GridBagConstraints gc = new GridBagConstraints();

    gc.fill = GridBagConstraints.BOTH;
    gc.anchor = GridBagConstraints.NORTH;
    gc.gridwidth = GridBagConstraints.REMAINDER;
    gc.weightx = 1.0d;
    gc.weighty = 1.0;

    return gc;
  }


  // The constraints that control the layout of the buttons in the purchase menu
  private GridBagConstraints getConstraintsForMenuButtons() {
    GridBagConstraints gc = new GridBagConstraints();

    gc.weightx = 0;
    gc.anchor = GridBagConstraints.CENTER;
    gc.gridwidth = GridBagConstraints.RELATIVE;

    return gc;
  }

}
