package ee.ut.math.tvt.salessystem.domain.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * Already bought StockItem. SoldItem duplicates name and price for preserving history. 
 */
public class HistorySoldDates implements DisplayableItem{

    private Long Date;
    private double price;
    
    public HistorySoldDates(Long date, double price) {
        this.Date = date;
        this.price = price;
    }
    
    
    public Long getDate() {
        return Date;
    }
    
    public double getPrice() {
        return price;
}
	@Override
	public Long getId() {
		return null;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<SoldItem> soldItems;
	private Date date;
	public HistorySoldDates() {
		soldItems = new ArrayList<SoldItem>();
		date = new Date();
	}
	public void addSoldItem(SoldItem soldItem) {
		soldItems.add(soldItem);
		soldItem.setHistorySoldDates(this);
	}
	
	
	public HistorySoldDates(List<SoldItem> soldItems) {
		this.soldItems = soldItems;
		this.date = new Date();
		for (SoldItem soldItem : soldItems)
			soldItem.setHistorySoldDates(this);
	}
	public int getNrOfSoldItems() {
		return soldItems.size();
	}
	
	public double getSum() {
		double sum = 0.0;
		for (SoldItem soldItem: soldItems)
			sum += soldItem.getSum();
		
		return sum;
	}
	
	
	
	
	
	
}