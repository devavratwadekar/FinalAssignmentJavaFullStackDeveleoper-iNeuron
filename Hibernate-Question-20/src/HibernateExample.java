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

		// Retrieve the user with ID 1 from the database
		User user = session.get(User.class, 1L);

		if (user != null) {
			// Update the user's email
			user.setEmail("newemail@example.com");

			// Begin a transaction
			Transaction transaction = session.beginTransaction();

			// Update the user in the database
			session.update(user);

			// Commit the transaction
			transaction.commit();

			// Retrieve the updated data from the database
			List<User> userList = session.createQuery("FROM User", User.class).list();

			// Display the retrieved data on the console
			for (User updatedUser : userList) {
				System.out.println("ID: " + updatedUser.getId());
				System.out.println("Name: " + updatedUser.getName());
				System.out.println("Email: " + updatedUser.getEmail());
				System.out.println();
			}
		} else {
			System.out.println("User with ID 1 not found.");
		}

		// Close the session
		session.close();

		// Close the session factory
		sessionFactory.close();
	}
}
