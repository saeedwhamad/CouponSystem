package Facades;

import java.util.ArrayList;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;

public class compainyFacade extends ClientFacade {
	int companyID;

	public compainyFacade(int companyID) {

		this.companyID = companyID;
	}

	public compainyFacade() {

	}

	

	public void addCoupon(Coupon coupon) {
		couponsDAO.addCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon) {
		couponsDAO.updateCoupon(coupon);

	}

	public void deleteCoupon(int CouponID) {
		couponsDAO.deleteCoupon(CouponID);
	}

	public ArrayList<Coupon> getCompanyCoupons() {
		ArrayList<Coupon> allCoupons = couponsDAO.getAllCoupons();
		ArrayList<Coupon> companyCoupons = null;

		for (Coupon coupon : allCoupons) {
			if (coupon.getCompanyId() == companyID) {
				companyCoupons.add(coupon);
			}

		}
		return companyCoupons;
	}

	public ArrayList<Coupon> getCompanyCoupons(Category category) {
		ArrayList<Coupon> allCoupons = couponsDAO.getAllCoupons();
		ArrayList<Coupon> companyCoupons = null;

		for (Coupon coupon : allCoupons) {
			if (coupon.getCategory() == category) {
				companyCoupons.add(coupon);
			}

		}
		return companyCoupons;
	}

	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) {
		ArrayList<Coupon> allCoupons = couponsDAO.getAllCoupons();
		ArrayList<Coupon> companyCoupons = null;

		for (Coupon coupon : allCoupons) {
			if (coupon.getPrice() < maxPrice) {

				companyCoupons.add(coupon);
			}

		}
		return companyCoupons;
	}

	public Company getCompanyDetails() {
		return companiesDAO.getOneCompany(companyID);
	}
}
