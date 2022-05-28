package model;

import java.util.List;

public interface IAddressDAO {
	
	public void create(Address a);
	public List<Address> read();
	public Address read(int id);
	public void update(Address a);
	public void delete(Address a);
	public void delete(int id);

}
