package online_store_group_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import online_store_group_project.*;
import state_machine.*;

public class Store {
 
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	public ArrayList<Owner> owners = new ArrayList<Owner>(); 
	public ArrayList<Item> items = new ArrayList<Item>();
	public ArrayList<Order> orders = new ArrayList<Order>(); 
	public ArrayList<User> users = new ArrayList<User>();
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	private String url;
	PaymentOptions p1;
	
	
	//Setters and Getters 
	public ArrayList<Customer> getCustomers(){
		return customers;
	}
	
	public ArrayList<Owner> getOwners(){
		return owners;
	}
	
	public ArrayList<User> getUsers(ArrayList<Customer> Customers, ArrayList<Owner> Owners){
		users.addAll(Customers);
		users.addAll(Owners);
		return users;
	}
	
	public Item getItemGivenName(String name) { 
		for(int i = 0; i < items.size(); i++) {
		  if(name.equals(items.get(i).getName())) {
			  return items.get(i); 
		  }
		}
		return null; 
	}
	
	
	
	//GET ITEMS IN GIVEN CATEGORY
	public ArrayList<Item> getItemsInCategory(String categoryName) {
		ArrayList<Item> categoryItems = new ArrayList<Item>();
		 for(Item item : this.items) {
			 if(item.getCategory().equals(categoryName)) {
				 categoryItems.add(item);
			 }
		 }
		 return categoryItems; 
	}

	
	//Alphabetical Sort Function 
	/*
	Collections.sort(users, new Comparator<User>() {
	    public int compare(User user1, User user2) {
	        return user1.getFirstName().compareTo(user2.getFirstName());
	    }
	});  */ 
	
	
    //All getter functions to display the items in the store//

	//Get All the Categories contained in the store 
	public ArrayList<String> getCategories(){
		ArrayList<String> categoryNames = new ArrayList<String>();
		for(Item i : this.items) {
			if(!categoryNames.contains(i.getCategory())) {
				categoryNames.add(i.getCategory());
			}
		}
		
		return categoryNames;
	}
	
	//Get all the items contained in the store 
	public ArrayList<Item> getAllItems(){
		return this.items;
	}
	
	//Get all the featured items contained in the store 
	//this is dope
	public ArrayList<Item> getFeaturedItems() { //get 8 random items to display
		ArrayList<Item> featuredItems = getAllItems();
		if(featuredItems.size() < 6) {
			return featuredItems;
		}
		else {
			Collections.shuffle(featuredItems);
			return new ArrayList<Item>(featuredItems.subList(0, 6));
		}
	}
		
	//Verification Methods// 
	
	//Make sure username and emailaddress are valid 
	public boolean userExists(String emailAddress) {
		int i = 0;
		while(i < this.users.size()) {
			if (this.users.get(i).getEmailAddress().equals(emailAddress)) {
				System.out.println("Email Address is already in use. Please use a different email address.");
				return true;
			}
			else if(this.users.get(i).getUsername().equals(emailAddress)) {
				System.out.println("Username is already in use. Please use a different username.");
				return true;
			}
			i++;
		}
		return false;
	}
	
