package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.AddressDAO;
import model.Customer;
import model.CustomerDAO;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/customers")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private CustomerDAO cDAO = new CustomerDAO();

	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");

		if (op == null) {
			op = "listar";
		}

		switch (op) {
		case "listar":
			List<Customer> customers = cDAO.read();
			request.setAttribute("customers", customers);

			getServletContext().getRequestDispatcher("/views/customers.jsp").forward(request, response);
			break;
		case "edit":
			
			String id = request.getParameter("id");
			if (id == null) {
			
				throw new IllegalArgumentException("Unexpected value: " + op);				
			}
			
			Customer c = cDAO.read(Integer.parseInt(id));
			
			
			request.setAttribute("customer", c);
			
			getServletContext().getRequestDispatcher("/views/customer.jsp").forward(request, response);
			
			
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		
		
	}

}
