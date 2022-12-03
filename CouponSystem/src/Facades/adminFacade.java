package Facades;

import java.util.ArrayList;

import Beans.Company;
import Beans.Customer;

public class adminFacade extends ClientFacade {

	public adminFacade() {

	}



	public void addCompany(Company company) {
		companiesDAO.addCompany(company);

	}

	public void updateComoany(Company company) {
		companiesDAO.updateCompany(company);

	}

	public void deleteComoany(int companyID) {
		companiesDAO.deleteCompany(companyID);

	}

	public ArrayList<Company> getAllCompanies() {
		return companiesDAO.getAllcompanies();
	}

	public Company getOneCompany(int CompanyID) {
		return companiesDAO.getOneCompany(CompanyID);
	}
	public void addCustomer(Customer customer) {
		customersDAO.addCustomer(customer);

	}

	public void updateCustomer(Customer customer) {
		customersDAO.updateCustomer(customer);

	}

	public void deleteCustomer(int customerID) {
		customersDAO.deleteCustomer(customerID);

	}

	public ArrayList<Customer> getAllCustomers() {
		return customersDAO.getAllcustomers();
	}

	public Customer getOneCustomer(int CompanyID) {
		return customersDAO.getOneCustomer(CompanyID);
	}

	
	
}
