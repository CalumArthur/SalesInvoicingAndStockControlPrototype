package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.DBConnection;

/**
 * This class is to get the ID of the staff logged in
 * 
 * @author 539676 Calum Arthur
 */
public class GetStaffID {

	/**
	 * This method will return the ID of the staff logged in
	 * This method is called from the StaffController class
	 * 
	 * @param sql
	 *            the SQL statement to be executed
	 * @param userName
	 *            the user name for the staff id to be found
	 * @return retuns the value of the staff id
	 */
	public int StaffID(String sql, String userName) {
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return Integer.parseInt(rs.getString(1));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}
