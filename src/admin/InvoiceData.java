package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is to create a InvoiceData object this class creates an object
 * with the required fields for invoice to populate the table view
 * 
 * @author 539676 Calum Arthur
 */
public class InvoiceData {

	private StringProperty prodID;
	private StringProperty quantity;
	private StringProperty description;
	private StringProperty price;
	private StringProperty discount;
	private StringProperty total;
	// private StringProperty postCode;

	/**
	 * /** constructor for the InvoiceData class used in the LoadInvoiceData class
	 * This method is called from the AdminController class
	 * 
	 * @param prodID
	 *            this will be the product id from the database to display in the
	 *            table view(invoice information interface)
	 * @param quantity
	 *            this will be the amount of product id from the database to display
	 *            in the table view(invoice information interface)
	 * @param description
	 *            this will be the product id description from the database to
	 *            display in the table view(invoice information interface)
	 * @param price
	 *            this will be the product id price from the database to display in
	 *            the table view(invoice information interface)
	 * @param discount
	 *            this will be the discount(if there was any) from the database to
	 *            display in the table view(invoice information interface)
	 * @param total
	 *            this will be the total for the invoice line from the database to
	 *            display in the table view(invoice information interface)
	 */
	public InvoiceData(String prodID, String quantity, String description, String price, String discount,
			String total) {

		this.prodID = new SimpleStringProperty(prodID);
		this.quantity = new SimpleStringProperty(quantity);
		this.description = new SimpleStringProperty(description);
		this.price = new SimpleStringProperty(price);
		this.discount = new SimpleStringProperty(discount);
		this.total = new SimpleStringProperty(total);
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of prodID(the id of a product in the invoice)
	 */
	public StringProperty prodIDProperty() {
		return prodID;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of quantity(amount of product from invoice)
	 */
	public StringProperty quantityProperty() {
		return quantity;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of description(details about product from invoice)
	 */
	public StringProperty descriptionProperty() {
		return description;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of price (price of product from invoice)
	 */
	public StringProperty priceProperty() {
		return price;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of discount (discount from invoice)
	 */
	public StringProperty discountProperty() {
		return discount;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of total (total of line from invoice)
	 */
	public StringProperty totalProperty() {
		return total;
	}

}
