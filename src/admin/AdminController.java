package admin;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Validation;
import staff.Alerts;

/**
 * This class is the controller for the fxml file Admin.fxml. this class handles
 * all of the action events and main method calls for the admin suite
 * 
 * @author 539676 Calum Arthur
 */
public class AdminController implements Initializable {

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
	private TextField FirstName;
	@FXML
	private TextField LastName;
	@FXML
	private TextField Address;
	@FXML
	private TextField PostCode;
	@FXML
	private TextField Email;
	@FXML
	private TextField ContactNo;
	@FXML
	private TextField DelFirstName;
	@FXML
	private TextField DelLastName;
	@FXML
	private TextField DelID;
	@FXML
	private Button clear1;
	@FXML
	private Button addCust;
	@FXML
	private TextField StaffFirstName;
	@FXML
	private TextField StaffLastName;
	@FXML
	private TextField StaffContactNo;
	@FXML
	private TextField StaffPassword;
	@FXML
	private TextField DelStaffFirstName;
	@FXML
	private TextField DelStaffLastName;
	@FXML
	private TextField DelStaffID;
	@FXML
	private TextField ResetStaffFirstName;
	@FXML
	private TextField ResetStaffLastName;
	@FXML
	private TextField ResetStaffID;
	@FXML
	private TextField newPassword;
	@FXML
	private TextField invoiceNo;
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
	private Label invNameValid;
	@FXML
	private Label invNameValid2;
	@FXML
	private Label invAccValid;
	@FXML
	private Label invAccValid2;
	@FXML
	private Label staffFnameValid1;
	@FXML
	private Label staffLnameValid1;
	@FXML
	private Label staffNumberValid1;
	@FXML
	private Label staffPasswordValid1;
	@FXML
	private Label staffFnameValid2;
	@FXML
	private Label staffLnameValid2;
	@FXML
	private Label staffIdValid2;
	@FXML
	private Label staffFnameValid3;
	@FXML
	private Label staffLnameValid3;
	@FXML
	private Label staffIdValid3;
	@FXML
	private Label staffPasswordValid3;
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
	private TextField transCustFNameValue;
	@FXML
	private TextField transCustLNameValue;
	@FXML
	private TextField transCustId;
	@FXML
	private Label delNameValid;
	@FXML
	private Label delLastNameValid;
	@FXML
	private Label delCustId;
	@FXML
	private TabPane invoiceInformationTabPane;
	@FXML
	private TabPane deleteCustTab;
	@FXML
	private Tab invoiceInformationTab;
	@FXML
	private TabPane generalInformationTabPane;
	@FXML
	private AnchorPane custDetailsAnchor;
	@FXML
	private DatePicker reportDatePicker;
	@FXML
	private DatePicker weeklyDatePicker;
	@FXML
	private TextField dailyTotal;
	@FXML
	private TextField weeklyTotal;
	@FXML
	private TextField monthlyTotal;
	@FXML
	private TextField quarterlyTotal;
	@FXML
	private TextField annualTotal;
	@FXML
	private ComboBox<Integer> monthYears;
	@FXML
	private ComboBox<String> quartQuart;
	@FXML
	private ComboBox<Integer> quartYears;
	@FXML
	private ComboBox<Integer> annualYears;
	@FXML
	private ComboBox<YearOption> monthMonth;

	@FXML
	private Label optionLabel1;
	@FXML
	private Label optionLabel2;
	@FXML
	private Label optionLabel3;
	@FXML
	private Label optionLabel4;
	@FXML
	private Label optionLabel41;
	@FXML
	private Label optionLabel5;
	@FXML
	private Label optionLabel6;

	@FXML
	private TableView<CustomerData> custTable;
	@FXML
	private TableColumn<CustomerData, String> idCol;
	@FXML
	private TableColumn<CustomerData, String> firstNameCol;
	@FXML
	private TableColumn<CustomerData, String> lastNameCol;
	@FXML
	private TableColumn<CustomerData, String> addressCol;
	@FXML
	private TableColumn<CustomerData, String> emailCol;
	@FXML
	private TableColumn<CustomerData, String> contactNoCol;

	@FXML
	private TableView<CustomerData> custTable2;
	@FXML
	private TableColumn<CustomerData, String> idCol2;
	@FXML
	private TableColumn<CustomerData, String> firstNameCol2;
	@FXML
	private TableColumn<CustomerData, String> lastNameCol2;
	@FXML
	private TableColumn<CustomerData, String> addressCol2;
	@FXML
	private TableColumn<CustomerData, String> emailCol2;
	@FXML
	private TableColumn<CustomerData, String> contactNoCol2;

