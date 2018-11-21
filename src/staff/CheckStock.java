package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.DBConnection;

/**
 * This class is to check there is enough stock for the sale
 * 
 * @author 539676 Calum Arthur
 *
 */
public class CheckStock {
	/**
	 * This method is to check the stock of the item in the basked returns true if
	 * there is enough stock for the order
	 * 
	 * @param stock
	 *            the amount of stock required for the purchase
	 * @param id
	 *            of the product
	 * @return returns true if there is enough stock
	 */
	public boolean StockAmount(int stock, String id) {
		String sql = "SELECT stock_amount FROM inventory WHERE id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if ((rs.getInt(1) - stock) <= 0) {
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}
}
