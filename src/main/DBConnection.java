package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The role of this class is to establish a connection to the database
 * 
 * @author 539676 Calum Arthur
 */
public class DBConnection {

	/**
	 * create database connection
	 * 
	 * @return database connection
	 * @throws SQLException
	 *             error if cant connect to database, prevents crashing
	 */
	public static Connection getConnection() throws SQLException {
		String USERNAME = "root";
		String PASSWORD = "root";
		String CONN = "jdbc:mysql://localhost/gradedunit?useSSL=false";

		return DriverManager.getConnection(CONN, USERNAME, PASSWORD);
	}

}
