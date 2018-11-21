package staff;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is to call alerts
 * 
 * @author 539676 Calum Arthur
 *
 */
public class Alerts {

	/**
	 * This method displays and information alert
	 * 
	 * @param header
	 *            value for header
	 * @param content
	 *            value for content
	 */
	public void InfoAlert(String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(null);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
}
