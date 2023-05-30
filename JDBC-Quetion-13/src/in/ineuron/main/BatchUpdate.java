import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdate {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase"; // Replace with your PostgreSQL
																						// database URL
	private static final String USERNAME = "root"; // Replace with your PostgreSQL username
	private static final String PASSWORD = "Password@1997"; // Replace with your PostgreSQL password

	public static void main(String[] args) {
		String inputFile = "input-data.txt"; // input file name

		try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement()) {

			// Create the table if it doesn't exist
			String createTableQuery = "CREATE TABLE IF NOT EXISTS mytable (id SERIAL, name VARCHAR(100), age INTEGER)";
			statement.executeUpdate(createTableQuery);

			// Read the input data from the file
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				int age = Integer.parseInt(data[2]);

				// Add the data to the batch
				String insertQuery = "INSERT INTO mytable (id, name, age) VALUES (" + id + ", '" + name + "', " + age
						+ ")";
				statement.addBatch(insertQuery);
			}

			// Execute the batch update
			int[] updateCounts = statement.executeBatch();

			// Print the results
			System.out.println("Batch update executed successfully. Inserted rows: " + updateCounts.length);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
