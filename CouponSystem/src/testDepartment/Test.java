package testDepartment;

import DailyJob.CouponExperationDailyJob;
import Facades.ClientFacade;
import Facades.adminFacade;
import Facades.customerFacade;
import departmentFacade.LoginManger;

public class Test {
	
	public void testAll() {
		CouponExperationDailyJob dailyJob=new CouponExperationDailyJob();
		dailyJob.run();
		
		LoginManger loginManger;
		
		loginManger=LoginManger.getInstance();
		
		adminFacade admin=new adminFacade();
		customerFacade customer =new customerFacade();
		ClientFacade client=new ClientFacade();
		
		admin.addCompany(null);
		admin.addCustomer(null);
		admin.deleteComoany(0);
		
		
	}

}
