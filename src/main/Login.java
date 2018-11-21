package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The role of this class is to act as the main drive for the application and to
 * load the first scene
 * 
 * @author 539676 Calum Arthur
 */
public class Login extends Application {

	@Override
	/**
	 * Start method, creates the first scene from the fxml file login.fxml
	 */
	public void start(Stage stage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("login.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
	}

	/**
	 * main
	 * 
	 * @param args
	 *            the arguments for main
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
