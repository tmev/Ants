package ee.ut.math.tvt.salessystem.domain.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * Already bought StockItem. SoldItem duplicates name and price for preserving history. 
 */
@Entity
@Table(name="SOLDITEM")
public class SoldItem implements Cloneable, DisplayableItem {

    private Long id;
    private StockItem stockItem;
    
    private String name;
    private Integer quantity;
    private double price;
    
    public SoldItem(StockItem stockItem, int quantity) {
        this.stockItem = stockItem;
        this.name = stockItem.getName();
        this.price = stockItem.getPrice();
        this.quantity = quantity;
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne()
    @JoinColumn(name = "STOCKITEM_ID")
    public StockItem getStockItem() {
        return stockItem;
    }
    
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @Column(name = "itemprice")
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
   
    @Column(name = "name")
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public double getSum() {
        return price * ((double) quantity);
    }
    public void setSum(double sum) {
    	this.price=price;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }
    private HistorySoldDates historySoldDates;
	public void setHistorySoldDates(HistorySoldDates historySoldDates) {
		this.historySoldDates = historySoldDates;
	}
    
}

