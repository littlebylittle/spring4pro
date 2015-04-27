package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShutdownMainClass {
	static {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			System.out.println("org.hsqldb.jdbcDriver class loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			shutDown();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection shutDown() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/asiavant;shutdown=true", "sa", "");
	}
}
