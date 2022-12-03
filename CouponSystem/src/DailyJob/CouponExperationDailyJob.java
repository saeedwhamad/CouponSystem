package DailyJob;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import Beans.Coupon;
import DAO.CouponsDAO;
import DBDAO.CouponsDBDAO;

public class CouponExperationDailyJob implements Runnable {
	private CouponsDAO couponsDAO;
	private boolean quit = false;

	public CouponExperationDailyJob(CouponsDAO couponsDAO, boolean quit) {

		this.couponsDAO = couponsDAO;
		this.quit = quit;
	}
	
	

	public CouponExperationDailyJob() {
		super();
	}



	@Override
	public void run() {
		while(quit!=true) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
		Date todaysDate = new Date(System.currentTimeMillis());
		ArrayList<Coupon> allCoupons = couponsDAO.getAllCoupons();
		for (Coupon coupon : allCoupons) {
			if (coupon.getEndDate().before(todaysDate)) {
				couponsDAO.deleteCoupon(coupon.getId());
			}
		}
		
	}
	}
	public void stop() {

	}

}
