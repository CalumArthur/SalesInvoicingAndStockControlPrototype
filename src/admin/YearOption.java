package admin;

/**
 * This class is an enum for the option box
 * 
 * @author 539676 Calum Arthur
 */
public enum YearOption {
	January, February, March, April, May, June, July, August, September, October, November, December;
	/**
	 * 
	 * @return the name of the enum
	 */
	public String value() {
		return name();
	}

	public static YearOption fromValue(String value) {
		return valueOf(value);
	}
}