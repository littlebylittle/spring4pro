package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlainContactDao implements ContactDAO {
	static {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			System.out.println("org.hsqldb.jdbcDriver class loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/asiavant", "sa", "");
	}

	private void closeConnection(Connection con) {
		if( con != null ) {
			try {
				con.close();
			} catch (SQLException ex ) {
				ex.printStackTrace();
			}
		}
	}
	@Override
	public List<Contact> findAll() {
		List<Contact> list = new ArrayList<>();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement s = c.prepareStatement("select * from contact");
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setFirstName(rs.getString("first_name"));
				contact.setLastName(rs.getString("last_name"));
				contact.setBirthDate(rs.getDate("birth_date"));
				list.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(c);
		}
		return list;
	}

	@Override
	public List<Contact> findByFirstName() {
		return null;
	}

	@Override
	public void insert(Contact c) {
		Connection cnct = null;
		String insert = "INSERT INTO CONTACT (first_name, last_name, birth_date) VALUES (?, ?, ?)";
		try {
			cnct = getConnection();
			PreparedStatement statement = cnct.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, c.getFirstName());
			statement.setString(2, c.getLastName());
			statement.setDate(3, c.getBirthDate());
			statement.execute();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			while(generatedKeys.next()) {
				c.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException ex) {
			Logger.getLogger(PlainContactDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			closeConnection(cnct);
		}
	}

	@Override
	public void update(Contact c) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void delete(Contact c) {
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement s = con.prepareStatement("DELETE FROM CONTACT WHERE id = ?",
					Statement.RETURN_GENERATED_KEYS);
			s.setLong(1, c.getId());
			s.execute();
		} catch (SQLException ex ) {
			ex.printStackTrace();
		} finally {
			closeConnection(con);
		}
	}

	public Connection testGetConnection() throws RuntimeException{
		try {
			return getConnection();
		} catch (SQLException ex) {
			System.err.println("Error in testGetConnection");
			Logger.getLogger(PlainContactDao.class.getName()).log(Level.SEVERE, null, ex);
			throw  new RuntimeException("DB FAILED");
		}
	}
}