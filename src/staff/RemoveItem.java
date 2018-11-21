package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.DBConnection;

/**
 * This class is to remove a item from the basket
 * 
 * 
 * @author 539676 Calum Arthur
 */
public class RemoveItem {
	/**
	 * This method is called each time a item needs to be removed from the basket
	 * This method is called from the StaffContoller class
	 * 
	 * @param id
	 *            this will be the id of the item to be removed
	 * @param sql
	 *            this will be the structure of the sql statement to let the data
	 *            base which table the data will be removed from
	 */
	public void RmvItm(int id, String sql) {

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
