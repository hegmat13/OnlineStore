package state_machine;

import java.util.Scanner;
import online_store_group_project.*;
import java.util.ArrayList;

public class SearchPage extends Page {
    
	private int Identifier = 4;   
	
	public void nextPage(PageState pageState) {
		Scanner reader = new Scanner(System.in);
		ArrayList<Item> itemMatches = new ArrayList<Item>(); 
	    
		while(true) {
	    System.out.println("Search Entire Store by Item Name:");
		String input = reader.nextLine();
		itemMatches = pageState.getStore().searchItems(input); 
		
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
			
				if(itemMatches.size() == 0) {
		        System.out.println("No Items with the search " + input + " were found. Please Search Again:");	
				}
				else {
   			    pageState.setItems(itemMatches);	  
			   
		        pageState.setPreviousPage(this);
		    	pageState.setPage(new ItemsInSearchPage());
		    	return; 
				}
		  }
		}
	   }
	 }
		
		
		
		public int getIdentifier() {
			return Identifier; 
		}
}
