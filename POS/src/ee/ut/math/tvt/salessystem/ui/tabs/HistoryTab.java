package ee.ut.math.tvt.salessystem.ui.tabs;

import javax.swing.BorderFactory;
import javax.swing.table.AbstractTableModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */

public class HistoryTab{
	
	private SalesSystemModel model1;
	
	

	public Component draw() {
		{
			JPanel panel = new JPanel();
		    
		    Object[][] Data = {{"01.01.1970", "00:00:00","100"},{"01.01.1980", "00:00:10","1000"}};
			
			final String[] ColumnNamesDetails = {"Name", "Amount", "Price", "Sum"};
			final String[][][] DetailsDataAll = {{{"","","",""},{"","","",""}},{{"","","",""},{"","","",""}}};
			
			panel.add(drawHistoryDatesPane());
			return panel;
			
		}
	}
	
	 private JComponent drawHistoryDatesPane() {

	        // Create the basketPane
	        JPanel datesPane = new JPanel();
	        datesPane.setLayout(new GridBagLayout());
	        datesPane.setBorder(BorderFactory.createTitledBorder("Shopping cart"));

	        // Create the table, put it inside a scollPane,
	        // and add the scrollPane to the basketPanel.
	        JTable table = new JTable(model1.getHistoryDatesTableModel());
	        JScrollPane scrollPane = new JScrollPane(table);

	        datesPane.add(scrollPane, getConstraintsForHistoryTableDatesModel());

	        return datesPane;
	    }
	
	  private GridBagConstraints getConstraintsForHistoryTableDatesModel() {
		    GridBagConstraints gc = new GridBagConstraints();

		    gc.fill = GridBagConstraints.BOTH;
		    gc.anchor = GridBagConstraints.NORTH;
		    gc.gridwidth = GridBagConstraints.REMAINDER;
		    gc.weightx = 1.0d;
		    gc.weighty = 1.0;

		    return gc;
		  }
	
}