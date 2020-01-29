package state_machine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import data_storage.StoreDataIO;
import online_store_group_project.Item;
import online_store_group_project.Order;

public class OrderConfirmationPage extends Page {

	private int Identifier = 12;   
	
	
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
	
    
	while(true) {
	System.out.println("Enter anything to Confirm your order:");
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
				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss"); 
				Date dateobj = new Date(); 
				StoreDataIO.dateFormat.format(dateobj); 
				String id = UUID.randomUUID().toString();
				boolean shipped = false; 
				Item test = null; 
				
				Order newOrder = new Order(id, pageState.getCart(), dateobj, shipped); 
		        pageState.getStore().orders.add(newOrder); 
		        
		        pageState.getStore().completeTransactions(pageState.getCart(), newOrder, pageState);
		        
                pageState.getStore().removeItems(pageState.getCart()); 
                
                test = pageState.getStore().getItemGivenName("White T-shirt");
                System.out.println(test.getQuantity());
                		
		        
		        
		        
		        System.out.println("Your order " + id + " was confirmed!");
		        System.out.println("");
		        System.out.println("Details of your purchase:");
		        System.out.println("Date: " + StoreDataIO.dateFormat.format(dateobj));
		        pageState.getStore().PrintCart(pageState.getCart()); 
		        System.out.println("Total cost: $" + pageState.getCost());
			    
		        pageState.getCart().clear(); 
		        
		        System.out.println("Hit Enter To Continue.");
		        String input2 = reader.nextLine(); 
			
		        pageState.setPreviousPage(this);
		    	pageState.setPage(new HomePage());
		    	return; 
		} 
	  }
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
	
	
}
