package staff;

import admin.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Validation;

public class StaffController {

	@FXML
	private Tab invoiceInformationTab;
	@FXML
	private TabPane invoiceInformationTabPane;
	@FXML
	private Label fNameValid;
	@FXML
	private Label lNameValid;
	@FXML
	private Label addressValid;
	@FXML
	private Label pCValid;
	@FXML
	private Label emailValid;
	@FXML
	private Label contactNoValid;
	@FXML
	private Label fNameValid1;
	@FXML
	private Label lNameValid1;
	@FXML
	private Label addressValid1;
	@FXML
	private Label pCValid1;
	@FXML
	private Label emailValid1;
	@FXML
	private Label contactNoValid1;
	@FXML
	private Label delNameValid;
	@FXML
	private Label delLastNameValid;
	@FXML
	private Label delCustIdValid;
	@FXML
	private TextField updateCustFirstName;
	@FXML
	private TextField updateCustLastName;
	@FXML
	private TextField updateCustAddress;
	@FXML
	private TextField updateCustPostCode;
	@FXML
	private TextField updateCustEmail;
	@FXML
	private TextField updateCustContactNo;
	@FXML
	private TextField updateCustId;
	@FXML
	private TextField FirstName1;
	@FXML
	private TextField LastName1;
	@FXML
	private TextField Address1;
	@FXML
	private TextField PostCode1;
	@FXML
	private TextField Email1;
	@FXML
	private TextField ContactNo1;
	@FXML
	private TextField DelFirstName1;
	@FXML
	private TextField DelLastName1;
	@FXML
	private TextField DelID1;
	@FXML
	private TextField transactionAccNum;
	@FXML
	private TextField transactionCustName;
	@FXML
	private TextField transactionCustAddress;
	@FXML
	private TextField transactionCustPostCode;
	@FXML
	private TextField transactionCustAccNum;
	@FXML
	private TextField transactionNewNum;
	@FXML
	private TextField transactionDate;
	@FXML
	private TextField TransactionInvSubTotal;
	@FXML
	private TextField TransactionInvVAT;
	@FXML
	private TextField TransactionInvFinalTotal;
	@FXML
	private Label accNumValid;
	@FXML
	private TabPane generalInformationTabPane;
	@FXML
	private TextField invCustName;
	@FXML
	private TextField invCustAddress;
	@FXML
	private TextField invCustPostCode;
	@FXML
	private TextField invCustID;
	@FXML
	private TextField invID;
	@FXML
	private TextField invDate;
	@FXML
	private TextField invSubTotal;
	@FXML
	private TextField invVAT;
	@FXML
	private TextField invFinalTotal;
	@FXML
	private TextField invoiceNo;
	@FXML
	private Label invAccValid2;
	@FXML
	private TextField transCustFNameValue;
	@FXML
	private TextField transCustLNameValue;
	@FXML
	private TextField transCustId;
	@FXML
	private Label invNameValid;
	@FXML
	private Label invNameValid2;
	@FXML
	private Label invAccValid;

	@FXML
	private TableView<ProductData> memoryTable1;
	@FXML
	private TableColumn<ProductData, String> memoryIdCol1;
	@FXML
	private TableColumn<ProductData, String> memoryNameCol1;
	@FXML
	private TableColumn<ProductData, String> memoryDescripCol1;
	@FXML
	private TableColumn<ProductData, String> memoryStockCol1;
	@FXML
	private TableColumn<ProductData, String> memoryPriceCol1;

	@FXML
	private TableView<TransactionProductData> transactionProductTable;
	@FXML
	private TableColumn<TransactionProductData, String> transactionProductIdCol;
	@FXML
	private TableColumn<TransactionProductData, String> transactionProductNameCol;
	@FXML
	private TableColumn<TransactionProductData, String> transactionProductPriceCol;

