package Facades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Beans.Category;
import Beans.Coupon;
import Beans.Customer;
import connection.ConnectionPool;

public class customerFacade extends ClientFacade {
	int customerID;

	public customerFacade(int customerID) {

		this.customerID = customerID;
	}

	public customerFacade() {
	}

	public void purchaseCoupon(Coupon coupon) {
		couponsDAO.addCouponPurchase(customerID, coupon.getId());
	}

	public ArrayList<Coupon> getCustomerCoupons() {

		ArrayList<Coupon> allCoupons = couponsDAO.getAllCoupons();
		ArrayList<Integer> IDs = null;
		ArrayList<Coupon> customerCoupons = null;
		try {
			ConnectionPool cp = new ConnectionPool();
			Connection con = cp.getConnection();
			String query = "SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID=?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, customerID);

			ResultSet result = mySQLStatement.executeQuery();
			while (result.next()) {
				IDs.add(result.getInt(2));
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		for (Coupon coupon : allCoupons) {
			for (Integer id : IDs) {
				if (coupon.getId() == id) {
					customerCoupons.add(coupon);
				}
			}

		}
		return customerCoupons;

	}

	public ArrayList<Coupon> getCustomerCoupons(Category category) {

		ArrayList<Coupon> allCoupons = couponsDAO.getAllCoupons();

		ArrayList<Coupon> customerCoupons = null;

		for (Coupon coupon : customerCoupons) {
			if (coupon.getCategory() == category) {
				customerCoupons.add(coupon);
			}

		}
		return customerCoupons;

	}
	
	

	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) {

		ArrayList<Coupon> allCoupons = couponsDAO.getAllCoupons();

		ArrayList<Coupon> customerCoupons = null;

		for (Coupon coupon : customerCoupons) {
			if (coupon.getPrice() < maxPrice) {
				customerCoupons.add(coupon);
			}

		}
		return customerCoupons;

	}

	public Customer getCustomerDetails() {
		return customersDAO.getOneCustomer(customerID);
	}
}
