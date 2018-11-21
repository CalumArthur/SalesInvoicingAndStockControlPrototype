package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is to create a customerdata object this class creates an object
 * with the required fields for customer to populate the table view
 * 
 * @author 539676 Calum Arthur
 */
public class CustomerData {

	private StringProperty ID;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty email;
	private StringProperty contactNumber;
	private StringProperty address;
	// private StringProperty postCode;

	/**
	 * constructor for the CusomterData class used in the LoadCustomerData class
	 * This method is called from the AdminController class
	 * 
	 * @param ID
	 *            this will be the customer id from the database to display in the
	 *            tableview(customer details interface)
	 * @param firstName
	 *            this will be the customer first name from the database to display
	 *            in the tableview(customer details interface)
	 * @param lastName
	 *            this will be the customer last name from the database to display
	 *            in the tableview(customer details interface)
	 * @param email
	 *            this will be the customer email from the database to display in
	 *            the tableview(customer details interface)
	 * @param contactNumber
	 *            this will be the customer contact number from the database to
	 *            display in the tableview(customer details interface)
	 * @param address
	 *            this will be the customer address from the database to display in
	 *            the tableview(customer details interface)
	 * @param postCode
	 *            this will be the customer post code from the database to display
	 *            in the tableview(customer details interface)
	 */
	public CustomerData(String ID, String firstName, String lastName, String email, String contactNumber,
			String address, String postCode) {
		this.ID = new SimpleStringProperty(ID);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.email = new SimpleStringProperty(email);
		this.contactNumber = new SimpleStringProperty(contactNumber);
		this.address = new SimpleStringProperty(address);
		// this.postCode = new SimpleStringProperty(postCode);

	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * customer details interface
	 * 
	 * @return returns the value of ID(a customers ID)
	 */
	public StringProperty IDProperty() {
		return ID;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * customer details interface
	 * 
	 * @return returns the value of firstName(a customers firstName)
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * customer details interface
	 * 
	 * @return returns the value of lastName(a customers lastName)
	 */
	public StringProperty lastNameProperty() {
		return lastName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * customer details interface
	 * 
	 * @return returns the value of email(a customers email)
	 */
	public StringProperty emailProperty() {
		return email;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * customer details interface
	 * 
	 * @return returns the value of contactNUmber(a customers contact number)
	 */
	public StringProperty contactNumberProperty() {
		return contactNumber;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * customer details interface
	 * 
	 * @return returns the value of address (a customers address)
	 */
	public StringProperty addressProperty() {
		return address;
	}

	@Override
	public String toString() {
		return "CustomerData [ID=" + ID + "]";
	}

}
