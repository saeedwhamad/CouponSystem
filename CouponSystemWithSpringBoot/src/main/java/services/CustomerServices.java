package services;

import java.util.ArrayList;

import beans.Customer;

public interface CustomerServices {
	public boolean isCustomerExist(String email, String password);

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int customerID);

	public ArrayList<Customer> getAllcustomers();

	public Customer getOneCustomer(int customerID);
}
