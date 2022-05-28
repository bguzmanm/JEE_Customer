package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO{

	@Override
	public void create(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> read() {
		
		List<Customer> lista = new ArrayList<Customer>();
		
		String sql = "SELECT customer_id, store_id, first_name, last_name, email, address_id, active " + 
				"FROM customer ";
		
		try {
			
			Connection cn = Conexion.getConexion();
			Statement s = cn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				lista.add(new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), 
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), 
						rs.getInt("address_id"), rs.getBoolean("active")));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al leer los customer.");
			e.printStackTrace();
		}
				
		
		return lista;
	}

	@Override
	public Customer read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
