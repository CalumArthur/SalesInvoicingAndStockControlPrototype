package main;

/**
 * This class is an enum for the option box
 * 
 * @author 539676 Calum Arthur
 */
public enum Option {
	Staff, Admin;
	/**
	 * 
	 * @return the name of the enum
	 */
	public String value() {
		return name();
	}

	public static Option fromValue(String value) {
		return valueOf(value);
	}
}
