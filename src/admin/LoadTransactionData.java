package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.DBConnection;

/**
 * This class is to load the transaction data from the database
 * 
 * @author 539676 Calum Arthur
 */
public class LoadTransactionData {

	/**
	 * This method connects to the data base Stores the data in a new instance of
	 * TransactionData in the correct fields Uses the fields to populate the table
	 * views in transaction logs interface this method is to search for specific
	 * transaction data
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param sql
	 *            an sql statement describing the sql functionality required
	 * @param transInvIdCol
	 *            the table column that will be populated with the invoice id field
	 *            from the database
	 * @param transCustFNameCol
	 *            the table column that will be populated with he customer first
	 *            name field from the database
	 * @param transCustLNameCol
	 *            the table column that will be populated with the customer last
	 *            name field from the database
	 * @param transDateCol
	 *            the table column that will be populated with the invoice date
	 *            field from the database
	 * @param transTotalCol
	 *            the table column that will be populated with the sum of the
	 *            invoice totals field from the database
	 * @param transStaffCol
	 *            the table column that will be populated with the staff name field
	 *            from the database
	 * @param transStaffIdCol
	 *            the table column that will be populated with the staff id field
	 *            from the database
	 * @param transactionTable
	 *            the table that will be populated
	 * @param fName
	 *            values that the user will input, used in WHERE clause in sql
	 *            statement
	 * @param lName
	 *            values that the user will input, used in WHERE clause in sql
	 *            statement
	 * @param ID
	 *            values that the user will input, used in WHERE clause in sql
	 *            statement
	 */
	public void LoadTransData(ObservableList<TransactionData> data, String sql,
			TableColumn<TransactionData, String> transInvIdCol, TableColumn<TransactionData, String> transCustFNameCol,
			TableColumn<TransactionData, String> transCustLNameCol, TableColumn<TransactionData, String> transDateCol,
			TableColumn<TransactionData, String> transTotalCol, TableColumn<TransactionData, String> transStaffCol,
			TableColumn<TransactionData, String> transStaffIdCol, TableView<TransactionData> transactionTable,
			String fName, String lName, String ID) {

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, ID);
			stmt.setString(2, fName);
			stmt.setString(3, lName);
			ResultSet rs = stmt.executeQuery();
			data = FXCollections.observableArrayList();
			while (rs.next()) {
				data.add(new TransactionData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// populating the columns in the table view with the fields from the ProductData
		// class
		transInvIdCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("invID"));
		transCustFNameCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("custFirstName"));
		transCustLNameCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("custLastName"));
		transDateCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("Date"));
		transTotalCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("Total"));
		transStaffCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("StaffName"));
		transStaffIdCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("StaffID"));
		transactionTable.setItems(null);
		transactionTable.setItems(data);
	}

	/**
	 * This method connects to the data base Stores the data in a new instance of
	 * TransactionData in the correct fields Uses the fields to populate the table
	 * views in transaction logs interface this method is to load all transaction
	 * data
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param sql
	 *            an sql statement describing the sql functionality required
	 * @param transInvIdCol
	 *            the table column that will be populated with the invoice id field
	 *            from the database
	 * @param transCustFNameCol
	 *            the table column that will be populated with he customer first
	 *            name field from the database
	 * @param transCustLNameCol
	 *            the table column that will be populated with the customer last
	 *            name field from the database
	 * @param transDateCol
	 *            the table column that will be populated with the invoice date
	 *            field from the database
	 * @param transTotalCol
	 *            the table column that will be populated with the sum of the
	 *            invoice totals field from the database
	 * @param transStaffCol
	 *            the table column that will be populated with the staff name field
	 *            from the database
	 * @param transStaffIdCol
	 *            the table column that will be populated with the staff id field
	 *            from the database
	 * @param transactionTable
	 *            the table that will be populated
	 */
	public void LoadAllTransData(ObservableList<TransactionData> data, String sql,
			TableColumn<TransactionData, String> transInvIdCol, TableColumn<TransactionData, String> transCustFNameCol,
			TableColumn<TransactionData, String> transCustLNameCol, TableColumn<TransactionData, String> transDateCol,
			TableColumn<TransactionData, String> transTotalCol, TableColumn<TransactionData, String> transStaffCol,
			TableColumn<TransactionData, String> transStaffIdCol, TableView<TransactionData> transactionTable) {

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			data = FXCollections.observableArrayList();
			while (rs.next()) {
				data.add(new TransactionData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// populating the columns in the table view with the fields from the ProductData
		// class
		transInvIdCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("invID"));
		transCustFNameCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("custFirstName"));
		transCustLNameCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("custLastName"));
		transDateCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("Date"));
		transTotalCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("Total"));
		transStaffCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("StaffName"));
		transStaffIdCol.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("StaffID"));
		transactionTable.setItems(null);
		transactionTable.setItems(data);
	}

}
