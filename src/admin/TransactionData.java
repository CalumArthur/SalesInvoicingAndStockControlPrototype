package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is to create a transaction data object this class creates an
 * object with the required fields for staff to populate the table view
 * 
 * @author 539676 Calum Arthur
 */
public class TransactionData {

	private StringProperty invID;
	private StringProperty custFirstName;
	private StringProperty custLastName;
	private StringProperty Date;
	private StringProperty Total;
	private StringProperty StaffName;
	private StringProperty StaffID;

	/**
	 * constructor for the TransactionData class used in the
	 * LoadTransactionDataclass This method is called from the AdminController class
	 * 
	 * @param invID
	 *            this will be the invoice id from the database to display in the
	 *            table view(transaction logs interface)
	 * @param custFirstName
	 *            this will be the customer first name from the database to display
	 *            in the table view(transaction logs interface)
	 * @param custLastName
	 *            this will be the customer last name from the database to display
	 *            in the table view(transaction logs interface)
	 * @param Date
	 *            this will be the date from the database to display in the table
	 *            view(transaction logs interface)
	 * @param Total
	 *            this will be the total from the database to display in the table
	 *            view(transaction logs interface)
	 * @param StaffName
	 *            this will be the staff name from the database to display in the
	 *            table view(transaction logs interface)
	 * @param StaffID
	 *            this will be the staff id from the database to display in the
	 *            table view(transaction logs interface)
	 */
	public TransactionData(String invID, String custFirstName, String custLastName, String Date, String Total,
			String StaffName, String StaffID) {

		this.invID = new SimpleStringProperty(invID);
		this.custFirstName = new SimpleStringProperty(custFirstName);
		this.custLastName = new SimpleStringProperty(custLastName);
		this.Date = new SimpleStringProperty(Date);
		this.Total = new SimpleStringProperty(Total);
		this.StaffName = new SimpleStringProperty(StaffName);
		this.StaffID = new SimpleStringProperty(StaffID);
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of invID(the id of the invoice)
	 */
	public StringProperty invIDProperty() {
		return invID;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of custFirstName(customer first name for the
	 *         invoice)
	 */
	public StringProperty custFirstNameProperty() {
		return custFirstName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of custLastName((customer last name for the
	 *         invoice)
	 */
	public StringProperty custLastNameProperty() {
		return custLastName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of Date (Date from the invoice)
	 */
	public StringProperty DateProperty() {
		return Date;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of Total (Total from invoice)
	 */
	public StringProperty TotalProperty() {
		return Total;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of StaffName (StaffName who made the sale for the
	 *         invoice)
	 */
	public StringProperty StaffNameProperty() {
		return StaffName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * invoice information interface
	 * 
	 * @return returns the value of StaffID (StaffID who made the sale for the
	 *         invoice)
	 */
	public StringProperty StaffIDProperty() {
		return StaffID;
	}

	@Override
	public String toString() {
		return " " + invID;
	}

}
