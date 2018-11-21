package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.DBConnection;
import staff.Alerts;

/**
 * This class is to load the invoice data from the database
 * 
 * @author 539676 Calum Arthur
 */
public class LoadInvoiceData {

	/**
	 * /** This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of InvoiceData in the
	 * correct fields Uses the fields to populate the table views in invoice
	 * information interface
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param invProdId
	 *            the table column that will be populated with the product id field
	 *            from the database
	 * @param invQuantity
	 *            the table column that will be populated with the quantity field
	 *            from the database
	 * @param invDescrip
	 *            the table column that will be populated with the description field
	 *            from the database
	 * @param invPrice
	 *            the table column that will be populated with the price field from
	 *            the database
	 * @param invDiscount
	 *            the table column that will be populated with the discount field
	 *            from the database
	 * @param invTotal
	 *            the table column that will be populated with the total field from
	 *            the database
	 * @param invoiceTable
	 *            the table view to be populated
	 * @param id
	 *            the id of the invoice to be displayed
	 * @return the value of the customers id
	 */
	public String LoadInvData(ObservableList<InvoiceData> data, TableColumn<InvoiceData, String> invProdId,
			TableColumn<InvoiceData, String> invQuantity, TableColumn<InvoiceData, String> invDescrip,
			TableColumn<InvoiceData, String> invPrice, TableColumn<InvoiceData, String> invDiscount,
			TableColumn<InvoiceData, String> invTotal, TableView<InvoiceData> invoiceTable, String id) {
		String sql = "SELECT cust_id, prod_id, quantity, description, price, discount,"
				+ " total FROM invoices i JOIN products p ON i.prod_id = p.id WHERE i.id = ?";
		String custID = "";
		Alerts alert = new Alerts();
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			data = FXCollections.observableArrayList();

			if (!rs.next()) {
				alert.InfoAlert("Customer ID : " + id + " Not Found", "Please enter a different ID");
				return null;
			} else {
				do {
					data.add(new InvoiceData(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7)));
					custID = rs.getString(1);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// populating the columns in the table view with the fields from the InvoiceData
		// class
		invProdId.setCellValueFactory(new PropertyValueFactory<InvoiceData, String>("prodID"));
		invQuantity.setCellValueFactory(new PropertyValueFactory<InvoiceData, String>("quantity"));
		invDescrip.setCellValueFactory(new PropertyValueFactory<InvoiceData, String>("description"));
		invPrice.setCellValueFactory(new PropertyValueFactory<InvoiceData, String>("price"));
		invDiscount.setCellValueFactory(new PropertyValueFactory<InvoiceData, String>("discount"));
		invTotal.setCellValueFactory(new PropertyValueFactory<InvoiceData, String>("total"));
		invoiceTable.setItems(null);
		invoiceTable.setItems(data);
		return custID;
	}

	/**
	 * This method connects to the data base Used the data from the invoices data
	 * base to populate the text fields in the invoice info interface
	 * 
	 * @param invCustName
	 *            this is the field that will show the customers first name and last
	 *            name
	 * @param invCustAddress
	 *            this is the field that will show the customers address
	 * @param invCustPostCode
	 *            this is the field that will show the customers post code
	 * @param invCustID
	 *            his is the field that will show the customers id(account number)
	 * @param invID
	 *            this is the field that will show the invoice id
	 * @param invDate
	 *            this is the field that will show the invoice date
	 * @param id
	 *            this is the customer id that the sql statement will search the
	 *            database to match
	 */
	public void LoadInvCustData(TextField invCustName, TextField invCustAddress, TextField invCustPostCode,
			TextField invCustID, TextField invID, TextField invDate, String id, String custInvID) {
		String sql = "SELECT i.id, first_name, last_name, address, post_code, c.id, date "
				+ "FROM invoices i JOIN customers c ON i.cust_id = c.id WHERE c.id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				invCustName.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
				invCustAddress.setText(rs.getString("address"));
				invCustPostCode.setText(rs.getString("post_code"));
				invCustID.setText(rs.getString("c.id"));
				invID.setText(custInvID);
				invDate.setText(rs.getString("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
