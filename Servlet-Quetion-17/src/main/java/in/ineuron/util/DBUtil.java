package in.ineuron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/blog_db";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	}
}
