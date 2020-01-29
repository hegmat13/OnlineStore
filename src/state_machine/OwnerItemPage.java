package state_machine;

import java.util.Scanner;
import online_store_group_project.*;

public class OwnerItemPage extends Page {

private int Identifier = 18;   


public void nextPage(PageState pageState) {


Scanner reader = new Scanner(System.in);

Item item = pageState.getItem(); 

pageState.getStore().PrintItemDetails(item); 

while(true) {
System.out.println("Do you want to edit information for " + item.getName() + " ? (yes/no):");	
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

if (input.equals("yes")) {
	boolean validEntry = false;
	while (!validEntry) {
	System.out.println("What would you like to edit (name, description, category, price)?");
	input = reader.nextLine();
	if(input.equals("name")) {
		System.out.println("Enter new item name: ");
		input = reader.nextLine();
		item.setName(input);
		validEntry = true;
	}
	else if(input.equals("description")) {
		System.out.println("Enter new item description: ");
		input = reader.nextLine();
		item.setDescription(input);
		validEntry = true;
	}
	else if(input.equals("category")) {
		System.out.println("Enter new item category: ");
		input = reader.nextLine();
		item.setCategory(input);
		validEntry = true;
	}
	else if(input.equals("price")) {
		System.out.println("Enter new item price: ");
		input = reader.nextLine();
		Double price = null;
		item.setPrice(price.parseDouble(input));
		validEntry = true;
	}
	else {
		System.out.println("Not a valid entry");
	}
	}
}
else if (input.equals("no")) {

pageState.setPage(new OwnerItemsPage());		
return; 
}
else {
System.out.println("Invalid Entry. Try again.");	
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
