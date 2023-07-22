package com.abdullah.JavaHibernateConnectMysql;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
	    System.setProperty("logging.level.org.hibernate", "DEBUG");
	    Configuration configuration = new Configuration()
	            .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
	            .setProperty("hibernate.connection.url", "jdbc:mysql://mysql-db:3306/mydb")
	            .setProperty("hibernate.connection.username", "root")
	            .setProperty("hibernate.connection.password", "abdullah123")
	            .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
	            .setProperty("hibernate.current_session_context_class", "thread")
	            .setProperty("hibernate.hbm2ddl.auto", "create")
	            // other hibernate properties can be configured here
	            .addAnnotatedClass(Employee.class);

	    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
	        // Create a Hibernate Session
	        try (Session session = sessionFactory.getCurrentSession()) {
	            // Start a transaction
	            session.beginTransaction();

	            // Create a new employee
	            Employee newEmployee = new Employee();
	            newEmployee.name = "memet";
	            newEmployee.age = 34;

	            // Save the employee to the database
	            session.save(newEmployee);
 
	            // Commit the transaction
	            session.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}

}
