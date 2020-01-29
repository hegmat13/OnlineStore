package state_machine;

import java.util.ArrayList;
import java.util.Scanner;
import online_store_group_project.*;
import data_storage.*;

public class ViewOrdersPage extends Page {

	ArrayList<Order> orders = new ArrayList<Order>();
	boolean OrderExists = false; 
    private Order order = null;
	private int Identifier = 21;   
	private ArrayList<Integer> numOptions = new ArrayList<Integer>();
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
    
	while(true) {
	System.out.println("Here are your completed orders. Type the number next to the order date to view details of the order, or type 'back' to go back");
	Owner user = (Owner) pageState.getUser();
	orders = user.getReceivedOrders();
	for(int i = 0; i < user.getReceivedOrders().size(); i++) {
		System.out.println(StoreDataIO.dateFormat.format(user.getReceivedOrders().get(i).getTimestamp()) + "(" + i + ")");
		numOptions.add(i);
	}
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
		Integer inp = null;
		inp.parseInt(input);
		Order order = null;
    	
    	for(int j = 0; j < numOptions.size(); j++) {
    		if (inp == numOptions.get(j)) {
    			order = user.getReceivedOrders().get(j);
    			pageState.setOrder(order);
    			pageState.setPage(new OrderInfoPage());
    			return;
    		}
    	}
    	System.out.println("Please enter a number that corresponds to an order.");
	}
	  
	}
 }
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
}
