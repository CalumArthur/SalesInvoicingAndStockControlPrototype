package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.DBConnection;
import staff.Alerts;

/**
 * The role of this class is to add a new staff to the staff table this classes
 * includes methods to create a user name for the new staff from their name + id
 * 
 * @author 539676 Calum Arthur
 */
public class AddNewStaff {
	/**
	 * This method is called each time a new staff needs to be added to the database
	 * This method is called from the AdminController class this method calls the
	 * getID method
	 * 
	 * @param ID
	 *            this will be the id of the staff(0 is passed though as the
	 *            database auto increments the id)
	 * @param firstName
	 *            input from the application from the FirstName field to be stored
	 *            as first_name in the staff table
	 * @param sql
	 *            the SQL statement to be executed
	 * 
	 * @param lastName
	 *            input from the application from the LastName field to be stored as
	 *            last_name in the customer table
	 * @param password
	 *            input from the application from the password field to be stored as
	 *            Password in the customer table
	 * @param contactNo
	 *            input from the application from the ContactNo field to be stored
	 *            as contact_number in the customer table
	 * @param userName
	 *            the username is set later in this class(bob is passed though as a
	 *            default value)
	 * @param blocked
	 *            this will be a boolean to check if an account is blocked(0 is
	 *            passed though as default)
	 * @param admin
	 *            this will be a boolean to check if an account is admin/staff(0 is
	 *            passed though as default as only staff accounts can be created)
	 */
	public void AddStaff(int ID, String sql, String firstName, String lastName, String password, String contactNo,
			String userName, boolean blocked, boolean admin) {
		Alerts alert = new Alerts();
		String firstName2 = firstName;
		String lastName2 = lastName;
		String password2 = password;
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, ID);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, userName);
			stmt.setString(5, password);
			stmt.setBoolean(6, blocked);
			stmt.setBoolean(7, admin);
			stmt.setString(8, contactNo);
			stmt.execute();
			getID(firstName2, lastName2, password2);
			if (userName == "bob") {
				alert.InfoAlert("New Staff : " + firstName + " " + lastName + " Added", "");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * this method gets the ID of the staff that was just added to be used to create
	 * the username this method calls the Setusername method
	 * 
	 * @param firstName
	 *            the first name of the user being added
	 * @param lastName
	 *            the last name of the user being added
	 * @param password
	 *            the password of the user being added
	 */
	public void getID(String firstName, String lastName, String password) {
		String sql2 = "SELECT ID from staffhistory WHERE First_name = ? AND Last_name = ? AND Password = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql2);) {
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, password);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String firstName2 = firstName;
				SetUsername(id, firstName2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is to create a username out of the name + id of the staff this
	 * method updates the existing entry of the staff
	 * 
	 * @param id
	 *            this is the id of the staff to be updated
	 * @param firstName
	 *            this is the new username for the staff to be updated
	 */
	public void SetUsername(int id, String firstName) {
		String sql2 = "UPDATE staffhistory SET Username = ? " + "WHERE id = ?";
		String nameHolder = firstName;
		String idHolder = Integer.toString(id);
		String newUsername = nameHolder + idHolder;
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql2);) {
			stmt.setString(1, newUsername);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
