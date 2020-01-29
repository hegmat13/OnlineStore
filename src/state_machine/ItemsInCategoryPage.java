package state_machine;
	import java.util.Scanner;
	import online_store_group_project.*;
	import java.util.ArrayList;
	import java.util.Collections;

	public class ItemsInCategoryPage extends Page{
	    ArrayList<Item> items = new ArrayList<Item>(); 
		private String Category; 
	    private int Identifier = 5; 
	    boolean ItemExists = false; 
	    private Item item = null; 
		
		public void nextPage(PageState pageState) {	
	        
			while(true) {
			Category = pageState.getCategory(); 
			
			System.out.println("All Items within the " + Category + " section:");
			Scanner reader = new Scanner(System.in); 
	        items = pageState.getStore().getItemsInCategory(Category); 
	        pageState.getStore().PrintItems(items);
	        
	        System.out.println("");
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
	        System.out.println(input + " does not exist in the " + Category + " Section. Please choose another Item.");	
	    	}
			}
	        }
			}
		}
	    	

		
		public int getIdentifier() {
			return Identifier; 
		}
		
		
		
}
