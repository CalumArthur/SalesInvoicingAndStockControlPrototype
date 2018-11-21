package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is to create a SupplierData object this class creates an object
 * with the required fields for customer to populate the table view
 * 
 * @author 539676 Calum Arthur
 */
public class SupplierData {

	private StringProperty ID;
	private StringProperty companyName;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty contactNumber;

	/**
	 * constructor for the CusomterData class used in the LoadCustomerData class
	 * This method is called from the AdminController class
	 * 
	 * @param ID
	 *            this will be the supplier id from the database to display in the
	 *            table view(Supplier details interface)
	 * @param companyName
	 *            this will be the supplier company name from the database to
	 *            display in the table view(Supplier details interface)
	 * @param firstName
	 *            this will be the supplier first name from the database to display
	 *            in the table view(Supplier details interface)
	 * @param lastName
	 *            this will be the supplier last name from the database to display
	 *            in the table view(Supplier details interface)
	 * @param contactNumber
	 *            this will be the supplier contact number from the database to
	 *            display in the table view(Supplier details interface)
	 */
	public SupplierData(String ID, String companyName, String firstName, String lastName, String contactNumber) {
		this.ID = new SimpleStringProperty(ID);
		this.companyName = new SimpleStringProperty(companyName);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.contactNumber = new SimpleStringProperty(contactNumber);
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * supplier details interface
	 * 
	 * @return returns the value of ID(a supplier ID)
	 */
	public StringProperty IDProperty() {
		return ID;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * supplier details interface
	 * 
	 * @return returns the value of firstName(a supplier firstName)
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * supplier details interface
	 * 
	 * @return returns the value of lastName(a supplier lastName)
	 */
	public StringProperty lastNameProperty() {
		return lastName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * supplier details interface
	 * 
	 * @return returns the value of companyName(a supplier companyName)
	 */
	public StringProperty companyNameProperty() {
		return companyName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * supplier details interface
	 * 
	 * @return returns the value of contactNUmber(a suppliers contact number)
	 */
	public StringProperty contactNumberProperty() {
		return contactNumber;
	}
}
