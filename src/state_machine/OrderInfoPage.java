package state_machine;

import java.util.Scanner;
import online_store_group_project.*;
import data_storage.*;

public class OrderInfoPage extends Page {

	private int Identifier = 19;   
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
    
	while(true) {
	System.out.println("Here are you order details.\n");
	System.out.println("Order ID: " + pageState.getOrder().getID() + "\n");
	System.out.println("Date: " + StoreDataIO.dateFormat.format(pageState.getOrder().getTimestamp()) + "\n");
	for (int i = 0; i < pageState.getOrder().getItems().size(); i++) {
		System.out.println("Item: " + pageState.getOrder().getItems().get(i).getName() + " - $" + pageState.getOrder().getItems().get(i).getPrice() + "\n");
	}
	System.out.println("Enter 'back' to go back or 'home' to go home.");
	String input = reader.nextLine();
	
	
	if (input.equals("home")) {
	pageState.setPage(new OwnerHomePage());	
	return;
	}
	
	else {
		if (input.equals("back")) {
		pageState.setPage(pageState.getPreviouspage());	
		return;
		}
		
		else { 
			System.out.println("Please enter a valid command");
		} 
	  }
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
	
	
	
	
}

