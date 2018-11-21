package staff;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is to create a InvoiceData object this class creates an object
 * with the required fields for invoice to populate the table view
 * 
 * @author 539676 Calum Arthur
 */
public class NewTransactionData {

	private StringProperty prodID;
	private StringProperty description;
	private StringProperty price;
	private StringProperty quantity;
	private StringProperty total;

	/**
	 * /** constructor for the InvoiceData class used in the LoadInvoiceData class
	 * 
	 * @param prodID
	 *            this will be the product id from the database to display in the
	 *            table view(Transaction interface)
	 * @param quantity
	 *            this will be the amount of product id from the database to display
	 *            in the table view(Transaction interface)
	 * @param description
	 *            this will be the product id description from the database to
	 *            display in the table view(Transaction interface)
	 * @param price
	 *            this will be the product id price from the database to display in
	 *            the table view(Transaction interface)
	 * @param total
	 *            this will be the total for the invoice line from the database to
	 *            display in the table view(Transaction interface)
	 */
	public NewTransactionData(String prodID, String quantity, String description, String price, String total) {

		this.prodID = new SimpleStringProperty(prodID);
		this.description = new SimpleStringProperty(description);
		this.price = new SimpleStringProperty(price);
		this.quantity = new SimpleStringProperty(quantity);
		this.total = new SimpleStringProperty(total);

	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * transaction interface
	 * 
	 * @return returns the value of prodID(the id of a product in the Transaction)
	 */
	public StringProperty prodIDProperty() {
		return prodID;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * transaction interface
	 * 
	 * @return returns the value of description(details about product from
	 *         Transaction)
	 */
	public StringProperty descriptionProperty() {
		return description;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * transaction interface
	 * 
	 * @return returns the value of price (price of product from Transaction)
	 */
	public StringProperty priceProperty() {
		return price;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * transaction interface
	 * 
	 * @return returns the value of discount (discount from Transaction)
	 */

	/**
	 * method to get the value of the String property to populate the columns in the
	 * transaction interface
	 * 
	 * @return returns the value of quantity (quantity of an item)
	 */
	public StringProperty quantityProperty() {
		return quantity;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * transaction interface
	 * 
	 * @return returns the value of total (total row)
	 */
	public StringProperty totalProperty() {
		return total;
	}

	public void setQuantity(String newValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "NewTransactionData [prodID=" + prodID + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}
