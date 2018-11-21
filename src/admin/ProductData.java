package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is to create a product data object
 * 
 * @author 539676 Calum Arthur
 */
public class ProductData {

	private StringProperty ID;
	private StringProperty productName;
	private StringProperty description;
	private StringProperty stock;
	private StringProperty price;

	/**
	 * constructor for the ProductData class This method is called from the
	 * AdminController class used in the LoadProductData class
	 * 
	 * @param ID
	 *            this will be the product id from the database to display in the
	 *            tableview(product details interface)
	 * @param productName
	 *            this will be the product name from the database to display in the
	 *            tableview(product details interface)
	 * @param description
	 *            this will be the product description from the database to display
	 *            in the tableview(product details interface)
	 * @param stock
	 *            this will be the product stock from the database to display in the
	 *            tableview(product details interface)
	 * @param price
	 *            this will be the product price from the database to display in the
	 *            tableview(product details interface)
	 */
	public ProductData(String ID, String productName, String description, String stock, String price) {
		this.ID = new SimpleStringProperty(ID);
		this.productName = new SimpleStringProperty(productName);
		this.description = new SimpleStringProperty(description);
		this.stock = new SimpleStringProperty(stock);
		this.price = new SimpleStringProperty(price);
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * products details interface
	 * 
	 * @return returns the value of ID(the products ID)
	 */
	public StringProperty IDProperty() {
		return ID;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * products details interface
	 * 
	 * @return returns the value of product name(the name of a product)
	 */
	public StringProperty productNameProperty() {
		return productName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * products details interface
	 * 
	 * @return returns the value of description(a products description)
	 */
	public StringProperty descriptionProperty() {
		return description;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * products details interface
	 * 
	 * @return returns the value of stock(the stock level of a product)
	 */
	public StringProperty stockProperty() {
		return stock;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * products details interface
	 * 
	 * @return returns the value of price( the price of a products)
	 */
	public StringProperty priceProperty() {
		return price;
	}

}
