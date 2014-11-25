package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HistorySoldDatesTest {

	SoldItem soldItem;
	
	@Before
	public void setUp() {
		soldItem = new SoldItem(
				new StockItem((long) 1, "Lauaviin", "", 3.5, 100), 2);
	}
	
	@Test
	public void testAddSoldItem() {
		HistorySoldDates sale = new HistorySoldDates();
		sale.addSoldItem(soldItem);
		
		assertEquals(sale.getNrOfSoldItems(), 1);
	}
	
	@Test
	public void testGetSumWithNoItems() {
		HistorySoldDates sale = new HistorySoldDates();
		
		assertEquals(0.0, sale.getSum(), 0.0001);
	}
	
	@Test
	public void testGetSumWithOneItem() {
		HistorySoldDates sale = new HistorySoldDates();
		sale.addSoldItem(soldItem);
		
		assertEquals(7.0, sale.getSum(), 0.0001);
	}
	
	@Test
	public void testGetSumWithMultipleItems() {
		HistorySoldDates sale = new HistorySoldDates();
		sale.addSoldItem(soldItem);
		sale.addSoldItem(soldItem);
		
		assertEquals(14.0, sale.getSum(), 0.0001);
	}
	
}
