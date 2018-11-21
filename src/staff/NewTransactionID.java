package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.DBConnection;

/**
 * This class is to get the next invoice ID
 * 
 * @author 539676 Calum Arthur
 */
public class NewTransactionID {

	String id = "";

	/**
	 * This class will return the last invoice ID
	 * 
	 * @param sql
	 *            the SQL statement to be executed
	 * @return the value of the last invoice ID in the database
	 */
	public int NewID(String sql) {
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getString(1);
				return Integer.parseInt(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}