package DAO;

import java.util.ArrayList;

import Beans.Company;

public interface CompaniesDAO {
	public boolean isCompanyExist(String email, String password);

	public void addCompany(Company company);

	public void updateCompany(Company company);

	public void deleteCompany(int companyID);

	public ArrayList<Company> getAllcompanies();

	public Company getOneCompany(int companyID);

}
