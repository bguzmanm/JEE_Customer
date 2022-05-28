package model;

import java.util.List;

public interface ICustomerDAO {

	
	public void create(Customer c);
	public List<Customer> read();
	public Customer read(int id);
	public void update(Customer c);
	public void delete(Customer c);
	public void delete(int id);
	
}
