package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/*
 * This class contains various validation methods
 */
public class Validation {
	/**
	 * This method is used to check when a text field is null This method is called
	 * when ever the user tries to perform a function that requires text input
	 * 
	 * @param field
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean TextFieldIsNull(TextField field, Label label, String validationText) {
		if (field.getText().isEmpty()) {
			label.setText(validationText);
			return false;
		} else {
			label.setText(" ");
		}
		return true;
	}

	/**
	 * This method is used to check when a text field is null This method is used to
	 * check when a text field name matches the desired input for names this method
	 * used regular expressions to validate the input with a matcher This method is
	 * called when ever the user tries to perform a function that requires text
	 * input
	 * 
	 * @param field
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean NameValidation(TextField field, Label label, String validationText) {
		String namePattern = "[A-Z][a-z ]*{2,20}";
		Pattern pattern = Pattern.compile(namePattern);
		Matcher regexMatcher = pattern.matcher(field.getText());

		if (field.getText().isEmpty()) {
			label.setText(validationText);
			return false;
		} else if (!regexMatcher.matches()) {
			label.setText("Invalid format");
			return false;
		} else {
			label.setText(" ");
		}
		return true;
	}

	/**
	 * This method is used to check when a text field is null This method is used to
	 * check when a text field name matches the desired input for addresses this
	 * method used regular expressions to validate the input with a matcher This
	 * method is called when ever the user tries to perform a function that requires
	 * text input for address
	 * 
	 * @param field
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean Address(TextField field, Label label, String validationText) {
		String namePattern = "^\\d+\\s[A-z].{2,20}";
		Pattern pattern = Pattern.compile(namePattern);
		Matcher regexMatcher = pattern.matcher(field.getText());

		if (field.getText().isEmpty()) {
			label.setText(validationText);
			return false;
		} else if (!regexMatcher.matches()) {
			label.setText("Invalid format");
			return false;
		} else {
			label.setText(" ");
		}
		return true;
	}

	/**
	 * This method is used to check when a text field is null This method is used to
	 * check when a text field name matches the desired input for post codes this
	 * method used regular expressions to validate the input with a matcher This
	 * method is called when ever the user tries to perform a function that requires
	 * text input for post code
	 * 
	 * @param field
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean PostCodeValidation(TextField field, Label label, String validationText) {
		String namePattern = "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9]?[A-Za-z]))))\\s?[0-9][A-Za-z]{2})";
		Pattern pattern = Pattern.compile(namePattern);
		Matcher regexMatcher = pattern.matcher(field.getText());

		if (field.getText().isEmpty()) {
			label.setText(validationText);
			return false;
		} else if (!regexMatcher.matches()) {
			label.setText("Invalid format");
			return false;
		} else {
			label.setText(" ");
		}
		return true;
	}

	/**
	 * This method is used to check when a text field is null This method is used to
	 * check when a text field name matches the desired input for email this method
	 * used regular expressions to validate the input with a matcher This method is
	 * called when ever the user tries to perform a function that requires text
	 * input for email addresses
	 * 
	 * @param field
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean EmailValidation(TextField field, Label label, String validationText) {
		String namePattern = "[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*";
		Pattern pattern = Pattern.compile(namePattern);
		Matcher regexMatcher = pattern.matcher(field.getText());

		if (field.getText().isEmpty()) {
			label.setText(validationText);
			return false;
		} else if (!regexMatcher.matches()) {
			label.setText("Invalid format");
			return false;
		} else {
			label.setText(" ");
		}
		return true;
	}

	/**
	 * This method is used to check when a text field is null This method is used to
	 * check when a text field name matches the desired input for id fields this
	 * method used regular expressions to validate the input with a matcher This
	 * method is called when ever the user tries to perform a function that requires
	 * text input for id fields
	 * 
	 * @param field
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean IDValidation(TextField field, Label label, String validationText) {
		String namePattern = "[0-9]*";
		Pattern pattern = Pattern.compile(namePattern);
		Matcher regexMatcher = pattern.matcher(field.getText());

		if (field.getText().isEmpty()) {
			label.setText(validationText);
			return false;
		} else if (!regexMatcher.matches()) {
			label.setText("Invalid format");
			return false;
		} else {
			label.setText(" ");
			return true;
		}
	}

	/**
	 * This method is used to check when a text field is null This method is used to
	 * check when a text field name matches the desired input for phone numbers this
	 * method used regular expressions to validate the input with a matcher This
	 * method is called when ever the user tries to perform a function that requires
	 * text input for phone numbers
	 * 
	 * @param field
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean NumberValidation(TextField field, Label label, String validationText) {
		String namePattern = "[0-9]{11,11}";
		Pattern pattern = Pattern.compile(namePattern);
		Matcher regexMatcher = pattern.matcher(field.getText());

		if (field.getText().isEmpty()) {
			label.setText(validationText);
			return false;
		} else if (!regexMatcher.matches()) {
			label.setText("Invalid format");
			return false;
		} else {
			label.setText(" ");
		}
		return true;
	}

	/**
	 * This method is used to check when a text field is null This method is used to
	 * check when a text field name matches the desired input for passwords this
	 * method used regular expressions to validate the input with a matcher This
	 * method is called when ever the user tries to perform a function that requires
	 * text input for passwords
	 * 
	 * @param field
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean PasswordValidation(TextField field, Label label, String validationText) {
		String namePattern = "^[a-zA-Z]\\w{3,14}";
		Pattern pattern = Pattern.compile(namePattern);
		Matcher regexMatcher = pattern.matcher(field.getText());

		if (field.getText().isEmpty()) {
			label.setText(validationText);
			return false;
		} else if (!regexMatcher.matches()) {
			label.setText("Invalid format");
			return false;
		} else {
			label.setText(" ");
		}
		return true;
	}

	/**
	 * This method is used to check when a combo box is null this method used
	 * regular expressions to validate the input with a matcher This method is
	 * called when ever the user tries to perform a function that requires text
	 * input from combo box's
	 * 
	 * @param comboBox
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean OptionIsNull(ComboBox<?> comboBox, Label label, String validationText) {
		if ((comboBox.getValue()) == null) {
			label.setText(validationText);
			return false;
		} else {
			label.setText(" ");
		}
		return true;
	}

	/**
	 * This method is used to check when a date is null this method used regular
	 * expressions to validate the input with a matcher This method is called when
	 * ever the user tries to perform a function that requires text input from date
	 * pickers
	 * 
	 * @param date
	 *            the text field to be checked
	 * @param label
	 *            the label to be displayed
	 * @param validationText
	 *            the text for the label
	 * @return returns back to where the method was called, returns true if all
	 *         conditions met
	 */
	public boolean DateIsNull(DatePicker date, Label label, String validationText) {
		if ((date.getValue()) == null) {
			label.setText(validationText);
			return false;
		} else {
			label.setText(" ");
		}
		return true;
	}

}
