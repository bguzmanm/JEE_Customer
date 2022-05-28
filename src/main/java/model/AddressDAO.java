package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AddressDAO implements IAddressDAO{

	@Override
	public void create(Address a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, Address> read() {
		Map<Integer, Address> a = new TreeMap<Integer, Address>();
		
		
		String sql = "select address_id, address, address2, district, c.city as city, co.country "
				+ " from address a inner join city c ON (a.city_id = c.city_id) "
				+ "	inner join country co on (c.country_id = co.country_id)";
		
		try {
			Connection c = Conexion.getConexion();
			Statement s = c.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				a.put(rs.getInt("address_id"), new Address(rs.getInt("address_id"), rs.getString("address"), rs.getString("address2"), 
						rs.getString("district"), rs.getString("city"), rs.getString("country")));
				
			}
		} catch (SQLException e) {
			System.out.println("Error al leer la dirección read()");
		}
		
		return a;
	}

	@Override
	public Address read(int id) {
		
		Address a = null;
		
		String sql = "select address_id, address, address2, district, c.city as city, co.country "
				+ " from address a inner join city c ON (a.city_id = c.city_id) "
				+ "	inner join country co on (c.country_id = co.country_id) where address_id = " + id;
		
		
		try {
			Connection c = Conexion.getConexion();
			Statement s = c.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				a = new Address(rs.getInt("address_id"), rs.getString("address"), rs.getString("address2"), 
						rs.getString("district"), rs.getString("city"), rs.getString("country"));
			}
		} catch (SQLException e) {
			System.out.println("Error al leer la dirección read()");
		}
		
		return a;
	}

	@Override
	public void update(Address a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Address a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
