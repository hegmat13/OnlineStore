package online_store_group_project;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Customer extends User {
	
	private String shippingAddress;
	private ArrayList<Order> orders;
	private ArrayList<Item> cart;
	
	//I added this default constructor
	public Customer() {
		super();
		this.orders = new ArrayList<Order>();
		this.cart = new ArrayList<Item>();
		isCustomer = true;
	}
	
	public Customer(Store store, String username, String emailAddress, String firstName, String lastName, String password) {
		super(store, username, emailAddress, firstName, lastName, password);
		this.orders = new ArrayList<Order>();
		this.cart = new ArrayList<Item>();
		isCustomer = true;
	}
	
	public Customer(Store store, String id, String username, String emailAddress, String firstName, String lastName, String password) {
		super(id, store, username, emailAddress, firstName, lastName, password);
		this.orders = new ArrayList<Order>();
		this.cart = new ArrayList<Item>();
		isCustomer = true;
	}
	
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public String getShippingAddress() {
		return this.shippingAddress;
	}
	
	public int getNumberOfOrders() {
		return this.orders.size();
	}
	
	public void setOrders(ArrayList<Order> newOrders) {
		this.orders = newOrders;
		return;
	}
	
	public ArrayList<Order> getOrders(){
		return this.orders;
	}
	
	public void addOrder(Order order) {
		store.orders.add(order);
		order.getSeller().addReceivedOrder(order);
		orders.add(order);
	}
	
	public void removeOrder(Order order) {
		orders.remove(order);
	}
	
	public void addToCart(Item item) {
		cart.add(item);
		JOptionPane.showMessageDialog(null, "Item added to cart");
	}
	
	public void removeFromCart(Item item) {
		cart.remove(item);
	}
	
	public void emptyCart() {
		this.cart.clear();
	}
	
	public ArrayList<Item> getCart(){
		return cart;
	}
	
	public void viewCart() {
		for (int i = 0; i < cart.size(); i++) {
			System.out.println(cart.get(i).getName() + " :$" + cart.get(i).getPrice() + "\n");
		}
	}
	
	public String toCsvString() {
		return String.format("Customer#%s#%s#%s#%s#%s#%s", id, username, firstName, lastName, emailAddress, password);
	}
	
	public String toDisplayString() {
		String customerString = new String()
		.concat("------Customer------\n")
		.concat("username: " + username + "\n")
		.concat("Email: " + emailAddress + "\n")
		.concat("Orders: ");
		for(Order o : orders) {
			customerString = customerString.concat(o.getID() + "|");
		}
		return customerString;
	}

}
