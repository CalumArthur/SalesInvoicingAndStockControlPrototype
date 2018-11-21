package main;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import staff.StaffController;

/**
 * This class is the controller for the fxml file login.fxml. this class handles
 * all of the action events and main method calls for the login interface
 * 
 * @author 539676 Calum Arthur
 */
public class LoginController implements Initializable {

	LoginDB loginconnection = new LoginDB();
	@FXML
	private Label nameLabel;
	@FXML
	private Label passLabel;
	@FXML
	private Label optionLabel;
	@FXML
	private Button loginButton;
	@FXML
	private TextField userName;
	@FXML
	private PasswordField password;
	@FXML
	private ComboBox<Option> comboBox;

	/**
	 * Initializable the combo box to set the values to Option(enum values)
	 */
	public void initialize(URL url, ResourceBundle rb) {
		this.comboBox.setItems(FXCollections.observableArrayList(Option.values()));
	}

	/**
	 * this method preform's validation on the input fields creates a new instance
	 * of Validation and calls methods from it if all methods return true the Login
	 * method is called
	 * 
	 * @param event
	 *            this method is set to the log in button on the login screen
	 */
	public void Validate(ActionEvent event) {
		Validation valid = new Validation();
		Boolean nameIsNull = valid.TextFieldIsNull(userName, nameLabel, "Username Required");
		Boolean passIsNull = valid.TextFieldIsNull(password, passLabel, "Password Required");
		Boolean optionIsNull = valid.OptionIsNull(comboBox, optionLabel, "Selection Required");

		if (nameIsNull && passIsNull && optionIsNull) {
			Login();
		}
	}

	/**
	 * this method calls either the AdminLogin or the StaffLogin this method calls
	 * the database connection this method gets the stage of the current scene and
	 * closes it if the data from the fields matches then either staff or admin
	 * login will be called else an alert box will pop up with a message
	 */
	public void Login() {

		boolean admin = false;
		if (((Option) this.comboBox.getValue()).toString() == "Admin") {
			admin = true;
		}
		if (loginconnection.Login(userName.getText(), password.getText(), admin)) {
			Stage stage = (Stage) this.loginButton.getScene().getWindow();
			stage.close();
			switch (((Option) this.comboBox.getValue()).toString()) {
			case "Staff":
				StaffLogin();
				break;
			case "Admin":
				AdminLogin();
				break;
			}
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Incorrect Credentials");
			alert.setHeaderText("You have entered an invalid combination of username and password");
			String s = "Account type: " + ((Option) this.comboBox.getValue()).toString();
			alert.setContentText(s);
			alert.show();
		}
	}

	/**
	 * this method creates a new stage/pane/scene and loads the FXML document Admin
	 */
	public void AdminLogin() {
		try {
			Stage adminStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = (Pane) loader.load(getClass().getResource("/admin/Admin.fxml").openStream());
			Scene scene = new Scene(root);
			adminStage.setScene(scene);
			adminStage.setResizable(false);
			adminStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method creates a new stage/pane/scene and loads the FXML document Staff
	 * This method passed though the name of the staff who logged in
	 */
	public void StaffLogin() {
		try {
			Stage adminStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = (Pane) loader.load(getClass().getResource("/staff/Staff.fxml").openStream());
			StaffController staffController = loader.getController();
			staffController.getLoginName(userName.getText());
			Scene scene = new Scene(root);
			adminStage.setScene(scene);
			adminStage.setResizable(false);
			adminStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
