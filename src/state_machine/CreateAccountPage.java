package state_machine;

import java.util.Scanner;
import online_store_group_project.*;

public class CreateAccountPage extends Page {

	private int Identifier = 13;   
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
    
	while(true) {
		System.out.println("Please enter username:");
		String input = reader.nextLine();
		
		if(input.equals("")) {
			System.out.println("Username cannot be empty");
		}
		
		else {
			String username = input;
			System.out.println("Please enter email address");
			input = reader.nextLine();
			
			while (input.equals("")) {
				System.out.println("Email cannot be empty. Please enter valid email address.");
				input = reader.nextLine();
			}
			String email = input;
			
			System.out.println("Please enter password");
			input = reader.nextLine();
			
			while (input.equals("")) {
				System.out.println("Password cannot be empty. Please enter valid password.");
				input = reader.nextLine();
			}
			String password = input;
			
			System.out.println("Please enter first name");
			input = reader.nextLine();
			
			while (input.equals("")) {
				System.out.println("Name cannot be empty. Please enter valid name.");
				input = reader.nextLine();
			}
			String firstName = input;
			
			System.out.println("Please enter last name");
			input = reader.nextLine();
			
			while (input.equals("")) {
				System.out.println("Name cannot be empty. Please enter valid name.");
				input = reader.nextLine();
			}
			String lastName = input;
			System.out.println("Will you be a customer or seller? Type 'c' for customer or 's' for seller.");
			input = reader.nextLine();
			while (!input.equals("c") && !input.equals("s")) {
				System.out.println("Please enter either 'c' or 's'.");
				input = reader.nextLine();
			}
			if (input.equals("c")) {
				pageState.setUser(new Customer(pageState.getStore(), username, email, firstName, lastName, password));
			}
			else if (input.equals("s")) {
				pageState.setUser(new Owner(pageState.getStore(), username, email, firstName, lastName, password));
			}
			System.out.println("Congratulations, you are now a user of a super cool store!!! Please hit enter to continue.");
			input = reader.nextLine();
			if (pageState.getUser().getIsCustomer()) {
				pageState.setPage(new HomePage());
				return;
			}
			else {
				pageState.setPage(new OwnerHomePage());
				return;
			}
		}
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
		
}