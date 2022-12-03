package services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import Repositories.CustomerRepository;
import beans.Customer;

public class CustomerServicesImpl implements CustomerServices {
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public boolean isCustomerExist(String email, String password) {
		
		return false;
	}

	@Override
	public void addCustomer(Customer customer) {
	customerRepo.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepo.save(customer);
	}

	@Override
	public void deleteCustomer(int customerID) {
		customerRepo.deleteById(customerID);

	}

	@Override
	public ArrayList<Customer> getAllcustomers() {
		
		return (ArrayList<Customer>) customerRepo.findAll();
	}

	@Override
	public Customer getOneCustomer(int customerID) {
		// TODO Auto-generated method stub
		return customerRepo.getById(customerID);
	}

}
