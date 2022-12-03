package services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import Repositories.CompanyRepository;
import beans.Company;

public class companyServicesImpl implements companyServices {

	@Autowired
	CompanyRepository companyRepo;

	@Override
	public boolean isCompanyExist(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addCompany(Company company) {
		companyRepo.save(company);
	}

	@Override
	public void updateCompany(Company company) {
		companyRepo.save(company);

	}

	@Override
	public void deleteCompany(int companyID) {
		companyRepo.deleteById(companyID);
	}

	@Override
	public ArrayList<Company> getAllcompanies() {
		return (ArrayList<Company>) companyRepo.findAll();
	}

	@Override
	public Company getOneCompany(int companyID) {
		return companyRepo.getById(companyID);
	}

}
