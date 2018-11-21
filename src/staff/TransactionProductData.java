package staff;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is to create a product data object this class creates an object
 * with the required fields for product to populate the table view
 * 
 * @author 539676 Calum Arthur
 */
public class TransactionProductData {

	private StringProperty ID;
	private StringProperty name;
	private StringProperty price;

	/**
	 * constructor for the ProductData class used in the LoadProductData class
	 * 
	 * @param ID
	 *            this will be the product id from the database to display in the
	 *            table view(transactions interface)
	 * @param name
	 *            this will be the product name from the database to display in the
	 *            table view(transactions interface)
	 * @param price
	 *            this will be the price from the database to display in the table
	 *            view(transactions interface)
	 * 
	 */
	public TransactionProductData(String ID, String name, String price) {
		this.ID = new SimpleStringProperty(ID);
		this.name = new SimpleStringProperty(name);
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
	 * @return returns the value of name(the name of a product)
	 */
	public StringProperty nameProperty() {
		return name;
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

	@Override
	public String toString() {
		return "[ID=" + ID + ", name=" + name + ", price=" + price + "]";
	}

}
