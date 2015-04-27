package domain;

import java.util.List;

public interface ContactDAO {
	public List<Contact>  findAll();
	public List<Contact> findByFirstName();
	public void insert(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
}
