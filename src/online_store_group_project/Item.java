package online_store_group_project;

import java.util.UUID;

public class Item {
	
	private Store store; 
	private String id;
	private String name;
	private String description;
	private String category;
	private double price;
	private int quantity;
	private int quantityPurchased; 
	private Owner seller;
	
	
	//Constructor
	public Item(Store store, Owner seller, String name, String description, String category, double price, int quantity) {
		
		if(!store.itemNameTaken(name)) {
		this.id = UUID.randomUUID().toString();
		this.store = store; 
		this.seller = seller;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		}
		
		else {
	    System.out.println("Item not created");	
		}
	}
	
	public Item(Store store, Owner seller) {
		this.id = UUID.randomUUID().toString();
		this.store = store;
		this.seller = seller;
	}

	//Constructor for creating items with stored data
	public Item( Store store, String id, Owner seller, String name, String description, String category, double price, int quantity) {
		
		//TODO: we should probably check if item name is taken before calling constructor
		this.id = id;
		this.store = store; 
		this.seller = seller;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.quantity = quantity;

	}
	
	public Item(Item item) {
		this.id = item.id;
		this.store = item.store;
		this.seller = item.seller;
		this.name = item.name;
		this.description = item.description;
		this.category = item.category;
		this.price = item.price;
		this.quantity = item.quantity;
	}
	
	
	public String getId() {
		return this.id;
	}
	
	//Getters and Setters 
	public Owner getSeller() {
		return seller;
	}

	public void setSeller(Owner seller) {
		this.seller = seller;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantityPurchased(int qp) {
		quantityPurchased = qp; 
	}
	
	public int getQuantityPurchased() {
		return quantityPurchased; 
	}
	public void updateQuantityPurchased() {
		quantity = quantity - quantityPurchased; 
	}
	
	public void addQuantityPurchased(int qp) {
		quantityPurchased = quantityPurchased + qp; 
	}
	
	public String toCsvString() {
		return String.format("%s#%s#%s#%s#%s#%s#%s", id, seller.getId(), name, description, category, price, quantity);
	}
	
	//Over-riding compare method to sort Items alphabetically by name
//	public int compareTo(Item i1) {
//	
//		return this.getName().compareTo(i1.getName());
//	}	
	
	public static void printItemInfo(Item i) {
		System.out.println(String.format("Name: %s %n Description: %s %n Price %s %n Quantity %s %n", i.getName(), i.getDescription(), i.getPrice(), i.getQuantity()));
	}
	
}
