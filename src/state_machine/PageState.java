package state_machine;
import online_store_group_project.*;
import java.util.ArrayList;

public class PageState {
	 private Page CurrentPage; 
	 private ArrayList<Page> PreviousPage = new ArrayList<Page>(); 
	 private String Category; 
	 private String BitcoinAddress; 
	 private String ShippingAddress; 
	 private String cardNumber; 
	 private int paymentOption;
	 
	 private Item item; 
	 private ArrayList<Item> items = new ArrayList<Item>(); 
	 private ArrayList<Item> cart = new ArrayList<Item>(); 
	 private Store s1; 
	 private double total; 
	 private User u1;
	 private Order o1;

	
	 public void PageState(Page StartPage) {
	 CurrentPage = StartPage; 
	 }
	 
     public void setPage(Page currentPage) {
    	this.CurrentPage = currentPage; 
     }
     
     public Page getNextPage() {
    	return CurrentPage; 
     }
     
     public void setPreviousPage(Page previousPage) {
    	 PreviousPage.add(previousPage); 
     }
     
     public Page getPreviouspage() {
    	 Page previousPage = PreviousPage.get(PreviousPage.size() - 1);
    	 PreviousPage.remove(PreviousPage.size() - 1);
    	 return previousPage; 
     }
     
     public Page getTwoPagesBack() {
    	 Page TwoPagesBack = PreviousPage.get(PreviousPage.size() - 2);
    	 PreviousPage.remove(PreviousPage.size() - 1);
    	 PreviousPage.remove(PreviousPage.size() - 1);
    	 return TwoPagesBack; 
     }
     
     public void addToCart(Item item) {
    	 cart.add(item); 
     }
     
     public ArrayList<Item> getCart(){
    	 return cart; 
     }
     
     public void setStore(Store S1) {
    	this.s1 = S1; 
     }
     
     public Store getStore() {
    	return s1; 
     }
     
     public void setCategory(String category) {
    	this.Category = category; 
     }
     
     public String getCategory() {
    	return Category; 
     }
     
     public void setItem(Item aitem) { 
    	this.item = aitem; 
     }
     
     public Item getItem() {
    	 return item; 
     }
     
     public void setItems(ArrayList<Item> someitems) { 
    	this.items = someitems; 
     }
     
     public ArrayList<Item> getItems() {
    	 return items; 
     }
     
     public void addToCost(double acost) {
    	 total = total + acost; 
     }
     
     public double getCost() {
    	 return total; 
     }
     
     public void setBitcoinAddress(String address) {
    	 BitcoinAddress = address; 
     }
     
     public String getBitcoinAddress() {
    	 return BitcoinAddress; 
     }
     
     public void setShippingAddress(String address) {
    	 ShippingAddress = address; 
     }
     
     public String getShippingAddress() {
    	 return ShippingAddress; 
     }
     
     public void setCardNumber(String number) {
    	 cardNumber = number; 
     }
     
     public String getCardNumber() {
    	 return cardNumber; 
     }
     
     public void setPaymentState(int po) {
    	 paymentOption = po; 
     }
     
     public int getPaymentState() {
    	 return paymentOption; 
     }
     
     public void setUser(User user) {
    	 u1 = user;
     }
     public User getUser() {
    	 return u1;
     }
     
     //I now added setter and getter for order field
     public void setOrder(Order order) {
    	 o1 = order;
     }
     public Order getOrder() {
    	 return o1;
     }

}
