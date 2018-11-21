package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is to create a report data object
 * 
 * @author 539676 Calum Arthur
 */
public class ReportData {
	private StringProperty invID;
	private StringProperty staffID;
	private StringProperty staffName;
	private StringProperty custFirstName;
	private StringProperty custLastName;
	private StringProperty date;
	private StringProperty total;

	/**
	 * 
	 * @param invID
	 *            this will be the value of the invoice to be displayed in the
	 *            report
	 * @param staffID
	 *            this will be the value of the staff who made the sale
	 * @param staffName
	 *            this will be the last name of the staff who made the sale
	 * @param custFirstName
	 *            this will be the first name of the customer
	 * @param custLastName
	 *            this will be the last name of the customer
	 * @param date
	 *            this will be the date of the report
	 * @param total
	 *            this will total of the report
	 */
	public ReportData(String invID, String staffID, String staffName, String custFirstName, String custLastName,
			String date, String total) {
		this.invID = new SimpleStringProperty(invID);
		this.staffID = new SimpleStringProperty(staffID);
		this.staffName = new SimpleStringProperty(staffName);
		this.custFirstName = new SimpleStringProperty(custFirstName);
		this.custLastName = new SimpleStringProperty(custLastName);
		this.date = new SimpleStringProperty(date);
		this.total = new SimpleStringProperty(total);
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of invID(invoice id)
	 */
	public StringProperty invIDProperty() {
		return invID;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of staffID(a staff id)
	 */
	public StringProperty staffIDProperty() {
		return staffID;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of staffName(a staff name)
	 */
	public StringProperty staffNameProperty() {
		return staffName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of custFirstName(a customer first name)
	 */
	public StringProperty custFirstNameProperty() {
		return custFirstName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of custLastName(a customer last name)
	 */
	public StringProperty custLastNameProperty() {
		return custLastName;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * staff details interface
	 * 
	 * @return returns the value of date(date of invoice)
	 */
	public StringProperty dateProperty() {
		return date;
	}

	/**
	 * method to get the value of the String property to populate the columns in the
	 * reports interface
	 * 
	 * @return returns the value of total(total of invoice)
	 */
	public StringProperty totalProperty() {
		return total;
	}
}