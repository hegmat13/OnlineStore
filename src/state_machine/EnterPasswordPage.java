package state_machine;

import java.util.Scanner;

public class EnterPasswordPage extends Page {

	private int Identifier = 15;   
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
    
	while(true) {
	System.out.println("Please enter password or type 'back' to go back");
	String input = reader.nextLine();
	
	if(input.equals("back")) {
		pageState.setPage(pageState.getPreviouspage());	
		return; 
	}
	else if (input.equals(pageState.getUser().getPassword())) {
		if(pageState.getUser().getIsCustomer()) {
			pageState.setPage(new HomePage());
			return;
		}
		else {
			pageState.setPage(new OwnerHomePage());
			return;
		}
	}
	
	else {
		 System.out.println("Incorrect Password. Hit enter to continue");
		 input = reader.nextLine();
	}
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}

}
