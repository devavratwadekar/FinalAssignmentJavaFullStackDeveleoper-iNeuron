package in.ineuron.main;

import java.sql.*;

public class CRUDApplication {
	private static final String DB_URL = "jdbc:mysql:///mydatabase";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Password@1997";

	public static void main(String[] args) {
		try {
			// Step 1: Establish connection to the database
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// Step 2: Create a statement object
			Statement statement = connection.createStatement();

			System.out.println("INSERT Record in employees_table");
			// Step 3: Perform CRUD operations
			// Create a record
			String insertQuery = "INSERT INTO employees_table (eid, ename, eage , eaddress) VALUES (1, 'Sachin', 49,'MI')";
			statement.executeUpdate(insertQuery);
			System.out.println("Record inserted successfully.\n");

			System.out.println("VIEW Record of employees_table");
			// Read records
			String selectQuery = "SELECT * FROM employees_table";
			ResultSet resultSet = statement.executeQuery(selectQuery);
			while (resultSet.next()) {
				int id = resultSet.getInt("eid");
				String name = resultSet.getString("ename");
				int age = resultSet.getInt("eage");
				String address = resultSet.getString("eaddress");
				System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Address: " + address);
			}

			System.out.println("\nUPDATE Record of employees_table");
			// Update a record
			String updateQuery = "UPDATE employees_table SET eage = 50 WHERE eid = 1";
			statement.executeUpdate(updateQuery);
			System.out.println("Record updated successfully.");

			System.out.println("\nDELETE Record of employees_table");
			// Delete a record
			String deleteQuery = "DELETE FROM employees_table WHERE eid = 1";
			statement.executeUpdate(deleteQuery);
			System.out.println("Record deleted successfully.");

			// Step 4: Close resources
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
