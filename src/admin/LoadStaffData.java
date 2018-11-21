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
 * This class is to load the product staff from the database
 * 
 * @author 539676 Calum Arthur
 */
public class LoadStaffData {

	String no;

	/**
	 * This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of StaffData in the
	 * correct fields Uses the fields to populate the table views in product details
	 * interface
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
	 * @param userNameCol
	 *            the table column that will be populated with the username field
	 *            from the database
	 * @param blockedCol
	 *            the table column that will be populated with the blocked field
	 *            from the database
	 * @param contactNoCol
	 *            the table column that will be populated with the contact number
	 *            field from the database
	 * @param staffTable
	 *            the table view to be populated
	 */
	public void LoadStffData(ObservableList<StaffData> data, String sql, TableColumn<StaffData, String> idCol,
			TableColumn<StaffData, String> firstNameCol, TableColumn<StaffData, String> lastNameCol,
			TableColumn<StaffData, String> userNameCol, TableColumn<StaffData, String> blockedCol,
			TableColumn<StaffData, String> contactNoCol, TableView<StaffData> staffTable) {
		try (Connection conn = DBConnection.getConnection(); ResultSet rs = conn.createStatement().executeQuery(sql);) {
			data = FXCollections.observableArrayList();

			while (rs.next()) {
				// method to display the boolean counter for the user
				if (Integer.parseInt(rs.getString(6)) == 0) {
					no = "No";
				} else
					no = "Yes";
				data.add(new StaffData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), (no),
						rs.getString(8), rs.getString(7), rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// populating the columns in the table view with the fields from the ProductData
		// class
		idCol.setCellValueFactory(new PropertyValueFactory<StaffData, String>("ID"));
		firstNameCol.setCellValueFactory(new PropertyValueFactory<StaffData, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<StaffData, String>("lastName"));
		userNameCol.setCellValueFactory(new PropertyValueFactory<StaffData, String>("userName"));
		blockedCol.setCellValueFactory(new PropertyValueFactory<StaffData, String>("blocked"));
		contactNoCol.setCellValueFactory(new PropertyValueFactory<StaffData, String>("contactNumber"));
		staffTable.setItems(null);
		staffTable.setItems(data);

	}

	public void LoadDelStaffData(String sql, String id, TextField DelFirstName, TextField DelLastName,
			TextField DelID) {
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

}
