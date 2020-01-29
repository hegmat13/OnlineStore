package state_machine;

import java.util.Scanner;
import java.util.ArrayList;
import online_store_group_project.*;

public class FeaturedItemsPage extends Page {

	private int Identifier = 3;   
	
	 
	public void nextPage(PageState pageState) {
    ArrayList<Item> items = new ArrayList<Item>();  
	items = pageState.getStore().getFeaturedItems();
	Scanner reader = new Scanner(System.in);
	boolean ItemExists = false; 
	Item item; 
	
	System.out.println("Here are the featured Items:");
	pageState.getStore().PrintItems(items); 
	
	while(true) {
	System.out.println("");
	System.out.println("Chose an Item:"); 
	String input = reader.nextLine();
	
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
        ItemExists = pageState.getStore().ItemExists(items, input); 	
        
    	if(ItemExists) {
    	item = pageState.getStore().getItemGivenName(input); 
    	
    	pageState.setItem(item);
    	pageState.setPreviousPage(this);
    	pageState.setPage(new ItemPage());	
    	return; 
    	}
    	
    	else {
        System.out.println(input + " is not one of the featured items.");	
    	}
		} 
	  }
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
}
