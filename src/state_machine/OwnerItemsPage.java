package state_machine;

import java.util.ArrayList;
import java.util.Scanner;
import online_store_group_project.*;

public class OwnerItemsPage extends Page {
	ArrayList<Item> items = new ArrayList<Item>();
	boolean ItemExists = false; 
    private Item item = null;
	private int Identifier = 17;   
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
    
	while(true) {
	System.out.println("Here are the items you are selling. Type the name of a specific item to view item info");
	Owner user = (Owner) pageState.getUser();
	items = user.getItems();
	pageState.getStore().PrintItems(items);
	String input = reader.nextLine();
	
	
	if (input.equals("home")) {
	pageState.setPage(new OwnerHomePage());	
	return;
	}
	
	else if (input.equals("back")) {
		pageState.setPage(pageState.getPreviouspage());	
		return;
		}
		
	else { 
		ItemExists = pageState.getStore().ItemExists(items, input); 
    	
    	if(ItemExists) {
    	item = pageState.getStore().getItemGivenName(input); 
    	System.out.println(item.getName());
    	pageState.setItem(item);
    	
    	pageState.setPreviousPage(this);
    	pageState.setPage(new OwnerItemPage());	
    	return; 
    	}
    	
    	else {
        System.out.println(input + " is not one of your items. Please choose another Item.");	
    	}
		}
	  
	}
 }
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
}

