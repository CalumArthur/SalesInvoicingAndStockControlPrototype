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
 * This class is to load the product data from the database
 * 
 * @author 539676 Calum Arthur
 */
public class LoadProductData {

	/**
	 * This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of ProductData in the
	 * correct fields Uses the fields to populate the table views in product details
	 * interface
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param sql
	 *            an sql statement describing the sql functionality required
	 * @param memoryIdCol
	 *            the table column that will be populated with the id field from the
	 *            database
	 * @param memoryNameCol
	 *            the table column that will be populated with the name field from
	 *            the database
	 * @param memoryDescripCol
	 *            the table column that will be populated with the description field
	 *            from the database
	 * @param memoryPriceCol
	 *            the table column that will be populated with the price field from
	 *            the database
	 * @param memoryTable
	 *            the table view to be populated
	 * @param memoryStockCol
	 *            the table column that will be populated with the stock field from
	 *            the database
	 * @param category
	 *            the category of the product
	 */
	public void LoadProdData(ObservableList<ProductData> data, String sql, TableColumn<ProductData, String> memoryIdCol,
			TableColumn<ProductData, String> memoryNameCol, TableColumn<ProductData, String> memoryDescripCol,
			TableColumn<ProductData, String> memoryPriceCol, TableColumn<ProductData, String> memoryStockCol,
			TableView<ProductData> memoryTable, String category) {

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, category);
			ResultSet rs = stmt.executeQuery();
			data = FXCollections.observableArrayList();

			while (rs.next()) {
				data.add(new ProductData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// populating the columns in the table view with the fields from the ProductData
		// class
		memoryIdCol.setCellValueFactory(new PropertyValueFactory<ProductData, String>("ID"));
		memoryNameCol.setCellValueFactory(new PropertyValueFactory<ProductData, String>("productName"));
		memoryDescripCol.setCellValueFactory(new PropertyValueFactory<ProductData, String>("description"));
		memoryPriceCol.setCellValueFactory(new PropertyValueFactory<ProductData, String>("price"));
		memoryStockCol.setCellValueFactory(new PropertyValueFactory<ProductData, String>("stock"));
		memoryTable.setItems(null);
		memoryTable.setItems(data);

	}
}
