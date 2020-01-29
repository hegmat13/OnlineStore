package online_store_group_project;

import java.util.ArrayList;


public class Owner extends User {
	
	private ArrayList<Item> items;
	private ArrayList<Rating> ratings;
	private ArrayList<Order> receivedOrders;
	protected boolean isCustomer; 
	
	public Owner() {
		isCustomer = false;
	}
	
	public Owner(Store store, String username, String emailAddress, String firstName, String lastName, String password) {
		super(store, username, emailAddress, firstName, lastName, password);
		this.items = new ArrayList<Item>();
		this.ratings = new ArrayList<Rating>();
		this.receivedOrders = new ArrayList<Order>();
		isCustomer = false;
	}
	
	public Owner(Store store, String id, String username, String emailAddress, String firstName, String lastName, String password) {
		super(id, store, username, emailAddress, firstName, lastName, password);
		this.items = new ArrayList<Item>();
		this.ratings = new ArrayList<Rating>();
		this.receivedOrders = new ArrayList<Order>();
		isCustomer = false;
	}


	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		
		if(store.items.contains(item)) {
			System.out.println("Item already exists. Not added to store");
			return;
		}
		if(store.itemNameTaken(item.getId())) {
			System.out.println("Item name taken, not added to the store");
			return;
		}
		store.items.add(item);
		this.items.add(item);
	}
	
	public void removeItem(Item item) {
		this.items.remove(item);
		store.items.remove(item);
	}

	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	public ArrayList<Order> getReceivedOrders() {
		return receivedOrders;
	}

	public void setReceivedOrders(ArrayList<Order> receivedOrders) {
		this.receivedOrders = receivedOrders;
	}
	
	public void addReceivedOrder(Order o) {
		this.receivedOrders.add(o);
	}
	
	public String toCsvString() {
		return String.format("Owner#%s#%s#%s#%s#%s#%s", id, username, firstName, lastName, emailAddress, password);
	}
	
	public String toDisplayString() {
		String ownerString = new String()
		.concat("------Owner------\n")
		.concat("username: " + username + "\n")
		.concat("Email: " + emailAddress + "\n")
		.concat("Items: ");
		for(Item i : items) {
			ownerString = ownerString.concat(i.getName() + "|");
		}
		return ownerString;
	}
    
	
}
