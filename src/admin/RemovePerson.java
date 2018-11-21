package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.DBConnection;
import staff.Alerts;

/**
 * This class is to remove a person from the database
 * 
 * 
 * @author 539676 Calum Arthur
 */
public class RemovePerson {
	/**
	 * This method is called each time a person needs to be removed from the
	 * database This method is called from the AdminController class
	 * 
	 * @param id
	 *            this will be the id of the person to be removed
	 * @param firstName
	 *            this will be the first name of the person to be removed
	 * @param lastName
	 *            this will be the last name of the person to be removed
	 * @param sql
	 *            this will be the structure of the sql statement to let the data
	 *            base which table the data will be removed from
	 */
	public void DeleteUser(int id, String firstName, String lastName, String sql) {

		Alerts alert = new Alerts();
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			int deleted = stmt.executeUpdate();
			if (deleted == 0) {
				alert.InfoAlert(
						"Customer: " + firstName + " " + lastName + " Not found, Please try a different customer",
						" Customer ID : " + id);
				return;
			} else {
				alert.InfoAlert("Customer: " + firstName + " " + lastName + " Removed", " Customer ID : " + id);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
