package state_machine;

import java.util.Scanner;

public class OwnerHomePage extends Page {

	private int Identifier = 16;   
	
	 
	public void nextPage(PageState pageState) {
	
	System.out.println("Welcome to Matt, Elan, and Payson's Online Store:");
	System.out.println("Whenever you want to return to the previous page type 'back' and for the home page type 'home'");
	System.out.println("");
    
	while(true) {
	System.out.println("Do you want to view your items(1), add a new item(2), or view completed orders(3)?:");	
	Scanner reader1 = new Scanner(System.in);
	int inputInteger = reader1.nextInt(); 
	pageState.setPreviousPage(this);
	
	if(inputInteger == 1) {
	pageState.setPage(new OwnerItemsPage());
	return;
	}
	else if (inputInteger == 2) {
	pageState.setPage(new AddItemPage()); 	
	return;
	}
	
	else if (inputInteger == 3) {
    pageState.setPage(new ViewOrdersPage()); 
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
