package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.DBConnection;

/**
 * This class is to load the supplier data from the database
 * 
 * @author 539676 Calum Arthur
 */
public class LoadSupplierData {

	/**
	 * This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of SupplierData in
	 * the correct fields Uses the fields to populate the table views in supplier
	 * details interface
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param sql
	 *            an SQL statement describing the SQL functionality required
	 * @param supIdCol
	 *            the table column that will be populated with the id field from the
	 *            database
	 * @param supCompanyNameCol
	 *            the table column that will be populated with the company field
	 *            field from the database
	 * @param supFirstNameCol
	 *            the table column that will be populated with the first name field
	 *            from the database
	 * @param supLastNameCol
	 *            the table column that will be populated with the last name field
	 *            from the database
	 * @param supContactNoCol
	 *            the table column that will be populated with the contact number
	 *            field from the database
	 * @param supplierTable
	 *            the table view to be populated
	 */
	public void LoadSupData(ObservableList<SupplierData> data, String sql, TableColumn<SupplierData, String> supIdCol,
			TableColumn<SupplierData, String> supCompanyNameCol, TableColumn<SupplierData, String> supFirstNameCol,
			TableColumn<SupplierData, String> supLastNameCol, TableColumn<SupplierData, String> supContactNoCol,
			TableView<SupplierData> supplierTable) {
		try (Connection conn = DBConnection.getConnection(); ResultSet rs = conn.createStatement().executeQuery(sql);) {
			data = FXCollections.observableArrayList();

			while (rs.next()) {
				data.add(new SupplierData(rs.getString(1), rs.getString(4), rs.getString(2), rs.getString(3),
						rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// populating the columns in the table view with the fields from the
		// CustomerData class
		supIdCol.setCellValueFactory(new PropertyValueFactory<SupplierData, String>("ID"));
		supCompanyNameCol.setCellValueFactory(new PropertyValueFactory<SupplierData, String>("companyName"));
		supFirstNameCol.setCellValueFactory(new PropertyValueFactory<SupplierData, String>("firstName"));
		supLastNameCol.setCellValueFactory(new PropertyValueFactory<SupplierData, String>("lastName"));
		supContactNoCol.setCellValueFactory(new PropertyValueFactory<SupplierData, String>("contactNumber"));
		supplierTable.setItems(null);
		supplierTable.setItems(data);

	}
}
