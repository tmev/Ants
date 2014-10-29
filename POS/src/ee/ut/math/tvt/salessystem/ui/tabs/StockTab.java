package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import javax.swing.JComponent;


public class StockTab {
	private JTextField StockID;
	private JTextField StockName;
	private JTextField StockDescription;
	private JTextField StockPrice;
	private JTextField StockQuantity;
	private JButton addItem;
  
	
	public StockItem CreateStockItem(){
		Long id = Long.parseLong(StockID.getText());
		String name = StockName.getText();
		String desc = StockDescription.getText();
		double price = Double.parseDouble(StockPrice.getText());
		Integer quantity = Integer.parseInt(StockQuantity.getText());
		StockItem stockItem = new StockItem(id, name, desc, price, quantity);
		return stockItem;
	}
	
	
	public Component addStockItem(){
	  JPanel addStock = new JPanel();
	  addStock.setLayout(new GridLayout(1, 1));
	  addStock.setBorder(BorderFactory.createTitledBorder("Add Stock "));
	  StockID = new JTextField();
	  StockName = new JTextField();
	  StockDescription = new JTextField();
	  StockPrice = new JTextField();
	  StockQuantity = new JTextField();
	  addItem = new JButton("Add");
	  addItem.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  model.getWarehouseTableModel().addItem(CreateStockItem());;
          }
      });
	  addStock.add(addItem);
	  addStock.add(new JLabel(" ID:"));
	  addStock.add(StockID);
	  addStock.add(new JLabel(" Name:"));
	  addStock.add(StockName);
	  addStock.add(new JLabel(" Desc:"));
	  addStock.add(StockDescription);
	  addStock.add(new JLabel(" Price:"));
	  addStock.add(StockPrice);
	  addStock.add(new JLabel(" Quantity:"));
	  addStock.add(StockQuantity);
	  
	  return addStock;
  }
  

  private SalesSystemModel model;

  public StockTab(SalesSystemModel model) {
    this.model = model;
  }

  // warehouse stock tab - consists of a menu and a table
  public Component draw() {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    panel.setLayout(gb);

    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.anchor = GridBagConstraints.NORTH;
    gc.gridwidth = GridBagConstraints.REMAINDER;
    gc.weightx = 1.0d;
    gc.weighty = 0d;

    panel.add(drawStockMenuPane(), gc);

    gc.weighty = 1.0;
    gc.fill = GridBagConstraints.BOTH;
    panel.add(drawStockMainPane(), gc);
    return panel;
  }

  // warehouse menu
  private Component drawStockMenuPane() {
    JPanel panel = new JPanel();

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();

    panel.setLayout(gb);

    gc.anchor = GridBagConstraints.NORTHWEST;
    gc.weightx = 0;

    
    gc.gridwidth = GridBagConstraints.RELATIVE;
    gc.weightx = 1.0;
    panel.add(addStockItem());
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    return panel;
  }

  // table of the wareshouse stock
  private Component drawStockMainPane() {
    JPanel panel = new JPanel();

    JTable table = new JTable(model.getWarehouseTableModel());
    
    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);

    JScrollPane scrollPane = new JScrollPane(table);

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();
    gc.fill = GridBagConstraints.BOTH;
    gc.weightx = 1.0;
    gc.weighty = 1.0;

    panel.setLayout(gb);
    panel.add(scrollPane, gc);

    panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
    return panel;
  }

}