	@FXML
	private TableView<NewTransactionData> transactionInvoiceTable;
	@FXML
	private TableColumn<NewTransactionData, String> transactionInvProdIdCol;
	@FXML
	private TableColumn<NewTransactionData, String> transactionInvQuantityCol;
	@FXML
	private TableColumn<NewTransactionData, String> transactionInvDescripCol;
	@FXML
	private TableColumn<NewTransactionData, String> transactionInvPriceCol;
	@FXML
	private TableColumn<NewTransactionData, String> transactionInvDiscountCol;
	@FXML
	private TableColumn<NewTransactionData, String> transactionInvTotalCol;

	@FXML
	private TableView<CustomerData> custTable1;
	@FXML
	private TableColumn<CustomerData, String> idCol1;
	@FXML
	private TableColumn<CustomerData, String> firstNameCol1;
	@FXML
	private TableColumn<CustomerData, String> lastNameCol1;
	@FXML
	private TableColumn<CustomerData, String> addressCol1;
	@FXML
	private TableColumn<CustomerData, String> emailCol1;
	@FXML
	private TableColumn<CustomerData, String> contactNoCol1;

	@FXML
	private TableView<CustomerData> custTable21;
	@FXML
	private TableColumn<CustomerData, String> idCol21;
	@FXML
	private TableColumn<CustomerData, String> firstNameCol21;
	@FXML
	private TableColumn<CustomerData, String> lastNameCol21;
	@FXML
	private TableColumn<CustomerData, String> addressCol21;
	@FXML
	private TableColumn<CustomerData, String> emailCol21;
	@FXML
	private TableColumn<CustomerData, String> contactNoCol21;

	@FXML
	private TableView<CustomerData> custTable31;
	@FXML
	private TableColumn<CustomerData, String> idCol31;
	@FXML
	private TableColumn<CustomerData, String> firstNameCol31;
	@FXML
	private TableColumn<CustomerData, String> lastNameCol31;
	@FXML
	private TableColumn<CustomerData, String> addressCol31;
	@FXML
	private TableColumn<CustomerData, String> emailCol31;
	@FXML
	private TableColumn<CustomerData, String> contactNoCol31;

	@FXML
	private TableView<SupplierData> supplierTable;
	@FXML
	private TableColumn<SupplierData, String> supIdCol;
	@FXML
	private TableColumn<SupplierData, String> supCompanyNameCol;
	@FXML
	private TableColumn<SupplierData, String> supFirstNameCol;
	@FXML
	private TableColumn<SupplierData, String> supLastNameCol;
	@FXML
	private TableColumn<SupplierData, String> supContactNoCol;

	@FXML
	private TableView<InvoiceData> invoiceTable;
	@FXML
	private TableColumn<InvoiceData, String> invProdIdCol;
	@FXML
	private TableColumn<InvoiceData, String> invQuantityCol;
	@FXML
	private TableColumn<InvoiceData, String> invDescripCol;
	@FXML
	private TableColumn<InvoiceData, String> invPriceCol;
	@FXML
	private TableColumn<InvoiceData, String> invDiscountCol;
	@FXML
	private TableColumn<InvoiceData, String> invTotalCol;

	@FXML
	private TableView<TransactionData> transactionTable;
	@FXML
	private TableColumn<TransactionData, String> transInvIdCol;
	@FXML
	private TableColumn<TransactionData, String> transCustFNameCol;
	@FXML
	private TableColumn<TransactionData, String> transCustLNameCol;
	@FXML
	private TableColumn<TransactionData, String> transDateCol;
	@FXML
	private TableColumn<TransactionData, String> transTotalCol;
	@FXML
	private TableColumn<TransactionData, String> transStaffCol;
	@FXML
	private TableColumn<TransactionData, String> transStaffIdCol;
	private ObservableList<TransactionData> transData;

	private int staffID = 0;
	private ObservableList<ProductData> StockproductData;
	private ObservableList<TransactionProductData> productData;
	private ObservableList<NewTransactionData> transactionData;
	private ObservableList<CustomerData> custData;
	private ObservableList<SupplierData> supData;
	private ObservableList<InvoiceData> invData;

