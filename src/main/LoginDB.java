package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

/**
 * This class is the login method for staff and admin
 * 
 * @author 539676 Calum Arthur
 */
public class LoginDB {

	/**
	 * method to return true if the parameters match and the user will be loged into
	 * either staff or admin called from LoginController.
	 * 
	 * @param user
	 *            this will be the inputed data checked against the username field
	 *            in the database
	 * @param pass
	 *            this will be the inputed data checked against the password field
	 *            in the database
	 * @param type
	 *            this will be the inputed data checked against the admin field in
	 *            the database(boolean type access)
	 * @return this will return true if the userName, password and type all get a
	 *         result from the database
	 */
	public boolean Login(String user, String pass, boolean type) {
		String sql = "SELECT * FROM staffhistory where Username = ? and Password = ? and Admin = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pr = conn.prepareStatement(sql);) {

			pr.setString(1, user);
			pr.setString(2, pass);
			pr.setBoolean(3, type);
			ResultSet rs = pr.executeQuery();

			if (rs.next()) {
				return true;
			}
			return false;
		}

		catch (SQLException e) {
			System.out.println("Not connected");
			return false;
		}
	}
}