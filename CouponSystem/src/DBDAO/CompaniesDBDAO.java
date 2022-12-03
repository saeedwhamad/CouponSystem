package DBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Beans.Company;
import DAO.CompaniesDAO;
import connection.ConnectionPool;

public class CompaniesDBDAO implements CompaniesDAO {
	ConnectionPool cp = new ConnectionPool();
	

	@Override
	public boolean isCompanyExist(String email, String password) {
		Connection con = cp.getConnection();
		try {

			String query = "SELECT * FROM COMPANIES WHERE EMAIL=? AND PASSWORD=?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setString(1, email);
			mySQLStatement.setString(2, password);
			ResultSet result = mySQLStatement.executeQuery();

			if (result.next()) {
				con.close();
				return true;
			}

			con.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	@Override
	public void addCompany(Company company) {
		Connection coon = cp.getConnection();
		try {
			String query = "INSERT INTO COMPANIES(NAME, EMAIL, PASSWORD) VALUES(?, ?, ?);";
			PreparedStatement mySQLStatement = coon.prepareStatement(query);
			mySQLStatement.setString(1, company.getName());
			mySQLStatement.setString(2, company.getEmail());
			mySQLStatement.setString(3, company.getPassword());
			mySQLStatement.executeUpdate();
			coon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCompany(Company company) {
		Connection coon = cp.getConnection();
		try {

			String query = "UPDATE COMPANIES SET NAME = ?, EMAIL = ?, PASSWORD = ? WHERE ID = ?;";
			PreparedStatement mySQLStatement = coon.prepareStatement(query);
			mySQLStatement.setString(1, company.getName());
			mySQLStatement.setString(2, company.getEmail());
			mySQLStatement.setString(3, company.getPassword());
			mySQLStatement.setInt(4, company.getId());
			mySQLStatement.executeUpdate();
			coon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCompany(int companyID) {
		Connection con = cp.getConnection();

		try {
			String query = "DELETE FROM COMPANIES WHERE ID = ?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, companyID);
			mySQLStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Company> getAllcompanies() {
		Connection con = cp.getConnection();
		ArrayList<Company> companies = new ArrayList<>();
	
		try {
			
			String query = "SELECT * FROM COMPANIES ;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			ResultSet result = mySQLStatement.executeQuery();
			while (result.next()) {
				
			
				int companyId = result.getInt(1);
				String companyName = result.getString(2);
				String email = result.getString(3);
				String password = result.getString(4);
			
			
				companies.add(new Company(companyId, companyName, email, password));

			}
		} catch (Exception ex) {
			return null;
		}
		return companies;
	}
	@Override
	public Company getOneCompany(int companyID) {
		Connection con = cp.getConnection();
		Company company = null;
	
		String query = "SELECT * FROM COMPANIES WHERE ID = ?;";
		PreparedStatement mySQLStatement;
		try {
			mySQLStatement = con.prepareStatement(query);
		
		mySQLStatement.setInt(1, companyID);
		ResultSet result = mySQLStatement.executeQuery();
		
		while (result.next()) {
			int companyId = result.getInt(1);
			String companyName = result.getString(2);
			String email = result.getString(3);
			String password = result.getString(4);
			
		 company = new Company(companyId, companyName, email, password);
			
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return company;

}
}
