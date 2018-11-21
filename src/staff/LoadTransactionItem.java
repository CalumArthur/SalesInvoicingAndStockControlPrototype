package staff;

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
 * This class is to update the quantity and total price for an item in the
 * basket
 * 
 * @author 539676 Calum Arthur
 *
 */
public class LoadTransactionItem {
	/**
	 * This Method gets the price and description from the products table This
	 * method calls the AddToBasket method(method to add the selected products to
	 * the basket table This method calls the LoadData method, the method to
	 * populate the table view in the new transaction interface This method is
	 * called from the StaffController
	 * 
	 * @param data
	 *            data this is the ObservableList that will be used to populate the
	 *            table
	 * @param sql
	 *            the SQL statement that will be executed to get the data
	 * @param transactionInvProdIdCol
	 *            the table column that will be populated with the id field from the
	 *            database
	 * @param transactionInvQuantityCol
	 *            the table column that will be populated with the quantity field
	 *            from the database
	 * @param transactionInvDescripCol
	 *            the table column that will be populated with the description field
	 *            from the database
	 * @param transactionInvPriceCol
	 *            the table column that will be populated with the price field from
	 *            the database
	 * @param transactionInvDiscountCol
	 *            the table column that will be populated with the discount field
	 *            from the database
	 * @param transactionInvTotalCol
	 *            the table column that will be populated with the total field from
	 *            the database
	 * @param transactionInvoiceTable
	 *            the table view that holds the columns
	 * @param id
	 *            the product if that will be used to find the correct information
	 */
	public void GetData(ObservableList<NewTransactionData> data, String sql,
			TableColumn<NewTransactionData, String> transactionInvProdIdCol,
			TableColumn<NewTransactionData, String> transactionInvQuantityCol,
			TableColumn<NewTransactionData, String> transactionInvDescripCol,
			TableColumn<NewTransactionData, String> transactionInvPriceCol,
			TableColumn<NewTransactionData, String> transactionInvDiscountCol,
			TableColumn<NewTransactionData, String> transactionInvTotalCol,
			TableView<NewTransactionData> transactionInvoiceTable, String id) {

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int itemNumber = rs.getInt(1);
				String description = rs.getString(2);
				int price = rs.getInt(3);
				int quantity = 1;
				AddToBasket(itemNumber, description, price, quantity);
				String sql3 = "SELECT item_number,description,price,quantity,total FROM basket";
				LoadData(data, sql3, transactionInvProdIdCol, transactionInvQuantityCol, transactionInvDescripCol,
						transactionInvPriceCol, transactionInvDiscountCol, transactionInvTotalCol,
						transactionInvoiceTable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method adds the selected item to the basket table in the database
	 * 
	 * @param item_number
	 *            the product item number to be added
	 * @param description
	 *            the description of the item to be added
	 * @param price
	 *            the price of the item
	 * @param quantity
	 *            the quantity of the item (1 as default)
	 */
	public void AddToBasket(int item_number, String description, int price, int quantity) {
		Alerts alert = new Alerts();
		String sql2 = "INSERT INTO basket(item_number,description,price,quantity,total) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql2);) {
			stmt.setInt(1, item_number);
			stmt.setString(2, description);
			stmt.setInt(3, price);
			stmt.setInt(4, quantity);
			stmt.setInt(5, price);
			stmt.execute();
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				alert.InfoAlert("Item Number: " + item_number + " Is already in the basket",
						"If you want to add more please increase quantity");
				return;
			}
			e.printStackTrace();
		}
	}

	/**
	 * This method populates the table view from the basket table
	 * 
	 * @param data
	 *            data this is the ObservableList that will be used to populate the
	 *            table
	 * @param sql
	 *            the SQL statement that will be executed to get the data
	 * @param transactionInvProdIdCol
	 *            the table column that will be populated with the id field from the
	 *            database
	 * @param transactionInvQuantityCol
	 *            the table column that will be populated with the quantity field
	 *            from the database
	 * @param transactionInvDescripCol
	 *            the table column that will be populated with the description field
	 *            from the database
	 * @param transactionInvPriceCol
	 *            the table column that will be populated with the price field from
	 *            the database
	 * @param transactionInvDiscountCol
	 *            the table column that will be populated with the discount field
	 *            from the database
	 * @param transactionInvTotalCol
	 *            the table column that will be populated with the total field from
	 *            the database
	 * @param transactionInvoiceTable
	 *            the table view that holds the columns
	 */
	public void LoadData(ObservableList<NewTransactionData> data, String sql,
			TableColumn<NewTransactionData, String> transactionInvProdIdCol,
			TableColumn<NewTransactionData, String> transactionInvQuantityCol,
			TableColumn<NewTransactionData, String> transactionInvDescripCol,
			TableColumn<NewTransactionData, String> transactionInvPriceCol,
			TableColumn<NewTransactionData, String> transactionInvDiscountCol,
			TableColumn<NewTransactionData, String> transactionInvTotalCol,
			TableView<NewTransactionData> transactionInvoiceTable) {
		try (Connection conn = DBConnection.getConnection(); ResultSet rs = conn.createStatement().executeQuery(sql);) {
			data = FXCollections.observableArrayList();

			while (rs.next()) {
				data.add(new NewTransactionData(rs.getString(1), rs.getString(4), rs.getString(2), rs.getString(3),
						rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		transactionInvProdIdCol.setCellValueFactory(new PropertyValueFactory<NewTransactionData, String>("prodID"));
		transactionInvQuantityCol.setCellValueFactory(new PropertyValueFactory<NewTransactionData, String>("quantity"));
		transactionInvDescripCol
				.setCellValueFactory(new PropertyValueFactory<NewTransactionData, String>("description"));
		transactionInvPriceCol.setCellValueFactory(new PropertyValueFactory<NewTransactionData, String>("price"));
		transactionInvTotalCol.setCellValueFactory(new PropertyValueFactory<NewTransactionData, String>("total"));
		transactionInvoiceTable.setItems(null);
		transactionInvoiceTable.setItems(data);

	}

}
