package ee.ut.math.tvt.salessystem.domain.data;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Stock item. Corresponds to the Data Transfer Object design pattern.
 */
@Entity
@Table(name="STOCKITEM")
public class StockItem implements Cloneable, DisplayableItem {
	
    private Long id;
    private String name;
    private double price;
    private String description;
    private int quantity;

    /**
     * Constucts new <code>StockItem</code> with the specified values.
     * @param id barcode id
     * @param name name of the product
     * @param desc description of the product
     * @param price price of the product
     * @return 
     */
   
    
    public StockItem(Long id, String name, String desc, double price) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.price = price;
    }
    
    public StockItem(Long id, String name, String desc, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.price = price;
        this.quantity = quantity;
    }
    public static StockItem StockItemfromArray(ArrayList array){
    	long id1 = (long) array.get(0);
    	String name1 = (String) array.get(1);
    	String description1 = (String) array.get(2);
    	double price1 = (double) array.get(3);
//    	int quantity1 = (int) array.get(4);
    	StockItem returnable = new StockItem(id1, name1, description1, price1);
    	return returnable;
    	
    }

    /**
     * Constructs new  <code>StockItem</code>.
     */
    public StockItem() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
   

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public String toString() {
        return id + " " + name + " " + description + " " + price;
    }

    /**
     * Method for querying the value of a certain column when StockItems are shown
     * as table rows in the SalesSstemTableModel. The order of the columns is:
     * id, name, price, quantity.
     */
    public Object getColumn(int columnIndex) {
        switch(columnIndex) {
            case 0: return id;
            case 1: return name;
            case 2: return new Double(price);
            case 3: return new Integer(quantity);
            default: throw new RuntimeException("invalid column!");
        }
    }
    
    
    public Object clone() {
        StockItem item =
            new StockItem(getId(), getName(), getDescription(), getPrice(), getQuantity());
        return item;
    }
		
}
