package DBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Beans.Coupon;
import Beans.Customer;
import DAO.CustomerDAO;
import connection.ConnectionPool;

public class CustomerDBDAO implements CustomerDAO {
	ConnectionPool cp = new ConnectionPool();

	@Override
	public boolean isCustomerExist(String email, String password) {
		try {
			Connection con = cp.getConnection();
			String query = "SELECT * FROM CUSTOMERS WHERE EMAIL=? AND PASSWORD=?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setString(1, email);
			mySQLStatement.setString(2, password);
			ResultSet result = mySQLStatement.executeQuery();
			if (result.next()) {
				return true;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public void addCustomer(Customer customer) {
		try {
			Connection con = cp.getConnection();
			String query = "INSERT INTO CUSTOMERS(FIRST_NAME,LAST_NAME, EMAIL, PASSWORD) VALUES(?, ?, ?,?);";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setString(1, customer.getFirstName());
			mySQLStatement.setString(2, customer.getLastName());
			mySQLStatement.setString(3, customer.getEmail());
			mySQLStatement.setString(4, customer.getPassword());
			mySQLStatement.execute();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			Connection con = cp.getConnection();
			String query = "UPDATE CUSTOMERS SET FirstNAME = ?,LASTNAME=?, EMAIL = ?, PASSWORD = ? WHERE ID = ?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setString(1, customer.getFirstName());
			mySQLStatement.setString(2, customer.getLastName());
			mySQLStatement.setString(3, customer.getEmail());
			mySQLStatement.setString(4, customer.getPassword());
			mySQLStatement.setInt(5, customer.getId());
			mySQLStatement.executeQuery();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void deleteCustomer(int customerID) {
		try {
			Connection con = cp.getConnection();
			String query = "DELETE FROM CUSTOMERS WHERE ID = ?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, customerID);
			mySQLStatement.executeQuery();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public ArrayList<Customer> getAllcustomers() {
		ArrayList<Customer> customers = new ArrayList<>();
		try {
			Connection con = cp.getConnection();
			String query = "SELECT * FROM CUSTOMERS ;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			ResultSet result = mySQLStatement.executeQuery();
			while (result.next()) {
				int customerId = result.getInt(1);
				String customerFirstName = result.getString(2);
				String customerLastName = result.getString(3);
				String email = result.getString(4);
				String password = result.getString(5);

				customers.add(new Customer(customerId, customerFirstName, customerLastName, email, password));

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return customers;
	}

	@Override
	public Customer getOneCustomer(int customerID) {
		Customer customer=null;
		try {
			Connection con = cp.getConnection();
			String query = "SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID = ?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, customerID);
			ResultSet result = mySQLStatement.executeQuery();
			while (result.next()) {
				String customerFirstName = result.getString(2);
				String customerLastName = result.getString(3);
				String email = result.getString(4);
				String password = result.getString(5);
				customer = new Customer(customerID, customerFirstName, customerLastName, email, password);

			}

		} catch (Exception ex) {
			return null;
		}
		return customer;
	}

}
