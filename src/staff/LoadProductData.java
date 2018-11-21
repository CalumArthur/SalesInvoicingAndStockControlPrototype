package staff;

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
 * This class is to load the product data from the database
 * 
 * @author 539676 Calum Arthur
 */
public class LoadProductData {


	
	/**
	 * This method connects to the data base Stores the data in a new instance of
	 * Transaction data in the correct fields Uses the fields to populate the table
	 * views in product details interface
	 * 
	 * @param sql
	 *            the SQL statement to be executed
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param transactionProductIdCol
	 *            this will be the id of the product to be displayed in the new
	 *            transactions tab
	 * @param transactionProductNameCol
	 *            this will be the product name to be displayed in the new
	 *            transactions tab
	 * @param transactionProductPriceCol
	 *            this will be the product price to be displayed in the new
	 *            transactions tab
	 * @param transactionProductTable
	 *            this is the table that will be populated
	 */
	public void LoadProdData(ObservableList<TransactionProductData> data, String sql,
			TableColumn<TransactionProductData, String> transactionProductIdCol,
			TableColumn<TransactionProductData, String> transactionProductNameCol,
			TableColumn<TransactionProductData, String> transactionProductPriceCol,
			TableView<TransactionProductData> transactionProductTable) {
		try (Connection conn = DBConnection.getConnection(); ResultSet rs = conn.createStatement().executeQuery(sql);) {
			data = FXCollections.observableArrayList();

			while (rs.next()) {
				data.add(new TransactionProductData(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// populating the columns in the table view with the fields from the ProductData
		// class
		transactionProductIdCol.setCellValueFactory(new PropertyValueFactory<TransactionProductData, String>("ID"));
		transactionProductNameCol.setCellValueFactory(new PropertyValueFactory<TransactionProductData, String>("name"));
		transactionProductPriceCol
				.setCellValueFactory(new PropertyValueFactory<TransactionProductData, String>("price"));
		transactionProductTable.setItems(null);
		transactionProductTable.setItems(data);

	}
}