	@FXML
	private TableView<CustomerData> custTable3;
	@FXML
	private TableColumn<CustomerData, String> idCol3;
	@FXML
	private TableColumn<CustomerData, String> firstNameCol3;
	@FXML
	private TableColumn<CustomerData, String> lastNameCol3;
	@FXML
	private TableColumn<CustomerData, String> addressCol3;
	@FXML
	private TableColumn<CustomerData, String> emailCol3;
	@FXML
	private TableColumn<CustomerData, String> contactNoCol3;

	@FXML
	private TableView<ProductData> memoryTable;
	@FXML
	private TableColumn<ProductData, String> memoryIdCol;
	@FXML
	private TableColumn<ProductData, String> memoryNameCol;
	@FXML
	private TableColumn<ProductData, String> memoryDescripCol;
	@FXML
	private TableColumn<ProductData, String> memoryStockCol;
	@FXML
	private TableColumn<ProductData, String> memoryPriceCol;

	@FXML
	private TableView<StaffData> staffTable1;
	@FXML
	private TableColumn<StaffData, String> idCol4;
	@FXML
	private TableColumn<StaffData, String> firstNameCol4;
	@FXML
	private TableColumn<StaffData, String> lastNameCol4;
	@FXML
	private TableColumn<StaffData, String> userNameCol4;
	@FXML
	private TableColumn<StaffData, String> blockedCol4;
	@FXML
	private TableColumn<StaffData, String> contactNoCol4;

	@FXML
	private TableView<StaffData> staffTable2;
	@FXML
	private TableColumn<StaffData, String> idCol5;
	@FXML
	private TableColumn<StaffData, String> firstNameCol5;
	@FXML
	private TableColumn<StaffData, String> lastNameCol5;
	@FXML
	private TableColumn<StaffData, String> userNameCol5;
	@FXML
	private TableColumn<StaffData, String> blockedCol5;
	@FXML
	private TableColumn<StaffData, String> contactNoCol5;

	@FXML
	private TableView<StaffData> staffTable3;
	@FXML
	private TableColumn<StaffData, String> idCol6;
	@FXML
	private TableColumn<StaffData, String> firstNameCol6;
	@FXML
	private TableColumn<StaffData, String> lastNameCol6;
	@FXML
	private TableColumn<StaffData, String> userNameCol6;
	@FXML
	private TableColumn<StaffData, String> blockedCol6;
	@FXML
	private TableColumn<StaffData, String> contactNoCol6;

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

	@FXML
	private TableView<ReportData> dailyTable;
	@FXML
	private TableColumn<ReportData, String> dailyInvNoCol;
	@FXML
	private TableColumn<ReportData, String> dailyStaffIdCol;
	@FXML
	private TableColumn<ReportData, String> dailyStaffNameCol;
	@FXML
	private TableColumn<ReportData, String> dailyCustFirstNameCol;
	@FXML
	private TableColumn<ReportData, String> dailyCustLastNameCol;
	@FXML
	private TableColumn<ReportData, String> dailyDateCol;
	@FXML
	private TableColumn<ReportData, String> dailyTotalCol;

	@FXML
	private TableView<ReportData> weeklyTable;
	@FXML
	private TableColumn<ReportData, String> weeklyInvNoCol;
	@FXML
	private TableColumn<ReportData, String> weeklyStaffIdCol;
	@FXML
	private TableColumn<ReportData, String> weeklyStaffNameCol;
	@FXML
	private TableColumn<ReportData, String> weeklyCustFirstNameCol;
	@FXML
	private TableColumn<ReportData, String> weeklyCustLastNameCol;
	@FXML
	private TableColumn<ReportData, String> weeklyDateCol;
	@FXML
	private TableColumn<ReportData, String> weeklyTotalCol;

	@FXML
	private TableView<ReportData> MonthlyTable;
	@FXML
	private TableColumn<ReportData, String> MonthlyInvNoCol;
	@FXML
	private TableColumn<ReportData, String> MonthlyStaffIdCol;
	@FXML
	private TableColumn<ReportData, String> MonthlyStaffNameCol;
	@FXML
	private TableColumn<ReportData, String> MonthlyCustFirstNameCol;
	@FXML
	private TableColumn<ReportData, String> MonthlyCustLastNameCol;
	@FXML
	private TableColumn<ReportData, String> MonthlyDateCol;
	@FXML
	private TableColumn<ReportData, String> MonthlyTotalCol;

