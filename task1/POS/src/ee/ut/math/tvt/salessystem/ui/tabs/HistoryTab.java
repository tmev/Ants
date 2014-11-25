package ee.ut.math.tvt.salessystem.ui.tabs;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab{

	public Component draw() {
		{
			String[] ColumnNames = {"Date", "Time", "Price"};
			Object[][] Data = {{"01.01.1970", "00:00:00","1.11"},{"01.01.1980", "00:00:10","1.12"},
					{"01.01.1990", "00:00:10","1.13"},{"01.01.2000", "00:00:10","1.14"},{"01.01.2010", "00:00:10","1.15"}};
			JTable historyTable = new JTable(Data, ColumnNames);
			
			String[] ColumnNamesDetails = {"Name", "Amount", "Price", "Sum"};
			Object[][] DetailData = {{"","","",""}};
			JTable historyTableDetails = new JTable(DetailData, ColumnNamesDetails);
			
			JPanel frame = new JPanel();
			frame.setLayout(new GridLayout(2,1));
		    JScrollPane scrollPane = new JScrollPane(historyTable);
		    JScrollPane scrollPaneDetail = new JScrollPane(historyTableDetails);
	        frame.setBorder(BorderFactory.createTitledBorder("History"));
		    frame.add(scrollPane);
		    frame.add(scrollPaneDetail);
		    frame.setVisible(true);
			return frame;
		}
	}
}