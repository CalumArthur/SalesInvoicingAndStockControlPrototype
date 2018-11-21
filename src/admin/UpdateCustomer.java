package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.DBConnection;
import staff.Alerts;

/**
 * The role of this class is to add a new customer to the customers table
 * 
 * @author 539676 Calum Arthur
 */
public class UpdateCustomer {

	/**
	 * This method is called each time a new customer needs to be added to the
	 * database This method is called from the AdminController class
	 * 
	 * @param ID
	 *            this will be the id of the customer(0 is passed though as the
	 *            database auto increments the id)
	 * @param firstName
	 *            input from the application from the FirstName field to be stored
	 *            as first_name in the customer table
	 * @param lastName
	 *            input from the application from the LastName field to be stored as
	 *            last_name in the customer table
	 * @param address
	 *            input from the application from the Address field to be stored as
	 *            address in the customer table
	 * @param email
	 *            input from the application from the Email field to be stored as
	 *            email in the customer table
	 * @param contactNo
	 *            input from the application from the ContactNo field to be stored
	 *            as contact_number in the customer table
	 * @param postCode
	 *            input from the application from the PostCode field to be stored as
	 *            post_code in the customer table
	 */
	public void Update(String ID, String firstName, String lastName, String address, String email, String contactNo,
			String postCode) {
		String sql = "UPDATE customers_history SET first_name = ?, last_name = ?, address = ?, email = ?,"
				+ "contact_number = ?, post_code = ? WHERE id = ?";
		Alerts alert = new Alerts();
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, address);
			stmt.setString(4, email);
			stmt.setString(5, contactNo);
			stmt.setString(6, postCode);
			stmt.setString(7, ID);
			stmt.executeUpdate();
			alert.InfoAlert("Customer: " + firstName + " " + lastName + " Updated", "Customer ID: " + ID);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1406) {
				alert.InfoAlert("Data input is too long", "Please check hand book");
				return;
			}
			e.printStackTrace();
		}
	}
}
