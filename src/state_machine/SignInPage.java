package state_machine;

import java.util.Scanner;
import online_store_group_project.*;

public class SignInPage extends Page{


	private int Identifier = 14;   
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	String input;
    
	while(true) {
		
	System.out.println("Please enter username or type 'new' to create an account.");
	input = reader.nextLine();
	
	
	if (input.equals("new")) {
	pageState.setPage(new CreateAccountPage());	
	return;
	}
	
	else {
		boolean isUser = pageState.getStore().userExistsCheck(input);
		if(isUser) {
			for (int i = 0; i < pageState.getStore().users.size(); i++) {
				if(pageState.getStore().users.get(i).getUsername().equals(input)) {
					if(pageState.getStore().users.get(i).getIsCustomer()) {
						User user = new Customer();
						user = pageState.getStore().users.get(i);
						pageState.setUser(user);
					}
					else {
						User user = new Owner();
						user = pageState.getStore().users.get(i);
						pageState.setUser(user);
					}
				}
			}
		pageState.setPreviousPage(this);
		pageState.setPage(new EnterPasswordPage());
		return;
		}
		else {
			System.out.println("/nUsername not recognized. Hit enter to continue.");
			input = reader.nextLine();
		}
	  }
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
	
	
	

}