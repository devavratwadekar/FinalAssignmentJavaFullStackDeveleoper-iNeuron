package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.User;

import java.util.List;

public class HibernateExample {
	public static void main(String[] args) {
		// Create the HIBERNATE configuration
		Configuration configuration = new Configuration();
		configuration.configure(); // Assumes hibernate.cfg.xml is in the classpath

		// Build the session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Create a session
		Session session = sessionFactory.openSession();

		// Retrieve data from the table using HIBERNATE
		List<User> userList = session.createQuery("FROM UserTable", User.class).list();

		// Display the data on the console
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
