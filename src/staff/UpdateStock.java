package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;

import main.DBConnection;

/**
 * This class is to create a new invoice
 * 
 * @author 539676 Calum Arthur
 *
 */
public class UpdateStock {

	/**
	 * this method is to update the stock in the inventory table after a sale has
	 * been made
	 * 
	 * @param stock
	 *            the amount of stock sold
	 * @param id
	 *            the id of the stock being sold(product id)
	 */
	public void Update(int stock, String id) {
		String sql = "UPDATE inventory SET stock_amount = (stock_amount - ?) WHERE id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, stock);
			stmt.setString(2, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
