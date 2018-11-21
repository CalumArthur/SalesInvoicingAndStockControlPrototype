package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is to create a staff data object this class creates an object with
 * the required fields for staff to populate the table view
 * 
 * @author 539676 Calum Arthur
 */
public class StaffData {
	private StringProperty ID;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty userName;
	private StringProperty blocked;
	private StringProperty contactNumber;
	// private StringProperty admin;
	// private StringProperty password;

	/**
	 * constructor for the StaffData class used in the LoadStaffData class This
	 * method is called from the AdminController class
	 * 
	 * @param ID
	 *            this will be the staff id from the database to display in the
	 *            table view(product details interface)
	 * @param firstName
	 *            this will be the first name from the database to display in the
	 *            table view(product details interface)
	 * @param lastName
	 *            this will be the last name id from the database to display in the
	 *            table view(product details interface)
	 * @param userName
	 *            this will be the user name from the database to display in the
	 *            table view(product details interface)
	 * @param blocked
	 *            this will be the blocked value from the database to display in the
	 *            table view(product details interface)
	 * @param contactNumber
	 *            this will be the contact number from the database to display in
	 *            the tableview(product details interface)
	 * @param admin
	 *            this will be the admin value from the database to display in the
	 *            table view(product details interface)
	 * @param password
	 *            this will be the password from the database to display in the
	 *            table view(product details interface)
	 */
	public StaffData(String ID, String firstName, String lastName, String userName, String blocked,
			String contactNumber, String admin, String password) {
		this.ID = new SimpleStringProperty(ID);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.userName = new SimpleStringProperty(userName);
		this.blocked = new SimpleStringProperty(blocked);
		this.contactNumber = new SimpleStringProperty(contactNumber);
		// this.admin= new SimpleStringProperty(admin);
		// this.password = new SimpleStringProperty(password);
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of id(a staff id)
	 */
	public StringProperty IDProperty() {
		return ID;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of firstName(a staff first name)
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of lastName(a staff last name)
	 */
	public StringProperty lastNameProperty() {
		return lastName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of userName(a staff user Name)
	 */
	public StringProperty userNameProperty() {
		return userName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of blocked(if a staff is blocked or not)
	 */
	public StringProperty blockedProperty() {
		return blocked;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of contactNumber(a staff contact number)
	 */
	public StringProperty contactNumberProperty() {
		return contactNumber;
	}

	@Override
	public String toString() {
		return "StaffData [ID=" + ID + "]";
	}

}
