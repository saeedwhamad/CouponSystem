package services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import Repositories.CouponRepository;
import beans.Coupon;

public class CouponServicesImpl implements CouponServices {
	@Autowired
	CouponRepository couponRepo;

	@Override
	public void addCoupon(Coupon coupon) {
		couponRepo.save(coupon);

	}

	@Override
	public void updateCoupon(Coupon coupon) {
		couponRepo.save(coupon);
	}

	@Override
	public void deleteCoupon(int couponID) {
		couponRepo.deleteById(couponID);
	}

	@Override
	public ArrayList<Coupon> getAllCoupons() {
		return (ArrayList<Coupon>) couponRepo.findAll();
	}

	@Override
	public Coupon getOneCoupon(int couponID) {
		return couponRepo.getById(couponID);
	}

	@Override
	public void addCouponPurchase(int customerID, int couponID) {
	

	}

	@Override
	public void deleteCouponPurchase(int customerID, int couponID) {
		

	}

}
