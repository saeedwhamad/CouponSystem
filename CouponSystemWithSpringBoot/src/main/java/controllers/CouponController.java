package controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import beans.Coupon;
import services.CouponServices;

@RestController
@RequestMapping(value = "/coupon")
public class CouponController {

	@Autowired
	CouponServices couponServices;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addCoupon(@RequestBody Coupon coupon) {
		System.out.println(this.getClass().getSimpleName() + "- create new Coupon method invoked");
		couponServices.addCoupon(coupon);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateCoupon(@RequestBody Coupon coupon, @PathVariable int id) {

		System.out.println(this.getClass().getSimpleName() + " - update coupon details by id is invoked");

		couponServices.updateCoupon(coupon);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteCoupon(@PathVariable int couponID) {
		System.out.println(this.getClass().getSimpleName() + " - the delete method bu id is invoked");

		couponServices.deleteCoupon(couponID);

	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ArrayList<Coupon> getAllCoupons() {
		System.out.println(this.getClass().getSimpleName() + " - get all coupons methode is invoked");
		return couponServices.getAllCoupons();
	}

	@RequestMapping(value = "/getonecoupon", method = RequestMethod.GET)
	public Coupon getOneCoupon(@PathVariable int couponID) {
		System.out.println(this.getClass().getSimpleName() + " - get one coupon method is invoked !! ");
		return couponServices.getOneCoupon(couponID);
	}

	public void addCouponPurchase(int customerID, int couponID) {
		// TODO Auto-generated method stub

	}

	public void deleteCouponPurchase(int customerID, int couponID) {
		// TODO Auto-generated method stub

	}

}
