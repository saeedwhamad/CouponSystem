package Facades;



import DAO.CompaniesDAO;
import DAO.CouponsDAO;
import DAO.CustomerDAO;
import DBDAO.CompaniesDBDAO;
import DBDAO.CouponsDBDAO;
import DBDAO.CustomerDBDAO;


public class ClientFacade {
	CompaniesDAO companiesDAO=new CompaniesDBDAO();
	CustomerDAO customersDAO=new CustomerDBDAO();
	CouponsDAO couponsDAO=new CouponsDBDAO();
	
	
	
	public boolean login(String email,String password) {
	if(companiesDAO.isCompanyExist(email, password)||customersDAO.isCustomerExist(email, password)) {
		return true;
	}else if (email == "admin@admin.com" && password == "admin") {
		return true;
	}
	return false;
	
	}

}
