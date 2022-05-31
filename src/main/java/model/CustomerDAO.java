package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

	@Override
	public void create(Customer c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> read() {

		List<Customer> lista = new ArrayList<Customer>();

		String sql = "SELECT 	customer_id, store_id, first_name, last_name, email, a.address, ci.city, co.country, active "
				+ "FROM customer c inner join address a on (c.address_id = a.address_id)"
				+ "	inner join city ci on (a.city_id = ci.city_id)"
				+ " inner join country co on (co.country_id = ci.country_id) ";

		try {

			Connection cn = Conexion.getConexion();
			Statement s = cn.createStatement();

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				lista.add(new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("address"), rs.getString("city"),
						rs.getString("country"), rs.getBoolean("active")));
			}

		} catch (SQLException e) {
			System.out.println("Error al leer los customer.");
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Customer read(int id) {

		Customer c = null;

		String sql = "SELECT 	customer_id, store_id, first_name, last_name, email, a.address, ci.city, co.country, active "
				+ "FROM customer c inner join address a on (c.address_id = a.address_id)"
				+ "	inner join city ci on (a.city_id = ci.city_id)"
				+ " inner join country co on (co.country_id = ci.country_id) " + "WHERE c.customer_id = " + id;

		try {

			Connection cn = Conexion.getConexion();
			Statement s = cn.createStatement();

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				c = new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("address"), rs.getString("city"),
						rs.getString("country"), rs.getBoolean("active"));
			}

		} catch (SQLException e) {
			System.out.println("Error al leer los customer.");
			e.printStackTrace();
		}

		return c;

	}

	@Override
	public void update(Customer c) {

		/* sql para actualizar campos del customer */
		String sql = "update customer set first_name = '" + c.getFirst_name() + "', last_name = '" + c.getLast_name()
				+ "'. email = '" + c.getEmail() + "' WHERE customer_id = " + c.getCustomer_id();

		/* sql para actualizar el campo address de la tabla address relacionado con el cliente */
		String sql_a = "update address set address = '" + c.getAddress()
				+ "' where address_id = select (address_id) "
				+ " from customer where customer_id = " + c.getCustomer_id();

		try {

			Connection cn = Conexion.getConexion();
			Statement s = cn.createStatement();
			
			s.execute(sql);
			s.execute(sql_a);
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar Customer");
			e.printStackTrace();
		}

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
