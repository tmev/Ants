package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistorySoldDates;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class HistoryDatesTableModelTest {

	HistorySoldDates sale1;
	HistorySoldDates sale2;
	
	@Before
	public void setUp() {
		SoldItem soldItem1 = new SoldItem(
				new StockItem((long) 1, "Lauaviin", "", 3.5, 100), 2);
		SoldItem soldItem2 = new SoldItem(
				new StockItem((long) 2, "Hapukurk", "", 1.5, 10), 1);
		
		sale1 = new HistorySoldDates();
		sale1.addSoldItem(soldItem1);
		
		sale2 = new HistorySoldDates();
		sale2.addSoldItem(soldItem1);
		sale2.addSoldItem(soldItem2);
	}
	
	@Test
	public void testHasCorrectNrOfSales() {
		HistoryDatesTableModel historyTableModel = new HistoryDatesTableModel();
		
		assertEquals(0, historyTableModel.getRowCount());
		
		historyTableModel.addItem(sale1);
		assertEquals(1, historyTableModel.getRowCount());
		
		historyTableModel.addItem(sale2);
		assertEquals(2, historyTableModel.getRowCount());
	}

	

	
	@Test
	public void testGetColumnName() {
		HistoryDatesTableModel historyTableModel = new HistoryDatesTableModel();
		
		assertTrue(historyTableModel.getColumnName(0).equals("Date") &&
				historyTableModel.getColumnName(1).equals("Price"));
	}
	
}
