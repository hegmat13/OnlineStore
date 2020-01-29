package state_machine;

import java.util.ArrayList;
import java.util.Scanner;

import online_store_group_project.Item;

public class PageSkeleton extends Page{

	private int Identifier = 8;   
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
    
	while(true) {
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
			
		pageState.setPreviousPage(this);	
		//pageState.setPage(new ItemPage());		
		} 
	  }
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
	
	
	
	
}
