package admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.DBConnection;
import staff.Alerts;

/**
 * This class is to load the report data from the database This class creates a
 * new instance of alerts
 * 
 * @author 539676 Calum Arthur
 */
public class LoadReportData {

	Alerts alert = new Alerts();

	/**
	 * This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of ReportData in the
	 * correct fields Uses the fields to populate the table views in quarterly
	 * reportSuite interface
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param InvNoCol
	 *            the table column that will be populated with the invoice id field
	 *            from the database
	 * @param StaffIdCol
	 *            the table column that will be populated with the staff id field
	 *            from the database
	 * @param StaffNameCol
	 *            the table column that will be populated with the staff name id
	 *            field from the database
	 * @param CustFirstNameCol
	 *            the table column that will be populated with the customer first
	 *            name field from the database
	 * @param CustLastNameCol
	 *            the table column that will be populated with the customer last
	 *            name field from the database
	 * @param DateCol
	 *            the table column that will be populated with the invoice date
	 *            field from the database
	 * @param TotalCol
	 *            the table column that will be populated with the invoice total
	 *            field from the database
	 * @param reportTable1
	 *            the table that will be populated
	 * @param week
	 *            the week value
	 */
	public void LoadWeekRepData(ObservableList<ReportData> data, TableColumn<ReportData, String> InvNoCol,
			TableColumn<ReportData, String> StaffIdCol, TableColumn<ReportData, String> StaffNameCol,
			TableColumn<ReportData, String> CustFirstNameCol, TableColumn<ReportData, String> CustLastNameCol,
			TableColumn<ReportData, String> DateCol, TableColumn<ReportData, String> TotalCol,
			TableView<ReportData> reportTable1, int week) {
		String sql = "SELECT i.id, s.ID, s.First_name, c.first_name, c.last_name, i.date, i.total "
				+ "FROM invoices i JOIN customers c ON i.cust_id = c.id " + "JOIN staff s ON i.staff_id = s.ID "
				+ "WHERE WEEK(i.date) = ? GROUP BY i.id";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, week);
			ResultSet rs = stmt.executeQuery();
			data = FXCollections.observableArrayList();
			if (!rs.next()) {
				alert.InfoAlert("Week: " + week + " Has no sales", "Please enter a different weeek");
				return;
			} else {
				do {
					data.add(new ReportData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7)));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// populating the columns in the table view with the fields from the ProductData
		// class
		InvNoCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("invID"));
		StaffIdCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffID"));
		StaffNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffName"));
		CustFirstNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custFirstName"));
		CustLastNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custLastName"));
		DateCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("date"));
		TotalCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("total"));
		reportTable1.setItems(null);
		reportTable1.setItems(data);
	}

	/**
	 * This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of ReportData in the
	 * correct fields Uses the fields to populate the table views in quarterly
	 * reportSuite interface
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param InvNoCol
	 *            the table column that will be populated with the invoice id field
	 *            from the database
	 * @param StaffIdCol
	 *            the table column that will be populated with the staff id field
	 *            from the database
	 * @param StaffNameCol
	 *            the table column that will be populated with the staff name id
	 *            field from the database
	 * @param CustFirstNameCol
	 *            the table column that will be populated with the customer first
	 *            name field from the database
	 * @param CustLastNameCol
	 *            the table column that will be populated with the customer last
	 *            name field from the database
	 * @param DateCol
	 *            the table column that will be populated with the invoice date
	 *            field from the database
	 * @param TotalCol
	 *            the table column that will be populated with the invoice total
	 *            field from the database
	 * @param reportTable1
	 *            the table that will be populated
	 * @param year
	 *            The year value
	 * 
	 */
	public void LoadAnnualRepData(ObservableList<ReportData> data, TableColumn<ReportData, String> InvNoCol,
			TableColumn<ReportData, String> StaffIdCol, TableColumn<ReportData, String> StaffNameCol,
			TableColumn<ReportData, String> CustFirstNameCol, TableColumn<ReportData, String> CustLastNameCol,
			TableColumn<ReportData, String> DateCol, TableColumn<ReportData, String> TotalCol,
			TableView<ReportData> reportTable1, String year) {
		String sql = "SELECT i.id, s.ID, s.First_name, c.first_name, c.last_name, i.date, i.total "
				+ "FROM invoices i JOIN customers c ON i.cust_id = c.id " + "JOIN staff s ON i.staff_id = s.ID "
				+ "WHERE YEAR(i.date) = ? GROUP BY i.id";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, year);
			ResultSet rs = stmt.executeQuery();
			data = FXCollections.observableArrayList();
			if (!rs.next()) {
				alert.InfoAlert("The year: " + year + " Has no sales", "Please enter a different Year");
				return;
			} else {
				do {
					data.add(new ReportData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7)));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// populating the columns in the table view with the fields from the ProductData
		// class
		InvNoCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("invID"));
		StaffIdCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffID"));
		StaffNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffName"));
		CustFirstNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custFirstName"));
		CustLastNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custLastName"));
		DateCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("date"));
		TotalCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("total"));
		reportTable1.setItems(null);
		reportTable1.setItems(data);
	}

	/**
	 * This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of ReportData in the
	 * correct fields Uses the fields to populate the table views in quarterly
	 * reportSuite interface
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param InvNoCol
	 *            the table column that will be populated with the invoice id field
	 *            from the database
	 * @param StaffIdCol
	 *            the table column that will be populated with the staff id field
	 *            from the database
	 * @param StaffNameCol
	 *            the table column that will be populated with the staff name id
	 *            field from the database
	 * @param CustFirstNameCol
	 *            the table column that will be populated with the customer first
	 *            name field from the database
	 * @param CustLastNameCol
	 *            the table column that will be populated with the customer last
	 *            name field from the database
	 * @param DateCol
	 *            the table column that will be populated with the invoice date
	 *            field from the database
	 * @param TotalCol
	 *            the table column that will be populated with the invoice total
	 *            field from the database
	 * @param reportTable1
	 *            the table that will be populated
	 * @param year
	 *            the value of the year
	 * @param quart
	 *            the value of the quarter
	 * @param quart2
	 *            the string value of quarter for message alert
	 */
	public void LoadQuartRepData(ObservableList<ReportData> data, TableColumn<ReportData, String> InvNoCol,
			TableColumn<ReportData, String> StaffIdCol, TableColumn<ReportData, String> StaffNameCol,
			TableColumn<ReportData, String> CustFirstNameCol, TableColumn<ReportData, String> CustLastNameCol,
			TableColumn<ReportData, String> DateCol, TableColumn<ReportData, String> TotalCol,
			TableView<ReportData> reportTable1, String year, int quart, String quart2) {
		String sql = "SELECT i.id, s.ID, s.First_name, c.first_name, c.last_name, i.date, i.total "
				+ "FROM invoices i JOIN customers c ON i.cust_id = c.id " + "JOIN staff s ON i.staff_id = s.ID "
				+ "WHERE YEAR(i.date) = ? AND QUARTER(i.date) = ? GROUP BY i.id";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, year);
			stmt.setInt(2, quart);
			ResultSet rs = stmt.executeQuery();
			data = FXCollections.observableArrayList();
			if (!rs.next()) {
				alert.InfoAlert("The " + quart2 + " of " + year + " Has no sales",
						"Please enter a different Year/Quarter");
				return;
			} else {
				do {
					data.add(new ReportData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7)));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// populating the columns in the table view with the fields from the ProductData
		// class
		InvNoCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("invID"));
		StaffIdCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffID"));
		StaffNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffName"));
		CustFirstNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custFirstName"));
		CustLastNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custLastName"));
		DateCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("date"));
		TotalCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("total"));
		reportTable1.setItems(null);
		reportTable1.setItems(data);
	}

	/**
	 * This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of ReportData in the
	 * correct fields Uses the fields to populate the table views in monthly
	 * reportSuite interface
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param InvNoCol
	 *            the table column that will be populated with the invoice id field
	 *            from the database
	 * @param StaffIdCol
	 *            the table column that will be populated with the staff id field
	 *            from the database
	 * @param StaffNameCol
	 *            the table column that will be populated with the staff name id
	 *            field from the database
	 * @param CustFirstNameCol
	 *            the table column that will be populated with the customer first
	 *            name field from the database
	 * @param CustLastNameCol
	 *            the table column that will be populated with the customer last
	 *            name field from the database
	 * @param DateCol
	 *            the table column that will be populated with the invoice date
	 *            field from the database
	 * @param TotalCol
	 *            the table column that will be populated with the invoice total
	 *            field from the database
	 * @param reportTable1
	 *            the table that will be populated
	 * @param month
	 *            the month for the sale
	 * @param year
	 *            the year of the sale
	 * @param month1
	 *            the string value of month for message alert
	 */
	public void LoadMonthlyRepData(ObservableList<ReportData> data, TableColumn<ReportData, String> InvNoCol,
			TableColumn<ReportData, String> StaffIdCol, TableColumn<ReportData, String> StaffNameCol,
			TableColumn<ReportData, String> CustFirstNameCol, TableColumn<ReportData, String> CustLastNameCol,
			TableColumn<ReportData, String> DateCol, TableColumn<ReportData, String> TotalCol,
			TableView<ReportData> reportTable1, int month, String year, String month1) {
		String sql = "SELECT i.id, s.ID, s.First_name, c.first_name, c.last_name, i.date, i.total "
				+ "FROM invoices i JOIN customers c ON i.cust_id = c.id " + "JOIN staff s ON i.staff_id = s.ID "
				+ "WHERE MONTH(i.date) = ? AND YEAR(i.date) = ? GROUP BY i.id";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, month);
			stmt.setString(2, year);
			ResultSet rs = stmt.executeQuery();
			data = FXCollections.observableArrayList();
			if (!rs.next()) {
				alert.InfoAlert(month1 + " of " + year + " Has no sales", "Please enter a different Year/Month");
				return;
			} else {
				do {
					data.add(new ReportData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7)));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// populating the columns in the table view with the fields from the ProductData
		// class
		InvNoCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("invID"));
		StaffIdCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffID"));
		StaffNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffName"));
		CustFirstNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custFirstName"));
		CustLastNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custLastName"));
		DateCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("date"));
		TotalCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("total"));
		reportTable1.setItems(null);
		reportTable1.setItems(data);
	}

	/**
	 * This method connects to the data base This method is called from the
	 * AdminController class Stores the data in a new instance of ReportData in the
	 * correct fields Uses the fields to populate the table views in Daily
	 * reportSuite interface
	 * 
	 * @param data
	 *            this is the ObservableList that will be used to populate the
	 *            tables
	 * @param dailyInvNoCol
	 *            the table column that will be populated with the invoice id field
	 *            from the database
	 * @param dailyStaffIdCol
	 *            the table column that will be populated with the staff id field
	 *            from the database
	 * @param dailyStaffNameCol
	 *            the table column that will be populated with the staff name id
	 *            field from the database
	 * @param dailyCustFirstNameCol
	 *            the table column that will be populated with the customer first
	 *            name field from the database
	 * @param dailyCustLastNameCol
	 *            the table column that will be populated with the customer last
	 *            name field from the database
	 * @param dailyDateCol
	 *            the table column that will be populated with the invoice date
	 *            field from the database
	 * @param dailyTotalCol
	 *            the table column that will be populated with the invoice total
	 *            field from the database
	 * @param reportTable1
	 *            the table that will be populated
	 * @param date
	 *            the date of the sale
	 */
	public void LoadDailyRepData(ObservableList<ReportData> data, TableColumn<ReportData, String> dailyInvNoCol,
			TableColumn<ReportData, String> dailyStaffIdCol, TableColumn<ReportData, String> dailyStaffNameCol,
			TableColumn<ReportData, String> dailyCustFirstNameCol, TableColumn<ReportData, String> dailyCustLastNameCol,
			TableColumn<ReportData, String> dailyDateCol, TableColumn<ReportData, String> dailyTotalCol,
			TableView<ReportData> reportTable1, Date date) {
		String sql = "SELECT i.id, s.ID, s.First_name, c.first_name, c.last_name, i.date, i.total "
				+ "FROM invoices i JOIN customers c ON i.cust_id = c.id " + "JOIN staff s ON i.staff_id = s.ID "
				+ "WHERE i.date = ? GROUP BY i.id";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setDate(1, date);
			ResultSet rs = stmt.executeQuery();
			data = FXCollections.observableArrayList();
			if (!rs.next()) {
				alert.InfoAlert(date + " Has no sales", "Please enter a different Day");
				return;
			} else {
				do {
					data.add(new ReportData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7)));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// populating the columns in the table view with the fields from the ProductData
		// class
		dailyInvNoCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("invID"));
		dailyStaffIdCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffID"));
		dailyStaffNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("staffName"));
		dailyCustFirstNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custFirstName"));
		dailyCustLastNameCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("custLastName"));
		dailyDateCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("date"));
		dailyTotalCol.setCellValueFactory(new PropertyValueFactory<ReportData, String>("total"));
		reportTable1.setItems(null);
		reportTable1.setItems(data);
	}
}