	@FXML
	private TableView<ReportData> QuartTable;
	@FXML
	private TableColumn<ReportData, String> QuartInvNoCol;
	@FXML
	private TableColumn<ReportData, String> QuartStaffIdCol;
	@FXML
	private TableColumn<ReportData, String> QuartStaffNameCol;
	@FXML
	private TableColumn<ReportData, String> QuartCustFirstNameCol;
	@FXML
	private TableColumn<ReportData, String> QuartCustLastNameCol;
	@FXML
	private TableColumn<ReportData, String> QuartDateCol;
	@FXML
	private TableColumn<ReportData, String> QuartTotalCol;

	@FXML
	private TableView<ReportData> AnnualTable;
	@FXML
	private TableColumn<ReportData, String> AnnualInvNoCol;
	@FXML
	private TableColumn<ReportData, String> AnnualStaffIdCol;
	@FXML
	private TableColumn<ReportData, String> AnnualStaffNameCol;
	@FXML
	private TableColumn<ReportData, String> AnnualCustFirstNameCol;
	@FXML
	private TableColumn<ReportData, String> AnnualCustLastNameCol;
	@FXML
	private TableColumn<ReportData, String> AnnualDateCol;
	@FXML
	private TableColumn<ReportData, String> AnnualTotalCol;

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

	// ObservalbeList used as a wrapper with the the generic class specified
	// ObservalbeLists are used with the Table view and table column objects
	private ObservableList<ProductData> productData;
	private ObservableList<CustomerData> custData;
	private ObservableList<StaffData> staffData;
	private ObservableList<InvoiceData> invData;
	private ObservableList<TransactionData> transData;
	private ObservableList<ReportData> repData;
	private ObservableList<SupplierData> supData;

