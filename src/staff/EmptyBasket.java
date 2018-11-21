package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.DBConnection;

/**
 * This class is to remove all data from the basket table
 * 
 * 
 * @author 539676 Calum Arthur
 */
public class EmptyBasket {

	/**
	 * This method is called each time a staff hits the clear button or the sale is
	 * processed This method is called from the StaffContoller class
	 */
	public void Empty() {

		String sql = "DELETE FROM basket";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
