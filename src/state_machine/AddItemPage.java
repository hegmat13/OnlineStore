package state_machine;

import online_store_group_project.*;
import java.util.Scanner;

public class AddItemPage extends Page {

	private int Identifier = 20;   
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
    
	while(true) {
	System.out.println("Enter name of item to be created, or type 'back' to go back");
	String input = reader.nextLine();
	
	
	if (input.equals("home")) {
	pageState.setPage(new HomePage());	
	return;
	}
	
	else if (input.equals("back")) {
	pageState.setPage(pageState.getPreviouspage());	
	return;
	}
		
	else { 
	Item item = new Item(pageState.getStore(), (Owner) pageState.getUser());
	item.setName(input);
	System.out.println("Enter description of item to be created, or type 'back' to go back");
	input = reader.nextLine();
		if (input.equals("back")) {
			pageState.setPage(pageState.getPreviouspage());	
			return;
		}
		else {
			item.setDescription(input);
			System.out.println("Enter category of item to be created, or type 'back' to go back");
			input = reader.nextLine();
			
			if (input.equals("back")) {
				pageState.setPage(pageState.getPreviouspage());	
				return;
			}
			
			else {
				item.setCategory(input);
				System.out.println("Enter price of item to be created, or type 'back' to go back");
				input = reader.nextLine();
				
				if (input.equals("back")) {
					pageState.setPage(pageState.getPreviouspage());	
					return;
				}
				
				else {
					Double price = Double.parseDouble(input);
					item.setPrice(price);
					System.out.println("Enter quantity of item to be created, or type 'back' to go back" + price);
					input = reader.nextLine();
					
					if (input.equals("back")) {
						pageState.setPage(pageState.getPreviouspage());	
						return;
					}
					
					else {
						Integer quantity = Integer.parseInt(input);
						item.setQuantity(quantity);
						System.out.println("Item created. Hit enter to continue." + quantity);
						input = reader.nextLine();
						pageState.setPage(new OwnerHomePage());
					}
				}
			}
		}
	} 
	 
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
}
