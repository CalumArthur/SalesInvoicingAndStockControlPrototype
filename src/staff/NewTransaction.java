package staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.TextField;
import main.DBConnection;

/**
 * This class is to get the data for the customer placing an order
 * 
 * @author 539676 Calum Arthur
 */
public class NewTransaction {

	
	/**
	 * this class is called from the StaffController every time a new transaction
	 * needs to be made this class will get the current data this class will get the
	 * next invoice number
	 * 
	 * @param sql2
	 *            the SQL statement to be executed
	 * @param invCustName
	 *            the field where the customer name will be displayed
	 * @param invCustAddress
	 *            the field where the address name will be displayed
	 * @param invCustPostCode
	 *            the field where the customer post code will be displayed
	 * @param invCustID
	 *            the field where the customer ID will be displayed
	 * @param invID
	 *            the field where the invoice ID will be displayed
	 * @param invDate
	 *            the field where the invoice date will be displayed
	 * @param id
	 *            the id of the customer
	 * @param newInvID the id for the next invoice
	 */
	public void LoadCustData(String sql2, TextField invCustName, TextField invCustAddress, TextField invCustPostCode,
			TextField invCustID, TextField invID, TextField invDate, String id, int newInvID) {
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql2)) {
			Alerts alert = new Alerts();
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
				alert.InfoAlert("Customer ID : " + id + " Not Found", "Please enter a different ID");
				return;
			} else {
				do {
					invCustName.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
					invCustAddress.setText(rs.getString("address"));
					invCustPostCode.setText(rs.getString("post_code"));
					invCustID.setText(rs.getString("id"));
					newInvID += 1;
					invID.setText(Integer.toString(newInvID));
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date date = new Date();
					invDate.setText(dateFormat.format(date));
				} while (rs.next());
			}
		} catch (SQLException e) {
			System.out.println("no user found");
			e.printStackTrace();
		}

	}
}