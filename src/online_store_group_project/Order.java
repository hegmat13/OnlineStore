package online_store_group_project;

import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;

public class Order {

	private Store store;
	private String id;
	private Owner seller;
	private Customer buyer;
	private ArrayList<Item> items;
	private Date timestamp;
	private boolean shipped;

	public Order() {
		id = UUID.randomUUID().toString();
		this.items = new ArrayList<Item>();
		this.timestamp = null;
		this.shipped = false;
	}
	
	public Order(Store s) {
		this.store = s;
		id = UUID.randomUUID().toString();
		this.items = new ArrayList<Item>();
		this.timestamp = null;
		this.shipped = false;
	}
	
	public Order(String id, ArrayList<Item> items, Date date, boolean shipped) {
		this.id = id;
		this.items = items;
		this.timestamp = date;
		this.shipped = shipped;
	}
	
	//USED FOR LOADING DATA INTO ORDER FROM FILE
	public Order(Store store, String id, Customer buyer, Owner seller, ArrayList<Item> items, Date timestamp, boolean shipped) {
		this.store = store;
		this.seller = seller;
		this.buyer = buyer;
		this.id = id;
		this.items = items;
		this.timestamp = timestamp;
		this.shipped = shipped;
	}
	
	public Order(Store store, Owner seller, Customer buyer) {
		this.store = store;
		this.buyer = buyer;
		this.seller = seller;
		store.orders.add(this);
		this.id = UUID.randomUUID().toString();
		this.items = new ArrayList<Item>();
		this.timestamp = new Date();
		this.shipped = false;
	}
	
	public double getTotal() {
		double total = 0;
		for(Item item: items) {
			total += item.getPrice()*item.getQuantity();
		}
		return total;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void setSeller(Owner o) {
		this.seller = o;
	}
	
	public Owner getSeller() {
		return this.seller;
	}
	
	public void setBuyer(Customer c) {
		this.buyer = c;
	}
	
	public Customer getBuyer() {
		return this.buyer;
	}


	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public ArrayList<Item> getItems(){
		return this.items;
	}
	
	public Date getTimestamp() {
		return this.timestamp;
	}
	
	public void setTimestamp(Date date) {
		this.timestamp = date;
	}
	
	public void ship() {
		this.shipped = true;
		//remove item from Owners list of items!
	}
	
	public boolean getShippedStatus() {
		return this.shipped;
	}
	
}