	/**
	 * This Method loads the product information from the database this Method
	 * creates and calls a new instance of LoadProductData(method to load product
	 * data)
	 * 
	 */
	public void LoadStockProductData() {
		String sql = "SELECT p.id, p.name, p.description, i.stock_amount, p.price "
				+ "FROM products p JOIN inventory i ON p.id = i.id " + "WHERE p.category = ?";
		String category = "Memory";
		admin.LoadProductData load = new admin.LoadProductData();
		load.LoadProdData(StockproductData, sql, memoryIdCol1, memoryNameCol1, memoryDescripCol1, memoryPriceCol1,
				memoryStockCol1, memoryTable1, category);
	}

	/**
	 * This Method loads the data from the customer table in the database This
	 * method has two mouse action event, if the use double clicks on the table, the
	 * text fields will be populated one for update and one for delete users this
	 * Method creates and calls a new instance of LoadCustomerData(method to load
	 * customer data)
	 */
	public void LoadCustomerDataMethod() {
		LoadCustomerData load = new LoadCustomerData();
		custTable21.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					String stringValue = custTable21.getSelectionModel().getSelectedItem().toString();
					int selectedItemID = Integer.parseInt(stringValue.replaceAll("[\\D]", ""));
					String id = Integer.toString(selectedItemID);
					String sql = "SELECT first_name, last_name FROM customers_history WHERE id = ?";
					load.LoadDelCustData(sql, id, DelFirstName1, DelLastName1, DelID1);
				}
			}
		});
		custTable31.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					String stringValue = custTable31.getSelectionModel().getSelectedItem().toString();
					int selectedItemID = Integer.parseInt(stringValue.replaceAll("[\\D]", ""));
					String id = Integer.toString(selectedItemID);
					String sql = "SELECT * FROM customers_history WHERE id = ?";
					load.LoadResetCustData(sql, id, updateCustId, updateCustFirstName, updateCustLastName,
							updateCustEmail, updateCustContactNo, updateCustAddress, updateCustPostCode);
				}
			}
		});
		String sql = "SELECT * FROM customers_history";
		// the method is overloaded with the parameters of the three tables that need to
		// be displayed in the customer details interface
		load.LoadCustData(custData, sql, idCol1, firstNameCol1, lastNameCol1, addressCol1, emailCol1, contactNoCol1,
				custTable1);
		load.LoadCustData(custData, sql, idCol21, firstNameCol21, lastNameCol21, addressCol21, emailCol21,
				contactNoCol21, custTable21);
		load.LoadCustData(custData, sql, idCol31, firstNameCol31, lastNameCol31, addressCol31, emailCol31,
				contactNoCol31, custTable31);
	}

	/**
	 * This Method removes a new customer from the database This method used a
	 * CONFIRMATION so the user can confirm they delete the right user this Method
	 * creates and calls a new instance of DeleteCustomer(method to remove data)
	 * This Method creates and calls a new instance of Validation(class with
	 * validation methods) If all validation booleans return true the add new
	 * customer method is called this Method
	 */
	public void DeleteCustomer() {
		Validation valid = new Validation();
		boolean fName = valid.NameValidation(DelFirstName1, delNameValid, "Field Required");
		boolean lName = valid.NameValidation(DelLastName1, delLastNameValid, "Field Required");
		boolean id = valid.IDValidation(DelID1, delCustIdValid, "Field Required");
		if (fName && lName && id) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Are you sure you want to delete Customer: \n" + DelFirstName1.getText() + " "
					+ DelLastName1.getText());
			alert.setContentText("Customer ID : " + DelID1.getText());
			Optional<ButtonType> action = alert.showAndWait();
			if (action.get() == ButtonType.OK) {
				String sql = "DELETE FROM customers_history WHERE id = ? AND first_name = ? AND last_name = ?";
				RemovePerson delCust = new RemovePerson();
				delCust.DeleteUser(Integer.parseInt(DelID1.getText()), DelFirstName1.getText(), DelLastName1.getText(),
						sql);
				LoadCustomerDataMethod();
			}
		}
	}

	/**
	 * This method is called when the user wants to update customer records This
	 * method creates and calls a new instance of the validation class This method
	 * creates and calls a new instance of the UpdateCustomer class This method
	 * calls the LoadCustomerData method
	 */
	public void UpdateCustomer() {
		Validation valid = new Validation();
		boolean fName = valid.NameValidation(updateCustFirstName, fNameValid1, "Field Required");
		boolean lName = valid.NameValidation(updateCustLastName, lNameValid1, "Field Required");
		boolean add = valid.Address(updateCustAddress, addressValid1, "Field Required");
		boolean pc = valid.PostCodeValidation(updateCustPostCode, pCValid1, "Field Required");
		boolean email = valid.EmailValidation(updateCustEmail, emailValid1, "Field Required");
		boolean contactNo = valid.NumberValidation(updateCustContactNo, contactNoValid1, "Field Required");

		if (fName && lName && add && pc && email && contactNo) {
			UpdateCustomer update = new UpdateCustomer();
			update.Update(updateCustId.getText(), updateCustFirstName.getText(), updateCustLastName.getText(),
					updateCustAddress.getText(), updateCustEmail.getText(), updateCustContactNo.getText(),
					updateCustPostCode.getText());
			LoadCustomerDataMethod();
		}
	}

	/**
	 * This Method adds a new customer to the database this Method creates and calls
	 * a new instance of AddNewCustomer(method to add new customer) This Method
	 * creates and calls a new instance of Validation(class with validation methods)
	 * If all validation booleans return true the add new customer method is called
	 * This Method calls the LoadCustomerData and displays a message once a user has
	 * been added
	 */
	public void AddCustomer() {
		Validation valid = new Validation();
		boolean fName = valid.NameValidation(FirstName1, fNameValid, "Field Required");
		boolean lName = valid.NameValidation(LastName1, lNameValid, "Field Required");
		boolean add = valid.Address(Address1, addressValid, "Field Required");
		boolean pc = valid.PostCodeValidation(PostCode1, pCValid, "Field Required");
		boolean email = valid.EmailValidation(Email1, emailValid, "Field Required");
		boolean contactNo = valid.NumberValidation(ContactNo1, contactNoValid, "Field Required");
		if (fName && lName && add && pc && email && contactNo) {
			AddNewCustomer addCust = new AddNewCustomer();
			String sql = "INSERT INTO customers(id, first_name,last_name,address,email,contact_number,post_code) VALUES (?, ?, ?, ?, ?, ?, ?)";
			String sql2 = "INSERT INTO customers_history(id, first_name,last_name,address,email,contact_number,post_code) VALUES (?, ?, ?, ?, ?, ?, ?)";
			addCust.AddCust(sql, 0, FirstName1.getText(), LastName1.getText(), Address1.getText(), Email1.getText(),
					ContactNo1.getText(), PostCode1.getText());
			addCust.AddCust(sql2, 0, FirstName1.getText(), LastName1.getText(), Address1.getText(), Email1.getText(),
					ContactNo1.getText(), PostCode1.getText());
			LoadCustomerDataMethod();
		}
	}

	/**
	 * This method is called when the user wants to load suppler details This method
	 * creates and calls a new instance of LoadSupplierData methods
	 */
	public void LoadSupplierData() {
		String sql = "SELECT * FROM suppliers";
		LoadSupplierData load = new LoadSupplierData();
		load.LoadSupData(supData, sql, supIdCol, supCompanyNameCol, supFirstNameCol, supLastNameCol, supContactNoCol,
				supplierTable);
	}

	/**
	 * this method creates and calls a new instance of LoadInvoiceData this method
	 * is called when ever the user wants to load an invoice for a particular
	 * customer this method also calls the getSubTotal method
	 * 
	 */
	public void LoadInvoiceData() {
		Validation valid = new Validation();
		boolean AccId = valid.IDValidation(invoiceNo, invAccValid2, "Field Required");
		if (AccId) {
			String id = invoiceNo.getText();
			LoadInvoiceData load = new LoadInvoiceData();
			String custID = load.LoadInvData(invData, invProdIdCol, invQuantityCol, invDescripCol, invPriceCol,
					invDiscountCol, invTotalCol, invoiceTable, id);
			load.LoadInvCustData(invCustName, invCustAddress, invCustPostCode, invCustID, invID, invDate, custID, id);
			getSubTotal();
		}
	}

	/**
	 * Generates the total, sub total and vat for the invoice
	 */
	public void getSubTotal() {
		ArrayList<Integer> total = new ArrayList<Integer>();
		for (InvoiceData i : invoiceTable.getItems()) {
			total.add(Integer.parseInt(invTotalCol.getCellData(i)));
		}
		int subTotal = 0;
		for (int i : total)
			subTotal += i;
		invSubTotal.setText(Integer.toString(subTotal));
		invVAT.setText("20");
		int finalTotal = subTotal + (subTotal / 100 * 20);
		invFinalTotal.setText(Integer.toString(finalTotal));
	}

	/**
	 * this method calls and creates a new instance of the LoadTransactionData class
	 * this method is called when the user wants to view transaction logs
	 */
	public void LoadTransactionData() {
		Validation valid = new Validation();
		boolean fName = valid.NameValidation(transCustFNameValue, invNameValid, "Field Required");
		boolean lName = valid.NameValidation(transCustLNameValue, invNameValid2, "Field Required");
		boolean id = valid.IDValidation(transCustId, invAccValid, "Field Required");
		if (fName && lName && id) {
			String sql = "SELECT i.id, c.first_name, c.last_name, i.date, SUM(i.total), s.First_name, s.ID "
					+ "FROM invoices i JOIN customers c " + "ON i.cust_id = c.id "
					+ "JOIN staff s ON i.staff_id = s.ID "
					+ "WHERE i.cust_id = ? AND c.first_name = ? AND c.last_name = ? " + "GROUP BY i.id;";
			LoadTransactionData load = new LoadTransactionData();
			load.LoadTransData(transData, sql, transInvIdCol, transCustFNameCol, transCustLNameCol, transDateCol,
					transTotalCol, transStaffCol, transStaffIdCol, transactionTable, transCustFNameValue.getText(),
					transCustLNameValue.getText(), transCustId.getText());
			InvoiceDoubleClick();
		}
	}

	/**
	 * This method is to load all transaction data
	 */
	public void LoadAllTransactionData() {
		String sql = "SELECT i.id, c.first_name, c.last_name, i.date, SUM(i.total), s.First_name, s.ID "
				+ "FROM invoices i JOIN customers c " + "ON i.cust_id = c.id " + "JOIN staff s ON i.staff_id = s.ID "
				+ "GROUP BY i.id;";
		LoadTransactionData load = new LoadTransactionData();
		load.LoadAllTransData(transData, sql, transInvIdCol, transCustFNameCol, transCustLNameCol, transDateCol,
				transTotalCol, transStaffCol, transStaffIdCol, transactionTable);
		InvoiceDoubleClick();
	}

	/**
	 * This method is called when the user double clicks on data in the transactions
	 * logs interface This method listens for a double click then changes tabs and
	 * loads the data relating to the data clicked this method creates and calls a
	 * new instance of the LoadInvoiceData this method calls the getSubTotal method
	 */
	public void InvoiceDoubleClick() {
		transactionTable.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					invoiceInformationTabPane.getSelectionModel().select(invoiceInformationTab);
					String stringValue = transactionTable.getSelectionModel().getSelectedItem().toString();
					int selectedItemID = Integer.parseInt(stringValue.replaceAll("[\\D]", ""));
					String id = Integer.toString(selectedItemID);
					LoadInvoiceData load = new LoadInvoiceData();
					String custID = load.LoadInvData(invData, invProdIdCol, invQuantityCol, invDescripCol, invPriceCol,
							invDiscountCol, invTotalCol, invoiceTable, id);
					load.LoadInvCustData(invCustName, invCustAddress, invCustPostCode, invCustID, invID, invDate,
							custID, id);
					getSubTotal();
				}
			}
		});
	}

	/**
	 * This method gets the last id from the invoices table
	 * 
	 * @return returns the integer value of the last id from the invoices table
	 */

	public int GetNextInvoiceID() {
		String sql = "SELECT id FROM invoices ORDER BY id DESC LIMIT 1";
		NewTransactionID newID = new NewTransactionID();
		return newID.NewID(sql);
	}

	/**
	 * This method populates the fields in the new transaction interface with
	 * customer data this method calls the GetNextInvoiceID
	 */
	public void NewTransaction() {
		Validation valid = new Validation();
		boolean accNumber = valid.IDValidation(transactionAccNum, accNumValid, "Field Required");
		if (accNumber) {
			String sql = "SELECT first_name, last_name, address, post_code, id " + "FROM customers WHERE id = ?";

			NewTransaction load = new NewTransaction();
			load.LoadCustData(sql, transactionCustName, transactionCustAddress, transactionCustPostCode,
					transactionCustAccNum, transactionNewNum, transactionDate, transactionAccNum.getText(),
					GetNextInvoiceID());
		}
	}

	/**
	 * this method populates the fields in the new transaction interface with
	 * product data once a double click event occurs this method creates and calls a
	 * new instance of LoadTransactionData
	 * 
	 * @param id
	 *            the id of the invoice to be loaded
	 */
	public void LoadInvoiceData(String id) {
		String sql = "SELECT id, description, price FROM products WHERE id = ?";
		LoadTransactionItem load = new LoadTransactionItem();
		load.GetData(transactionData, sql, transactionInvProdIdCol, transactionInvQuantityCol, transactionInvDescripCol,
				transactionInvPriceCol, transactionInvDiscountCol, transactionInvTotalCol, transactionInvoiceTable, id);
	}

	/**
	 * This method populates the fields in the new transaction interface with
	 * product data this method calls and creates a new instance of LoadProductData
	 * This method includes a mouse event method to check for double clicks and
	 * calls the LoadInvoiceData method This method sets the transactionInvoiceTable
	 * to be editable and sets the transactionInvQuantityCol(quantity column) to be
	 * a text field cell
	 */
	public void LoadProductData() {
		String sql = "SELECT id, description, price FROM products";
		LoadProductData load = new LoadProductData();
		load.LoadProdData(productData, sql, transactionProductIdCol, transactionProductNameCol,
				transactionProductPriceCol, transactionProductTable);
		transactionInvoiceTable.setEditable(true);
		transactionInvQuantityCol.setCellFactory(TextFieldTableCell.forTableColumn());
		transactionProductTable.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					String selectedItem = transactionProductTable.getSelectionModel().getSelectedItem().toString();
					String seelectedItemID = selectedItem.substring(27, 28);
					LoadInvoiceData(seelectedItemID);
					RemoveItemFromBasket();
					GetSubTotals();
				}
			}
		});
	}

	/**
	 * This method is called when the staff needs to change the quantity of the
	 * order item this class creates and calls a new instance of
	 * UpdateBasketQuantity to update the basket this class creates and calls a new
	 * instance of LoadTransactionItem to load the new data
	 * 
	 * @param newTransactionDataStringCellEditEvent
	 *            this is the listener event for the cell
	 */
	public void NewQuantityValue(
			TableColumn.CellEditEvent<NewTransactionData, String> newTransactionDataStringCellEditEvent) {
		LoadTransactionItem load = new LoadTransactionItem();
		NewTransactionData quantity = transactionInvoiceTable.getSelectionModel().getSelectedItem();
		quantity.setQuantity(newTransactionDataStringCellEditEvent.getNewValue());
		String newQuantity = newTransactionDataStringCellEditEvent.getNewValue();
		String selectedItem = transactionInvoiceTable.getSelectionModel().getSelectedItem().toString();
		String selectedSubStr = selectedItem.substring(40, 60);
		int selectedItemID = Integer.parseInt(selectedSubStr.replaceAll("[\\D]", ""));
		String sql = "SELECT price FROM basket WHERE item_number = ?";
		UpdateBasketQuantity update = new UpdateBasketQuantity();
		update.UpdateBasket(sql, newQuantity, selectedItemID);
		String sql2 = "SELECT * FROM basket";
		load.LoadData(transactionData, sql2, transactionInvProdIdCol, transactionInvQuantityCol,
				transactionInvDescripCol, transactionInvPriceCol, transactionInvDiscountCol, transactionInvTotalCol,
				transactionInvoiceTable);
		GetSubTotals();
	}

	/**
	 * this method is called when the user wants to remove an item This method used
	 * a Key event to listen when the delete key is pressed This method creates and
	 * calls a new instance of LoadTransactionItem This method creates and calls a
	 * new instance of RemoveItem
	 */
	
	
	
	public void RemoveItemFromBasket() {
		LoadTransactionItem load = new LoadTransactionItem();
		transactionInvoiceTable.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(final KeyEvent keyEvent) {
				String selectedItem = transactionInvoiceTable.getSelectionModel().getSelectedItem().toString();
				try {
					if (selectedItem != null) {
						if (keyEvent.getCode().equals(KeyCode.DELETE)) {
							String selectedSubStr = selectedItem.substring(40, 60);
							int selectedItemID = Integer.parseInt(selectedSubStr.replaceAll("[\\D]", ""));
							String sql = "DELETE FROM basket WHERE item_number = ?";
							RemoveItem remove = new RemoveItem();
							remove.RmvItm(selectedItemID, sql);
							load.LoadData(transactionData, "SELECT * FROM basket", transactionInvProdIdCol,
									transactionInvQuantityCol, transactionInvDescripCol, transactionInvPriceCol,
									transactionInvDiscountCol, transactionInvTotalCol, transactionInvoiceTable);
							GetSubTotals();
						}
					}
				} catch (NullPointerException e){
					e.printStackTrace();
					
					}
				}
		});
	}

	/**
	 * This method is called when the user clicks on the clear button in the
	 * transactions interface This method iterates though Finds the anchor pane and
	 * iterates though it to find the Text fields this method creates and calls a
	 * new instance of LoadTransactionItem this method creates and calls a new
	 * instance of EmptyBasket
	 * 
	 * @param event
	 *            the source of the event
	 */
	public void ClearTransaction(ActionEvent event) {
		Button source = (Button) event.getSource();
		HBox parent = (HBox) source.getParent();
		AnchorPane Finalparent = (AnchorPane) parent.getParent();
		for (Node node : Finalparent.getChildren()) {
			if (node instanceof VBox) {
				VBox newParent = (VBox) node;
				for (Node node1 : newParent.getChildren()) {
					if (node1 instanceof TextField) {
						((TextField) node1).setText("");
					}
				}
			}
		}
		accNumValid.setText(" ");
		EmptyBasket empty = new EmptyBasket();
		LoadTransactionItem load = new LoadTransactionItem();
		String sql = "SELECT * FROM basket";
		empty.Empty();
		load.LoadData(transactionData, sql, transactionInvProdIdCol, transactionInvQuantityCol,
				transactionInvDescripCol, transactionInvPriceCol, transactionInvDiscountCol, transactionInvTotalCol,
				transactionInvoiceTable);
	}

	/**
	 * This method is to generate the sub total of the transaction
	 */
	public void GetSubTotals() {
		ArrayList<Integer> total = new ArrayList<Integer>();
		for (NewTransactionData i : transactionInvoiceTable.getItems()) {
			total.add(Integer.parseInt(transactionInvTotalCol.getCellData(i)));
		}
		int subTotal = 0;
		for (int i : total)
			subTotal += i;
		TransactionInvSubTotal.setText(Integer.toString(subTotal));
		TransactionInvVAT.setText("20");
		int finalTotal = subTotal + (subTotal / 100 * 20);
		TransactionInvFinalTotal.setText(Integer.toString(finalTotal));
	}

	/**
	 * This method is to create a new invoice This method calls and creates a new
	 * instance of alerts this method calls the method clearnTransaction once the
	 * sale is complete
	 * 
	 * @param event
	 *            the source of the event
	 */
	public void FinalizeTransaction(ActionEvent event) {
		Alerts alert = new Alerts();
		if (transactionCustName.getText().isEmpty() || transactionCustAddress.getText().isEmpty()
				|| transactionCustPostCode.getText().isEmpty() || transactionCustAccNum.getText().isEmpty()
				|| transactionNewNum.getText().isEmpty() || transactionDate.getText().isEmpty()) {
			alert.InfoAlert("Customer Details Required", "Please Enter a customer account number");
			return;
		}
		ObservableList<NewTransactionData> itemCheck = transactionInvoiceTable.getItems();
		if (itemCheck.isEmpty()) {
			alert.InfoAlert("Basket is empty", "Please add items to basket");
			return;
		}
		AddTransaction(event);
	}

	/**
	 * This method checks the stock amount by calling a new instance of CheckStock
	 * this method creates and calls a new instance of the CreateInvoice class this
	 * method creates and calls a new instance of update stock
	 * 
	 * @param event
	 *            the action event used to clear fields
	 */
	public void AddTransaction(ActionEvent event) {
		Alerts alert = new Alerts();
		CheckStock test = new CheckStock();
		UpdateStock update = new UpdateStock();
		CreateNewInvoice newInvoice = new CreateNewInvoice();
		int sizeOfArray = transactionInvoiceTable.getItems().size();
		String[][] invoiceData = new String[sizeOfArray][8];
		for (int j = 0; j < sizeOfArray; j++) {
			invoiceData[j][0] = (transactionNewNum.getText()); // transaction id
			invoiceData[j][1] = (Integer.toString(staffID)); // staff id
			invoiceData[j][2] = (transactionCustAccNum.getText());// customer id
			invoiceData[j][3] = (transactionInvProdIdCol.getCellData(j));// product id
			invoiceData[j][4] = (transactionInvQuantityCol.getCellData(j));// quantity
			invoiceData[j][5] = (transactionInvTotalCol.getCellData(j));// total
			invoiceData[j][6] = ("0");// discount
			invoiceData[j][7] = (transactionDate.getText()); // date
			Boolean checkstock = test.StockAmount(Integer.parseInt(invoiceData[j][4]), invoiceData[j][3]);
			if (checkstock == false) {
				alert.InfoAlert("The item you are trying to sell is currently out of stock",
						"Item Number :" + invoiceData[j][3] + ":		" + transactionInvDescripCol.getCellData(j));
				return;
			}
		}
		for (int i = 0; i < sizeOfArray; i++) {
			newInvoice.addNewRow(invoiceData[i][0], invoiceData[i][1], invoiceData[i][2], invoiceData[i][3],
					invoiceData[i][4], invoiceData[i][5], invoiceData[i][6], invoiceData[i][7]);
			update.Update(Integer.parseInt(invoiceData[i][4]), invoiceData[i][3]);
		}
		alert.InfoAlert("Transaction Complete", "Congratulations on another the sale!");
		ClearTransaction(event);
	}

	/**
	 * This method gets the login name of the staff
	 * 
	 * @param name
	 *            the value of the staffs user name
	 */
	public void getLoginName(String name) {
		String sql = "SELECT ID FROM staff WHERE Username = ?";
		GetStaffID getID = new GetStaffID();
		staffID = getID.StaffID(sql, name);
	}

	/**
	 * This method is called every time the user wants to clear the fields THis
	 * method creates a new button of the event source This method gets the parent
	 * of that button and finds all the children This method iterates though the
	 * children and if the child is a text field, set it to empty string
	 * 
	 * @param event
	 *            the source of the vent
	 */
	public void ClearFields(ActionEvent event) {
		Button source = (Button) event.getSource();
		VBox parent = (VBox) source.getParent();
		for (Node node : parent.getChildren()) {
			if (node instanceof TextField) {
				((TextField) node).setText("");
			}
		}
	}

	/**
	 * This method is called to log the user out of the system this method creates a
	 * new stage/pane/scene and loads the FXML document login this method includes a
	 * alert box to confirm logout
	 */
	public void LogOut() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Log Out");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to log out");
		Optional<ButtonType> action = alert.showAndWait();
		if (action.get() == ButtonType.OK) {
			Stage stage = (Stage) this.generalInformationTabPane.getScene().getWindow();
			stage.close();
			try {
				Stage login = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = (Pane) loader.load(getClass().getResource("/main/login.fxml").openStream());

				Scene scene = new Scene(root);
				scene.getStylesheets().add("/main/login.css");
				login.setScene(scene);
				login.setResizable(false);
				login.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
