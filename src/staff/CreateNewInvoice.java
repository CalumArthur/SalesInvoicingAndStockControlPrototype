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
public class CreateNewInvoice {

	/**
	 * This method is to add a new invoice to the database
	 * 
	 * @param id
	 *            the id of the invoice
	 * @param staffId
	 *            the id of the staff who made the sale
	 * @param custId
	 *            the id of the customer
	 * @param prodId
	 *            the id of the product being sold
	 * @param quantity
	 *            the amount of the product
	 * @param total
	 *            the total of the sale
	 * @param discount
	 *            the amount of discount
	 * @param date
	 *            the date of the sale(sysdate)
	 */
	public void addNewRow(String id, String staffId, String custId, String prodId, String quantity, String total,
			String discount, String date) {
		String sql = "INSERT INTO invoices(id,staff_id,cust_id,prod_id,quantity,total,discount,date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, id);
			stmt.setString(2, staffId);
			stmt.setString(3, custId);
			stmt.setString(4, prodId);
			stmt.setString(5, quantity);
			stmt.setString(6, total);
			stmt.setString(7, discount);
			stmt.setString(8, date);
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}