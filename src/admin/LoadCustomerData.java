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

/**
 * This class is to load the customer data from the database
 * 
 * @author 539676 Calum Arthur
 */
public class LoadCustomerData {

	/**
	 * This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of CustomerData in
	 * the correct fields Uses the fields to populate the table views in customer
	 * details interface
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param sql
	 *            an sql statement describing the sql functionality required
	 * @param idCol
	 *            the table column that will be populated with the id field from the
	 *            database
	 * @param firstNameCol
	 *            the table column that will be populated with the first name field
	 *            from the database
	 * @param lastNameCol
	 *            the table column that will be populated with the last name field
	 *            from the database
	 * @param addressCol
	 *            the table column that will be populated with the address field
	 *            from the database
	 * @param emailCol
	 *            the table column that will be populated with the email field from
	 *            the database
	 * @param contactNoCol
	 *            the table column that will be populated with the contact number
	 *            field from the database
	 * @param custTable
	 *            the table view to be populated
	 */
	public void LoadCustData(ObservableList<CustomerData> data, String sql, TableColumn<CustomerData, String> idCol,
			TableColumn<CustomerData, String> firstNameCol, TableColumn<CustomerData, String> lastNameCol,
			TableColumn<CustomerData, String> addressCol, TableColumn<CustomerData, String> emailCol,
			TableColumn<CustomerData, String> contactNoCol, TableView<CustomerData> custTable) {
		try (Connection conn = DBConnection.getConnection(); ResultSet rs = conn.createStatement().executeQuery(sql);) {
			data = FXCollections.observableArrayList();

			while (rs.next()) {
				data.add(new CustomerData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// populating the columns in the table view with the fields from the
		// CustomerData class
		idCol.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("ID"));
		firstNameCol.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("lastName"));
		addressCol.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("address"));
		emailCol.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("email"));
		contactNoCol.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("contactNumber"));
		custTable.setItems(null);
		custTable.setItems(data);

	}

	/**
	 * This method is to load the fields to delete customer when the user double
	 * clicks This method connects do the database This method is called from Admin
	 * controller class
	 * 
	 * @param sql,
	 *            the statement to be executed
	 * @param id
	 *            the id of customer from double click
	 * @param DelFirstName
	 *            the text field to be populated
	 * @param DelLastName
	 *            the text field to be populated
	 * @param DelID
	 *            the text field to be populated
	 */
	public void LoadDelCustData(String sql, String id, TextField DelFirstName, TextField DelLastName, TextField DelID) {
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DelFirstName.setText(rs.getString("first_name"));
				DelLastName.setText(rs.getString("last_name"));
				DelID.setText(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void LoadResetCustData(String sql, String id, TextField updateCustId, TextField updateCustFirstName,
			TextField updateLastName, TextField updateCustEmail, TextField updateCustContactNo,
			TextField updateCustAddress, TextField updateCustPostCode) {

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				updateCustId.setText(rs.getString("id"));
				updateCustFirstName.setText(rs.getString("first_name"));
				updateLastName.setText(rs.getString("last_name"));
				updateCustEmail.setText(rs.getString("email"));
				updateCustContactNo.setText(rs.getString("contact_number"));
				updateCustAddress.setText(rs.getString("address"));
				updateCustPostCode.setText(rs.getString("post_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
