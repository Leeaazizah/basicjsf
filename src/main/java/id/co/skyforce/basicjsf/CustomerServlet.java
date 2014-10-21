package id.co.skyforce.basicjsf;

import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;
import id.co.skyforce.basicjsf.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.Query;

public class CustomerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Session session = HibernateUtil.openSession();
		Transaction trx = (Transaction) session.beginTransaction();
		String action = req.getParameter("action");

		if (action.equals("save")) {
			String firstName = req.getParameter("nama_depan");
			String lastName = req.getParameter("nama_belakang");
			String inputBirthDate = req.getParameter("tanggal_lahir");
			String noTelpRumah = req.getParameter("no_telp_rumah");
			String noHandphone = req.getParameter("no_handphone");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String kota = req.getParameter("kota");
			String kodepos = req.getParameter("kodepos");
			String jalan = req.getParameter("jalan");

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date birthDate = null;
			try {
				birthDate = formatter.parse(inputBirthDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			

			Customer customer = new Customer();
			Address address = new Address();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setBirthDate(birthDate);
			customer.setHomePhone(noTelpRumah);
			customer.setMobileNo(noHandphone);
			customer.setEmail(email);
			customer.setPassword(password);
			customer.setAddress(address);

		
			address.setCity(kota);
			address.setPostalCode(kodepos);
			address.setStreet(jalan);

			session.save(address);
			session.save(customer);
			trx.commit();
			session.close();

			req.getRequestDispatcher("success_save.jsp").forward(req, resp);
		} else if (action.equals("update")) {
			long idCustomer = Long.parseLong(req.getParameter("id_customer"));
			Customer customer = (Customer) session.get(Customer.class,
					idCustomer);

			String firstName = req.getParameter("nama_depan");
			String lastName = req.getParameter("nama_belakang");
			String inputBirthDate = req.getParameter("tanggal_lahir");
			String noTelpRumah = req.getParameter("no_telp_rumah");
			String noHandphone = req.getParameter("no_handphone");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String kota = req.getParameter("kota");
			String kodepos = req.getParameter("kodepos");
			String jalan = req.getParameter("jalan");

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date birthDate = null;
			try {
				birthDate = formatter.parse(inputBirthDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Address address = new Address();
			
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setBirthDate(birthDate);
			customer.setHomePhone(noTelpRumah);
			customer.setMobileNo(noHandphone);
			customer.setEmail(email);
			customer.setPassword(password);
			customer.setAddress(address);

			
			address.setCity(kota);
			address.setPostalCode(kodepos);
			address.setStreet(jalan);

			session.save(address);
			session.save(customer);
			trx.commit();
			session.close();

			req.getRequestDispatcher("success_update.jsp").forward(req, resp);

		} else if (action.equals("delete")) {

			long idCustomer = Long.parseLong(req.getParameter("id_customer"));
			Customer customer = (Customer) session.get(Customer.class,
					idCustomer);
			Address address = new Address();
			if (idCustomer == customer.getId()) {
				session.delete(customer);
				session.delete(address);
				trx.commit();
				req.getRequestDispatcher("success_delete.jsp").forward(req,
						resp);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");

		if (action != null) {
			if (action.equals("update")) {
				long idCustomer = Long.parseLong(req.getParameter("user"));

				Session session = HibernateUtil.openSession();
				Transaction trx = session.beginTransaction();

				Customer customer = (Customer) session.get(Customer.class,
						idCustomer);

				req.setAttribute("customer", customer);
				session.close();

				req.getRequestDispatcher("formupdate.jsp").forward(req, resp);
			} else if (action.equals("delete")) {
				String idCustomer = req.getParameter("user");

				Session session = HibernateUtil.openSession();
				Transaction trx = session.beginTransaction();

				Customer cust = (Customer) session.get(Customer.class,
						Long.parseLong(idCustomer));

				session.delete(cust);
				trx.commit();

				Query query = session.createQuery("from Customer");
				List<Customer> customer = query.list();

				req.setAttribute("customer", customer);

				req.getRequestDispatcher("list.jsp").forward(req, resp);
				session.close();
			}
		}
		else {
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			 Query query = session.createQuery("from Customer");
			 List<Customer> customer = query.list();
			
			 req.setAttribute("customer", customer);
			 
			 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			 
			 req.setAttribute("formatter", formatter);
			
			 req.getRequestDispatcher("list.jsp").forward(req, resp);
			 session.close();

		}

		

	}

}
