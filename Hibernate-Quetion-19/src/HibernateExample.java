import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateExample {
	public static void main(String[] args) {
		// Create the Hibernate configuration
		Configuration configuration = new Configuration();
		configuration.configure(); // Assumes hibernate.cfg.xml is in the classpath

		// Build the session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Create a session
		Session session = sessionFactory.openSession();

		// Create a new user object
		User newUser = new User();
		newUser.setName("John Doe");
		newUser.setEmail("johndoe@example.com");

		// Begin a transaction
		Transaction transaction = session.beginTransaction();

		// Insert the user object into the database
		session.save(newUser);

		// Commit the transaction
		transaction.commit();

		// Retrieve the inserted data from the database
		List<User> userList = session.createQuery("FROM User", User.class).list();

		// Display the retrieved data on the console
		for (User user : userList) {
			System.out.println("ID: " + user.getId());
			System.out.println("Name: " + user.getName());
			System.out.println("Email: " + user.getEmail());
			System.out.println();
		}

		// Close the session
		session.close();

		// Close the session factory
		sessionFactory.close();
	}
}
