package state_machine;

import java.util.ArrayList;
import java.util.Scanner;
import online_store_group_project.*;

public class ItemPage extends Page{

	private int Identifier = 6;   
	
	 
	public void nextPage(PageState pageState) {
	
	
	Scanner reader = new Scanner(System.in);
	
	Item item = pageState.getItem(); 
	
	pageState.getStore().PrintItemDetails(item); 
	
	while(true) {
	System.out.println("Do you want to add " + item.getName() + " to your cart? (yes/no):");	
	String input = reader.nextLine();
	int previous = pageState.getPreviouspage().getIdentifier(); 
    
	if (input.equals("home")) {
    	pageState.setPage(new HomePage());	
    	return;
    	}
    	
    	else {
    		if (input.equals("back")) {
    		pageState.setPage(pageState.getPreviouspage());	
    		return;
    		}
    		
    		else {  
	
	if (input.equals("yes")) {
	System.out.println("There are " + item.getQuantity() + " in stock.");
	System.out.println("How many do you want to add?:");	
	while(true) {	
	int input1 = reader.nextInt(); 
	if(input1 <= (item.getQuantity() - item.getQuantityPurchased())) {
		boolean ItemExists = false; 
		
		ItemExists = pageState.getStore().ItemExists(pageState.getCart(), item.getName()); 
		
		if(ItemExists) { 
		pageState.addToCost(item.getPrice()*input1); 
			
		item.addQuantityPurchased(input1); 
		pageState.setPreviousPage(this);
		pageState.setPage(new AddedCartPage());	
		return;
		}
		else {
		pageState.addToCart(item);
		pageState.addToCost(item.getPrice()*input1); 
		 
		item.setQuantityPurchased(input1);
		pageState.setPreviousPage(this);
		pageState.setPage(new AddedCartPage());	
		return; 
		}
	}
	
	else {
	System.out.println("Amount not valid. Please enter a different amount:");		
	}

	 }
	}
	else if (input.equals("no")) {
	if (previous == 1) {
	pageState.setPreviousPage(this);	
	pageState.setPage(pageState.getPreviouspage());	
	return; 
	}
		
	else { 
		pageState.setPreviousPage(this);
	pageState.setPage(pageState.getTwoPagesBack());	
    return; 
	}
	}
	
	else {
	System.out.println("Invaled Enry Try again.");	
	System.out.println("");	
	}
    		}
    	}
	 }
	}

	
	public int getIdentifier() {
		return Identifier; 
	}
	
	
}
