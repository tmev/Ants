package ee.ut.math.tvt.salessystem.domain.data;



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
}