package state_machine;

import java.util.Scanner;
import online_store_group_project.*;
import java.util.ArrayList;
import java.util.Collections;

public class CategoryPage extends Page{
    
    private int Identifier = 2; 
	
	public void nextPage(PageState pageState) {	
		
		Scanner reader = new Scanner(System.in); 
        ArrayList<String> Categories = new ArrayList<String>(); 
        boolean CategoryExists = true;
    	
    	System.out.println("These are all the available Categories:");
    	System.out.println("");
    	Categories = pageState.getStore().getCategories(); 
    	pageState.getStore().PrintCategories(); 
    	
    	System.out.println("");
    	System.out.println("Choose a category:");   
    	
    	while(true) {
    	String input = reader.nextLine(); 
    	CategoryExists = pageState.getStore().SearchCategories(input); 
    	
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
    	if(CategoryExists == true) {
        pageState.setCategory(input);
        
        pageState.setPreviousPage(this);
    	pageState.setPage(new ItemsInCategoryPage());
    	return; 
    	}
    	else if(CategoryExists == false) {
    	System.out.println("Category " + input + " does not exist. Plese Choose a different Category:");
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