	/**
	 * This Method is to initialise the combo box's in the report section with
	 * specified values
	 */
	public void initialize(URL url, ResourceBundle rb) {
		ObservableList<Integer> list1 = FXCollections.observableArrayList();
		list1.addAll(2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015,
				2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031, 2032,
				2033, 2034, 2035, 2036, 2037, 2038, 2039, 2040, 2041, 2042, 2043, 2044, 2045, 2046, 2047, 2048, 2049,
				2050, 2051, 2052, 2053, 2054, 2055, 2056, 2057, 2058, 2059, 2060, 2061, 2062, 2063, 2064, 2065, 2066,
				2067, 2068, 2069, 2070, 2071, 2072, 2073, 2074, 2075, 2076, 2077, 2078, 2079, 2080, 2081, 2082, 2083,
				2084, 2085, 2086, 2087, 2088, 2089, 2090, 2091, 2092, 2093, 2094, 2095, 2096, 2097, 2098, 2099);
		ObservableList<String> list2 = FXCollections.observableArrayList();
		list2.addAll("1st Quarter", "2nd Quarter", "3rd Quarter", "4th Quarter");
		this.monthYears.setItems(list1);
		this.quartYears.setItems(list1);
		this.annualYears.setItems(list1);
		this.monthMonth.setItems(FXCollections.observableArrayList(YearOption.values()));
		this.quartQuart.setItems(list2);
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
		custTable2.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					String stringValue = custTable2.getSelectionModel().getSelectedItem().toString();
					int selectedItemID = Integer.parseInt(stringValue.replaceAll("[\\D]", ""));
					String id = Integer.toString(selectedItemID);
					String sql = "SELECT first_name, last_name FROM customers_history WHERE id = ?";
					load.LoadDelCustData(sql, id, DelFirstName, DelLastName, DelID);
				}
			}
		});
		custTable3.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					String stringValue = custTable3.getSelectionModel().getSelectedItem().toString();
					int selectedItemID = Integer.parseInt(stringValue.replaceAll("[\\D]", ""));
					String id = Integer.toString(selectedItemID);
					String sql = "SELECT * FROM customers_history WHERE id = ?";
					load.LoadResetCustData(sql, id, updateCustId, updateCustFirstName, updateCustLastName,
							updateCustEmail, updateCustContactNo, updateCustAddress, updateCustPostCode);
				}
			}
		});
		String sql = "SELECT * FROM customers_history	";
		// the method is overloaded with the parameters of the three tables that need to
		// be displayed in the customer details interface
		load.LoadCustData(custData, sql, idCol, firstNameCol, lastNameCol, addressCol, emailCol, contactNoCol,
				custTable);
		load.LoadCustData(custData, sql, idCol2, firstNameCol2, lastNameCol2, addressCol2, emailCol2, contactNoCol2,
				custTable2);
		load.LoadCustData(custData, sql, idCol3, firstNameCol3, lastNameCol3, addressCol3, emailCol3, contactNoCol3,
				custTable3);
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
		Alerts alert = new Alerts();
		boolean fName = valid.NameValidation(FirstName, fNameValid, "Field Required");
		boolean lName = valid.NameValidation(LastName, lNameValid, "Field Required");
		boolean add = valid.Address(Address, addressValid, "Field Required");
		boolean pc = valid.PostCodeValidation(PostCode, pCValid, "Field Required");
		boolean email = valid.EmailValidation(Email, emailValid, "Field Required");
		boolean contactNo = valid.NumberValidation(ContactNo, contactNoValid, "Field Required");
		if (fName && lName && add && pc && email && contactNo) {
			String sql = "INSERT INTO customers(id, first_name,last_name,address,email,contact_number,post_code) VALUES (?, ?, ?, ?, ?, ?, ?)";
			String sql2 = "INSERT INTO customers_history(id, first_name,last_name,address,email,contact_number,post_code) VALUES (?, ?, ?, ?, ?, ?, ?)";
			AddNewCustomer addCust = new AddNewCustomer();
			addCust.AddCust(sql, 0, FirstName.getText(), LastName.getText(), Address.getText(), Email.getText(),
					ContactNo.getText(), PostCode.getText());
			addCust.AddCust(sql2, 0, FirstName.getText(), LastName.getText(), Address.getText(), Email.getText(),
					ContactNo.getText(), PostCode.getText());
			alert.InfoAlert("Customer: " + FirstName.getText() + " " + LastName.getText() + " Added", "");
			LoadCustomerDataMethod();
		}
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
		boolean fName = valid.NameValidation(DelFirstName, delNameValid, "Field Required");
		boolean lName = valid.NameValidation(DelLastName, delLastNameValid, "Field Required");
		boolean id = valid.IDValidation(DelID, delCustId, "Field Required");
		if (fName && lName && id) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Are you sure you want to delete Customer: \n" + DelFirstName.getText() + " "
					+ DelLastName.getText());
			alert.setContentText("Customer ID : " + DelID.getText());
			Optional<ButtonType> action = alert.showAndWait();
			if (action.get() == ButtonType.OK) {
				System.out.println();
				String sql = "DELETE FROM customers_history WHERE id = ? AND first_name = ? AND last_name = ?";
				RemovePerson delCust = new RemovePerson();
				delCust.DeleteUser(Integer.parseInt(DelID.getText()), DelFirstName.getText(), DelLastName.getText(),
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
	 * This Method loads the product information from the database this Method
	 * creates and calls a new instance of LoadProductData(method to load product
	 * data)
	 * 
	 */
	public void LoadProductData() {
		String sql = "SELECT p.id, p.name, p.description, i.stock_amount, p.price "
				+ "FROM products p JOIN inventory i ON p.id = i.id " + "WHERE p.category = ?";
		String category = "Memory";
		LoadProductData load = new LoadProductData();
		load.LoadProdData(productData, sql, memoryIdCol, memoryNameCol, memoryDescripCol, memoryPriceCol,
				memoryStockCol, memoryTable, category);
	}

	/**
	 * This Method loads the staff information from the database this Method creates
	 * and calls a new instance of LoadStaffData(method to load staff data)
	 * 
	 */
	public void LoadStaffData() {
		LoadStaffData load = new LoadStaffData();
		staffTable2.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					String stringValue = staffTable2.getSelectionModel().getSelectedItem().toString();
					int selectedItemID = Integer.parseInt(stringValue.replaceAll("[\\D]", ""));
					String id = Integer.toString(selectedItemID);
					String sql = "SELECT First_name, Last_name FROM staffhistory WHERE id = ?";
					load.LoadDelStaffData(sql, id, DelStaffFirstName, DelStaffLastName, DelStaffID);
				}
			}
		});

		staffTable3.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					String stringValue = staffTable3.getSelectionModel().getSelectedItem().toString();
					int selectedItemID = Integer.parseInt(stringValue.replaceAll("[\\D]", ""));
					String id = Integer.toString(selectedItemID);
					String sql = "SELECT First_name, Last_name FROM staffhistory WHERE id = ?";
					load.LoadDelStaffData(sql, id, ResetStaffFirstName, ResetStaffLastName, ResetStaffID);
				}
			}
		});
		String sql = "SELECT * FROM staffhistory";
		// the method is overloaded with the parameters of the three tables that need to
		// be displayed in the staff details interface
		load.LoadStffData(staffData, sql, idCol4, firstNameCol4, lastNameCol4, userNameCol4, blockedCol4, contactNoCol4,
				staffTable1);
		load.LoadStffData(staffData, sql, idCol5, firstNameCol5, lastNameCol5, userNameCol5, blockedCol5, contactNoCol5,
				staffTable2);
		load.LoadStffData(staffData, sql, idCol6, firstNameCol6, lastNameCol6, userNameCol6, blockedCol6, contactNoCol6,
				staffTable3);
	}

	/**
	 * This Method removes staff from the database this Method creates and calls a
	 * new instance of RemovePerson(method remove data) This method creates and
	 * calls a new instance of Validation to validate the inputs This method calls
	 * the LoadStaffData method to refresh the table
	 */
	public void DeleteStaff() {
		Validation valid = new Validation();
		boolean fName = valid.NameValidation(DelStaffFirstName, staffFnameValid2, "Field Required");
		boolean lName = valid.NameValidation(DelStaffLastName, staffLnameValid2, "Field Required");
		boolean id = valid.IDValidation(DelStaffID, staffIdValid2, "Field Required");
		if (fName && lName && id) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Are you sure you want to delete Staff: \n" + DelStaffFirstName.getText() + " "
					+ DelStaffLastName.getText());
			alert.setContentText("Staff ID : " + DelStaffID.getText());
			Optional<ButtonType> action = alert.showAndWait();
			if (action.get() == ButtonType.OK) {
				String sql = "DELETE FROM staffhistory WHERE id = ? AND first_name = ? AND last_name = ?";
				RemoveStaff delStaff = new RemoveStaff();
				delStaff.DeleteStaff(Integer.parseInt(DelStaffID.getText()), DelStaffFirstName.getText(),
						DelStaffLastName.getText(), sql);
				LoadStaffData();
			}
		}
	}

	/**
	 * This Method adds staff to the database this Method creates and calls a new
	 * instance of AddNewStaff(method add staff to database) This method creates and
	 * calls a new instance of Validation to validate the inputs This method calls
	 * the LoadStaffData method to refresh the table
	 */
	public void AddStaff() {
		Validation valid = new Validation();
		boolean fName = valid.NameValidation(StaffFirstName, staffFnameValid1, "Field Required");
		boolean lName = valid.NameValidation(StaffLastName, staffLnameValid1, "Field Required");
		boolean contactNo = valid.NumberValidation(StaffContactNo, staffNumberValid1, "Field Required");
		boolean password = valid.PasswordValidation(StaffPassword, staffPasswordValid1, "Field Required");
		if (fName && lName && contactNo && password) {
			String sql = "INSERT INTO staff(ID, First_name,Last_name,Username,Password,Blocked,Admin,Contact_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			String sql2 = "INSERT INTO staffhistory(ID, First_name,Last_name,Username,Password,Blocked,Admin,Contact_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			AddNewStaff add = new AddNewStaff();
			add.AddStaff(0, sql, StaffFirstName.getText(), StaffLastName.getText(), StaffPassword.getText(),
					StaffContactNo.getText(), "peter", false, false);
			add.AddStaff(0, sql2, StaffFirstName.getText(), StaffLastName.getText(), StaffPassword.getText(),
					StaffContactNo.getText(), "bob", false, false);
			LoadStaffData();
		}
	}

	/**
	 * This Method resets the password of staff this Method creates and calls a new
	 * instance of ResetStaff(method reset staff passwords) This method creates and
	 * calls a new instance of Validation to validate the inputs This method calls
	 * the LoadStaffData method to refresh the table
	 */
	public void ReseStaffPassword() {
		Validation valid = new Validation();
		boolean fName = valid.NameValidation(ResetStaffFirstName, staffFnameValid3, "Field Required");
		boolean lName = valid.NameValidation(ResetStaffLastName, staffLnameValid3, "Field Required");
		boolean id = valid.IDValidation(ResetStaffID, staffIdValid3, "Field Required");
		boolean password = valid.PasswordValidation(newPassword, staffPasswordValid3, "Field Required");
		if (fName && lName && id && password) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Are you sure you want to Reset Staff: \n" + ResetStaffFirstName.getText() + " "
					+ ResetStaffLastName.getText() + "s password");
			alert.setContentText("Staff ID : " + ResetStaffID.getText());
			Optional<ButtonType> action = alert.showAndWait();
			if (action.get() == ButtonType.OK) {
				ResetStaff reset = new ResetStaff();
				reset.ResetPassword(ResetStaffFirstName.getText(), ResetStaffLastName.getText(), newPassword.getText(),
						Integer.parseInt(ResetStaffID.getText()));
				LoadStaffData();
			}
		}
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
					System.out.println(id);
					String custID = load.LoadInvData(invData, invProdIdCol, invQuantityCol, invDescripCol, invPriceCol,
							invDiscountCol, invTotalCol, invoiceTable, id);
					System.out.println(custID);
					load.LoadInvCustData(invCustName, invCustAddress, invCustPostCode, invCustID, invID, invDate,
							custID, id);
					getSubTotal();
				}
			}
		});
	}

	/**
	 * this method calls and creates a new instance of the LoadReportData class this
	 * method makes use of the local date and date picker functions this method is
	 * called when the user wants to daily view reports this method creates and
	 * calls a new instance of Validation to make sure an option is selected
	 */
	public void LoadDailyReportData() {
		Validation valid = new Validation();
		Boolean optionIsNull = valid.DateIsNull(reportDatePicker, optionLabel3, "Selection Required");
		if (optionIsNull) {
			LocalDate date = reportDatePicker.getValue();
			LoadReportData load = new LoadReportData();
			load.LoadDailyRepData(repData, dailyInvNoCol, dailyStaffIdCol, dailyStaffNameCol, dailyCustFirstNameCol,
					dailyCustLastNameCol, dailyDateCol, dailyTotalCol, dailyTable, java.sql.Date.valueOf(date));

			ArrayList<Integer> total = new ArrayList<Integer>();
			for (ReportData i : dailyTable.getItems()) {
				total.add(Integer.parseInt(dailyTotalCol.getCellData(i)));
			}
			int subTotal = 0;
			for (int i : total)
				subTotal += i;
			dailyTotal.setText(Integer.toString(subTotal));
		}
	}

	/**
	 * this method calls and creates a new instance of the LoadReportData class this
	 * method makes use of the local date and date picker functions this method
	 * makes use of the Calendar class this method is called when the user wants to
	 * weekly view reports this method creates and calls a new instance of
	 * Validation to make sure an option is selected
	 */
	public void LoadWeeklyReportData() {
		Validation valid = new Validation();
		Boolean optionIsNull = valid.DateIsNull(weeklyDatePicker, optionLabel6, "Selection Required");
		if (optionIsNull) {
			Date date1 = java.sql.Date.valueOf(weeklyDatePicker.getValue());
			LoadReportData load = new LoadReportData();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			int week = cal.get(Calendar.WEEK_OF_YEAR);
			System.out.println(week);
			load.LoadWeekRepData(repData, weeklyInvNoCol, weeklyStaffIdCol, weeklyStaffNameCol, weeklyCustFirstNameCol,
					weeklyCustLastNameCol, weeklyDateCol, weeklyTotalCol, weeklyTable, week);

			ArrayList<Integer> total = new ArrayList<Integer>();
			for (ReportData i : weeklyTable.getItems()) {
				total.add(Integer.parseInt(weeklyTotalCol.getCellData(i)));
			}
			int subTotal = 0;
			for (int i : total)
				subTotal += i;
			weeklyTotal.setText(Integer.toString(subTotal));
		}
	}

	/**
	 * this method calls and creates a new instance of the LoadReportData class this
	 * method is called when the user wants to view monthly reports this method
	 * creates and calls a new instance of Validation to make sure an option is
	 * selected
	 */
	public void LoadMonthlyReportData() {
		Validation valid = new Validation();
		Boolean optionIsNull1 = valid.OptionIsNull(monthYears, optionLabel1, "Selection Required");
		Boolean optionIsNull2 = valid.OptionIsNull(monthMonth, optionLabel2, "Selection Required");

		if (optionIsNull1 && optionIsNull2) {
			int monthValue = monthMonth.getSelectionModel().getSelectedIndex() + 1;
			String monthValue1 = monthMonth.getValue().toString();
			String year = monthYears.getValue().toString();
			LoadReportData load = new LoadReportData();
			load.LoadMonthlyRepData(repData, MonthlyInvNoCol, MonthlyStaffIdCol, MonthlyStaffNameCol,
					MonthlyCustFirstNameCol, MonthlyCustLastNameCol, MonthlyDateCol, MonthlyTotalCol, MonthlyTable,
					monthValue, year, monthValue1);

			ArrayList<Integer> total = new ArrayList<Integer>();
			for (ReportData i : MonthlyTable.getItems()) {
				total.add(Integer.parseInt(MonthlyTotalCol.getCellData(i)));
			}
			int subTotal = 0;
			for (int i : total)
				subTotal += i;
			monthlyTotal.setText(Integer.toString(subTotal));
		}
	}

	/**
	 * this method calls and creates a new instance of the LoadReportData class this
	 * method is called when the user wants to view quarterly reports this method
	 * creates and calls a new instance of Validation to make sure an option is
	 * selected
	 */
	public void LoadQuarterlyReportData() {
		Validation valid = new Validation();
		Boolean optionIsNull1 = valid.OptionIsNull(quartYears, optionLabel4, "Selection Required");
		Boolean optionIsNull2 = valid.OptionIsNull(quartQuart, optionLabel41, "Selection Required");
		if (optionIsNull1 && optionIsNull2) {
			String year = quartYears.getValue().toString();
			int quartValue = quartQuart.getSelectionModel().getSelectedIndex() + 1;
			String quartValue2 = quartQuart.getValue().toString();
			LoadReportData load = new LoadReportData();
			load.LoadQuartRepData(repData, QuartInvNoCol, QuartStaffIdCol, QuartStaffNameCol, QuartCustFirstNameCol,
					QuartCustLastNameCol, QuartDateCol, QuartTotalCol, QuartTable, year, quartValue, quartValue2);

			ArrayList<Integer> total = new ArrayList<Integer>();
			for (ReportData i : QuartTable.getItems()) {
				total.add(Integer.parseInt(QuartTotalCol.getCellData(i)));
			}
			int subTotal = 0;
			for (int i : total)
				subTotal += i;
			quarterlyTotal.setText(Integer.toString(subTotal));
		}
	}

	/**
	 * this method calls and creates a new instance of the LoadReportData class this
	 * method is called when the user wants to view annual reports this method
	 * creates and calls a new instance of Validation to make sure an option is
	 * selected
	 */
	public void LoadAnnualReportData() {
		Validation valid = new Validation();
		Boolean optionIsNull = valid.OptionIsNull(annualYears, optionLabel5, "Selection Required");
		if (optionIsNull) {
			String year = annualYears.getValue().toString();
			LoadReportData load = new LoadReportData();
			load.LoadAnnualRepData(repData, AnnualInvNoCol, AnnualStaffIdCol, AnnualStaffNameCol,
					AnnualCustFirstNameCol, AnnualCustLastNameCol, AnnualDateCol, AnnualTotalCol, AnnualTable, year);

			ArrayList<Integer> total = new ArrayList<Integer>();
			for (ReportData i : AnnualTable.getItems()) {
				total.add(Integer.parseInt(AnnualTotalCol.getCellData(i)));
			}
			int subTotal = 0;
			for (int i : total)
				subTotal += i;
			annualTotal.setText(Integer.toString(subTotal));
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
	
	
	/*This method is called every time the user wants to clear the fields THis
	 * method creates a new button of the event source This method gets the parent
	 * of that button and finds all the children This method iterates though the
	 * children and if the child is a text field, set it to empty string
	 * 
	 * @param event the source of the event
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
	 * This method is called when the user wants to load suppler details This method
	 * creates and calls a new instance of LoadSupplierData methods
	 */
	public void LoadSupplierData() {
		String sql = "SELECT * FROM suppliers";
		LoadSupplierData load = new LoadSupplierData();
		load.LoadSupData(supData, sql, supIdCol, supCompanyNameCol, supFirstNameCol, supLastNameCol, supContactNoCol,
				supplierTable);
	}

}
