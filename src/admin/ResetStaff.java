package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import main.DBConnection;
import staff.Alerts;

/**
 * This class is to reset staff passwords
 * 
 * @author 539676 Calum Arthur
 */
public class ResetStaff {
	/**
	 * This method is called each time a staff password needs to be reset This
	 * method is called from the AdminController class
	 * 
	 * @param firstName
	 *            this will be the first name of the staff who needs their password
	 *            reset
	 * @param lastName
	 *            this will be the last name of the staff who needs their password
	 *            reset
	 * @param password
	 *            this will be the new password to be assigned to the staff in the
	 *            data base
	 * @param id
	 *            this will be the id name of the staff who needs their password
	 *            reset
	 */
	public void ResetPassword(String firstName, String lastName, String password, int id) {
		String sql = "UPDATE staffhistory SET password = ? " + "WHERE id = ? AND First_name = ? AND Last_name = ?";
		Alerts alert = new Alerts();
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, password);
			stmt.setInt(2, id);
			stmt.setString(3, firstName);
			stmt.setString(4, lastName);
			stmt.executeUpdate();
			int deleted = stmt.executeUpdate();
			if (deleted == 0) {
				alert.InfoAlert(
						"Staff: " + firstName + " " + lastName + " Not found, Please try a different Staff member",
						" Staff ID : " + id);
				return;
			} else {
				alert.InfoAlert("Staff: " + firstName + " " + lastName + " Password Changed", "Staff ID: " + id);
			}
		} catch (Exception e) {

		}
	}
}
