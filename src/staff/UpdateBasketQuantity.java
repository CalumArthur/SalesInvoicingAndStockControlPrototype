package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.DBConnection;

/**
 * This class is to update the quantity for an item in the basket This method
 * calculates the total for the row
 * 
 * @author 539676 Calum Arthur
 *
 */
public class UpdateBasketQuantity {

	/**
	 * This method is to calculate the total for the row this method is called from
	 * the StaffController this method calls the UpdateBasketFinal method
	 * 
	 * @param sql
	 *            the SQL statement to be executed
	 * @param quantity
	 *            the new quantity to be updated
	 * @param id
	 *            the id of the row that will be updated
	 */
	public void UpdateBasket(String sql, String quantity, int id) {
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String price = rs.getString(1);
				int newPrice = (Integer.parseInt(quantity) * Integer.parseInt(price));
				UpdateBasketFinal(newPrice, quantity, id);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * This method updates the basket with the new values for quantity and for total
	 * this method is called each time the UpdateBasket method is called
	 * 
	 * @param newPrice
	 *            total for the order row
	 * @param quantity
	 *            the amount selected by the user
	 * @param id
	 *            the id of the row to be updated
	 */
	public void UpdateBasketFinal(int newPrice, String quantity, int id) {
		String sql = "UPDATE basket SET quantity = ?, total = ? WHERE item_number = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, quantity);
			stmt.setInt(2, newPrice);
			stmt.setInt(3, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
