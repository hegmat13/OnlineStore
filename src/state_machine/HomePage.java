package state_machine;

import java.util.Scanner;

public class HomePage extends Page {
    
	private int Identifier = 1;   
	
	 
	public void nextPage(PageState pageState) {
		
		
		System.out.println("Welcome to Matt, Elan, and Payson's Online Store:");
		System.out.println("Whenever you want to return to the previous page type 'back' and for the home page type 'home'");
		System.out.println("");
		
		while(true) {
		System.out.println("Do you want to search(1), browse categories(2), or view featured items(3)?:");	
		Scanner reader1 = new Scanner(System.in);
		int inputInteger = reader1.nextInt(); 
		
		if(inputInteger == 1) {
		pageState.setPage(new SearchPage());
		return;
		}
		else if (inputInteger == 2) {
		pageState.setPage(new CategoryPage()); 	
		return;
		}
		
		else if (inputInteger == 3) {
	    pageState.setPage(new FeaturedItemsPage()); 
	    return;
		}
		
		else {
	    System.out.println("Not a Valid Enry. Try Again.");	
		}
		}
	}
	
	public int getIdentifier() {
		return Identifier; 
	}
	
}
