package DBDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import DAO.CouponsDAO;
import connection.ConnectionPool;

public class CouponsDBDAO implements CouponsDAO {

	private ConnectionPool cp = new ConnectionPool();

	@Override
	public void addCoupon(Coupon coupon) {
		Connection coon = cp.getConnection();
		try {

			String query = "INSERT INTO COUPONS(company_Id,CATEGORY_ID,TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) VALUES( ?, ?,?,?,?,?,?,?,?);";
			PreparedStatement mySQLStatement = coon.prepareStatement(query);

			mySQLStatement.setInt(1, coupon.getCompanyId());
			mySQLStatement.setInt(2, 4);
			mySQLStatement.setString(3, coupon.getTitle());
			mySQLStatement.setString(4, coupon.getDescription());
			mySQLStatement.setDate(5, (Date) coupon.getStartDate());
			mySQLStatement.setDate(6, (Date) coupon.getEndDate());
			mySQLStatement.setInt(7, coupon.getAmount());
			mySQLStatement.setDouble(8, coupon.getPrice());
			mySQLStatement.setString(9, coupon.getImage());
			mySQLStatement.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void updateCoupon(Coupon coupon) {
		Connection con = cp.getConnection();
		try {

			String query = "UPDATE COUPONS SET COMPANY_ID = ?, CATEGORY = ?, TITLE = ?,DESCRIPTION=?,START_DATE=?,END_DATE=?,AMOUNT=?,PRICE=?,IMAGE=? WHERE ID = ?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, coupon.getCompanyId());
			mySQLStatement.setString(2, coupon.getCategory() + "");
			mySQLStatement.setString(3, coupon.getTitle());
			mySQLStatement.setString(4, coupon.getDescription());
			mySQLStatement.setDate(5, (Date) coupon.getStartDate());
			mySQLStatement.setDate(6, (Date)coupon.getEndDate());
			mySQLStatement.setInt(7, coupon.getAmount());
			mySQLStatement.setDouble(8, coupon.getPrice());
			mySQLStatement.setString(9, coupon.getImage());
			mySQLStatement.setInt(10, coupon.getId());
			mySQLStatement.executeQuery();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void deleteCoupon(int couponID) {
		Connection con = cp.getConnection();

		try {
			String query = "DELETE FROM coupons WHERE ID = ?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, couponID);
			mySQLStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Coupon> getAllCoupons() {
		Connection con = cp.getConnection();
		ArrayList<Coupon> coupons = new ArrayList<>();

		try {

			String query = "SELECT * FROM coupons ;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			ResultSet result = mySQLStatement.executeQuery();
			while (result.next()) {

				int couponId = result.getInt(1);
				int companyId = result.getInt(2);
				int categoryID = result.getInt(3);
				Category category =Category.valueOf(getCategoryName(categoryID));
				String title = result.getString(4);
				String description = result.getString(5);
				Date startDate = result.getDate(6);
				Date d=new Date(2023, 12, 12);
				//Date endDate = result.getDate(7);
				Date endDate =d;
				int amount = result.getInt(8);
				double price = result.getDouble(9);
				String image = result.getString(10);

				coupons.add(new Coupon(couponId, companyId, category, title, description, startDate, endDate, amount,
						price, image));
			}
		} catch (Exception ex) {
			return null;
		}
		return coupons;
	}

	@Override
	public Coupon getOneCoupon(int couponID) {
		Connection con = cp.getConnection();
		Coupon coupon = null;

		try {

			String query = "SELECT * FROM coupons where id = ?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, couponID);
			ResultSet result = mySQLStatement.executeQuery();
			while (result.next()) {

				int companyId = result.getInt(2);
				int categoryID = result.getInt(3);
				String categoryName = getCategoryName(categoryID);
				Category category = Category.valueOf(categoryName);

				String title = result.getString(4);
				String description = result.getString(5);
				Date startDate = result.getDate(6);
				Date endDate = result.getDate(7);
				int amount = result.getInt(8);
				double price = result.getDouble(9);
				String image = result.getString(10);

				coupon = new Coupon(couponID, companyId, category, title, description, startDate, endDate, amount,
						price, image);
			}
		} catch (Exception ex) {
			return null;
		}
		return coupon;
	}

	public String getCategoryName(int categoryID) {
		Connection con = cp.getConnection();
		String name = null;
		try {

			String query = "SELECT * FROM categories WHERE ID=?;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, categoryID);

			ResultSet result = mySQLStatement.executeQuery();
			while (result.next()) {

				name = result.getString(2);
				;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return name;
	}

	@Override
	public void addCouponPurchase(int customerID, int couponID) {
		Connection con = cp.getConnection();
		try {

			String query = "INSERT INTO CUSTOMERS_VS_COUPONS (CUSTOMER_ID,COUPON_ID ) VALUES(?,?);";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, customerID);
			mySQLStatement.setInt(2, couponID);
			mySQLStatement.executeQuery();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void deleteCouponPurchase(int customerID, int couponID) {
		Connection con = cp.getConnection();
		try {

			String query = "DELETE FROM CUSTOMERS_VS_COUPONS WHERE CUSTOMER_ID=? ,COUPON_ID = ?  ;";
			PreparedStatement mySQLStatement = con.prepareStatement(query);
			mySQLStatement.setInt(1, customerID);
			mySQLStatement.setInt(2, couponID);
			mySQLStatement.executeQuery();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