	public boolean userExistsCheck(String emailAddress) {
		int i = 0;
		while(i < this.users.size()) {
			if (this.users.get(i).getEmailAddress().equals(emailAddress)) {
				return true;
			}
			else if(this.users.get(i).getUsername().equals(emailAddress)) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	public User getUserByUsername(String username) {
		for(User u: this.users) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}
	
	//Make sure item name is valid 
	public boolean itemNameTaken(String itemName) {
		 for(Item i : this.items) {
		     if(i.getName() == itemName) {
		     System.out.println("Item Name is already in use. Please chose a different name.");  
		     return true; 
		  }
		}
		return false;
	}
	
	
	// SEARCHING/BROWSING ITEMS
	
	
	//SEARCH ALL ITEMS
	public ArrayList<Item> searchItems(String itemName){
		ArrayList<Item> searchResults = new ArrayList<Item>();
		for(Item item : this.items) {
			if(item.getName().toLowerCase().contains(itemName.toLowerCase())) {
				searchResults.add(item);
			}
		}
		return searchResults;
	}
	

	
	//GET ITEMS IN GIVEN CATEGORY WITH SEARCH TERM
	
	
	public boolean SearchCategories(String Category) {
		ArrayList<String> Categories = this.getCategories(); 
		
		for(int i = 0; i < Categories.size(); i++) {
			if(Category.equals(Categories.get(i))) {
				return true; 
			}
		}
		
		return false; 
	}
	
	
	public ArrayList<Item> SearchItemsInCategory(String categoryName, String itemName) {
		
		//get category items
		ArrayList<Item> searchResults = getItemsInCategory(categoryName);
		 for(Item categoryItem : searchResults) {
			 //if item not included in search, remove from items
			 if(!categoryItem.getName().contains(itemName)) {
				 searchResults.remove(categoryItem);
			 }
		 }
		 return searchResults; 
	}
	
	//Complete Transactions 
	public void completeTransactions(ArrayList<Item> cart, Order order, PageState ps) {
		for(int i = 0; i < cart.size(); i++) {
			User u1 = cart.get(i).getSeller();
			User u2 = cart.get(i).getSeller();
			
			//modify from user and payment option 
	    	Transaction newtransaction = new Transaction(this, ps.getCost(), order.getTimestamp(), u1, u2, p1);
	    	
	    	this.transactions.add(newtransaction); 
	    }
		
		System.out.println("Transactions Completed Successfully.");
		
	}
	
	//Item Exists within ArrayList 
	public boolean ItemExists(ArrayList<Item> Items, String itemName) {
		for(int i = 0; i < Items.size(); i++) {
			if (itemName.equals(Items.get(i).getName())) {
				return true; 
			}
		}
		return false; 
	}
	
	//*Print Categories*//
	
	public void PrintCategories() {
		ArrayList<String> Categories = new ArrayList<String>(); 
		String newCategory; 
		boolean exists = false; 
		Categories = this.getCategories();
        
		for(int i = 0; i < Categories.size(); i++) {
		System.out.println(Categories.get(i)); 
		}
	}
	
	//Print All items in a specific Category
	public void PrintItems(ArrayList<Item> items) {
	    for(int i = 0; i < items.size(); i++) {
	    	System.out.println(items.get(i).getName()); 
	    }
	}
	
	//Print Item Details 
	
	public void PrintItemDetails(Item i1) {
		System.out.println("");
		System.out.println(i1.getName() + ":"); 
		System.out.println("");
		System.out.println("Price: $" + i1.getPrice()); 
		System.out.println("Quantity: " + i1.getQuantity());
		System.out.println("Category: " + i1.getCategory());
		System.out.println("Item Description: " + i1.getDescription());
		System.out.println("Seller: " + i1.getSeller().getFirstName() + i1.getSeller().getLastName());
		System.out.println("");
	}
	
	//Print Cart Details
	
	public double PrintCart(ArrayList<Item> items) {
		double totalcost = 0.0;  
		
		for(int i = 0; i < items.size(); i++) {
	     System.out.println("Items and Prices:");
	     System.out.println(items.get(i).getName() + "  qty: " + items.get(i).getQuantityPurchased() + "  seller:  " +  items.get(i).getSeller().getFirstName() + items.get(i).getSeller().getLastName() + "  price:  $" + items.get(i).getPrice()); 
	     totalcost = totalcost + items.get(i).getPrice()*items.get(i).getQuantityPurchased(); 
		 }

		 return totalcost; 
	} 
	
	//Other Getters 
	
	public Customer getCustomerById(String id) {
		for(Customer c : this.customers) {
			if(c.getId().equals(id)) return c;
		}
		return null;
	}
	
	public Owner getOwnerById(String id) {
		for(Owner o : this.owners) {
			if(o.getId().equals(id)) return o;
		}
		return null;
	}
	
	//Get user by id
	public User getUserById(String id) {
		User user = getCustomerById(id);
		if(user != null) {
			user = getOwnerById(id);
		}
		return user;
	}
	
	public void removeItems(ArrayList<Item> cart) {
		
		for(int i = 0; i < cart.size(); i++) {
         decreaseQuantity(cart.get(i)); 
		}
	}
	
	public void decreaseQuantity(Item i1) {
		int newq = 0; 
		
		
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getName().equals(i1.getName())) {
		     newq = (items.get(i).getQuantity() - items.get(i).getQuantityPurchased()); 
		     if (newq == 0) {
		    	 items.remove(items.get(i)); 
		     }
		     
		     else {
		    	 items.get(i).setQuantity(newq);
		    	 }
			}
		}
	}
}
