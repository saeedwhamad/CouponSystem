package departmentFacade;

import Facades.ClientFacade;
import Facades.adminFacade;
import Facades.compainyFacade;
import Facades.customerFacade;

public class LoginManger {
	private static LoginManger loginManger;

	private LoginManger() {

	}

	public static LoginManger getInstance() {
		loginManger = new LoginManger();
		return loginManger;
	}

	public ClientFacade login(String email, String password, Clienttype clienttype) {
		ClientFacade clientFacade=new ClientFacade();
		
		adminFacade admin=new adminFacade();
		
		try {
			if (clientFacade.login(email, password) == true) {
				if (clienttype == Clienttype.Administrator) {
					System.out.println("1");
					return admin;
				} else if (clienttype == Clienttype.Company) {

					clientFacade = new compainyFacade();

				} else if (clienttype == Clienttype.Customer) {
					clientFacade = new customerFacade();
				

				}
				

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return clientFacade;
	}

}
