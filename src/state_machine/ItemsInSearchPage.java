package state_machine;

import java.util.Scanner;
import online_store_group_project.*;
import java.util.ArrayList;

public class ItemsInSearchPage extends Page {

	private int Identifier = 10;   
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	ArrayList<Item> items = new ArrayList<Item>();
	items = pageState.getItems(); 
	boolean ItemExists = false; 
	Item item = null; 
    
	
	System.out.println("All Items resulting from the search:");
	pageState.getStore().PrintItems(items);
	
	System.out.println("");
	
	while(true) {
	System.out.println("Choose an Item:");
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
		System.out.println(input + " does not exist in the search results. Please Try Again.");
		}		
		} 
	  }
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
	
}
