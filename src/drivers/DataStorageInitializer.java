package drivers;

import online_store_group_project.*;

import java.util.ArrayList;
import java.util.Date;

import data_storage.*;

public class DataStorageInitializer {

	public static void main(String[] args) {
		//Create Store   
		Store s1 = new Store();  
		
	    //Create Customers 
		Customer c1 = new Customer(s1, "joethebro1997", "joe@example.com", "Joe", "Shmo", "joespass");
		Customer c2 = new Customer(s1, "mattthebro1997", "matt@example.com", "Matt", "Marshall", "mattyice");
		Customer c3 = new Customer(s1, "Peterthebro1997", "Peter@example.com", "Peter", "Piper", "PipingInTheName");
		Customer c4 = new Customer(s1, "Jakethebro1997", "Jake@example.com", "Jake", "Snake", "JakeTheSnake");
		Customer c5 = new Customer(s1, "Christhebro1997", "Chris@example.com", "Chris", "Haavisto", "ChrisTwoFor");
		
		
		//Create Owners 
		Owner o1 = new Owner(s1, "RobertSacre", "robert@example.com", "Robert", "Sacre", "SacreTheGod"); 
		Owner o2 = new Owner(s1, "ComputerGuys", "Computers@example.com", "Alexander", "Computer", "CompSciSci"); 
		Owner o3 = new Owner(s1, "SlickApparel", "FancyApparel@example.com", "Bob", "Aparrel", "CoatsShoesAndDudes"); 
		Owner o4 = new Owner(s1, "BeautySuppliers", "beautifulwomen@example.com", "Marie", "Taylor", "Beauty123"); 
		Owner o5 = new Owner(s1, "VideoGameMasters", "VideoJuegos@example.com", "Jimmy", "Carter", "CarterTown"); 
		
		//Create Categories 
		String cg1 = "Other"; 
		String cg2 = "Computers"; 
		String cg3 = "Electronic Accessories"; 
		String cg4 = "Shoes"; 
		String cg5 = "Shirts"; 
		String cg6 = "Beauty"; 
		String cg7 = "Video Games"; 
		
		//Create Items
		Item i1 = new Item(s1, o1, "American Flag" , "Large American Flag" , cg1, 16.00, 1);
		Item i2 = new Item(s1, o2, "HP Spectre" , "It has a solid state drive, sleek and fast!" , cg2, 2000.00, 2);    
		Item i3 = new Item(s1, o2, "Computer Mouse" , "Adjustable HP mouse but does not come with mouse pad" , cg3, 3.00, 8);
		Item i4 = new Item(s1, o3, "2017 Black Jordans" , "Shoes that will make you jump higher!" , cg4, 120.00, 1);
		Item i5 = new Item(s1, o3, "White T-shirt" , "Brand new White Ts" , cg5, 8.00, 7);
		Item i6 = new Item(s1, o4, "Lip Gloss" , "Bright pink lip gloss" , cg6, 20.00, 2);
		Item i7 = new Item(s1, o5, "Madden 2018" , "The newest Football Video Game on the Market!" , cg7, 50.00, 4);
		
		//Add Items to their respective owner
		o1.addItem(i1); 
		o2.addItem(i2); 
		o2.addItem(i3); 
		o3.addItem(i4); 
		o3.addItem(i5); 
		o4.addItem(i6); 
		o5.addItem(i7); 
		
		//Add orders to customers
		Order ord1 = new Order(s1, o1, c1);
		ord1.addItem(i1);
		ord1.addItem(i2);
		ord1.addItem(i3);
		ord1.addItem(i4);
		ord1.addItem(i5);
		
		c1.addOrder(ord1);
		
		
		//Add All Users to the Store 
		s1.owners.add(o1); 
		s1.owners.add(o2);
		s1.owners.add(o3);
		s1.owners.add(o4);
		s1.owners.add(o5);
		s1.customers.add(c1); 
		s1.customers.add(c2);
		s1.customers.add(c3);
		s1.customers.add(c4);
		s1.customers.add(c5);
		
		//Saving users in users.csv
		
		ArrayList<User> usersToSave = new ArrayList<User>();
		usersToSave.add(c1);
		usersToSave.add(c2);
		usersToSave.add(c3);
		usersToSave.add(c4);
		usersToSave.add(c5);
		usersToSave.add(o1);
		usersToSave.add(o2);
		usersToSave.add(o3);
		usersToSave.add(o4);
		usersToSave.add(o5);
		
		System.out.println("Printing users before store:");
		for(User u : s1.customers) {
			System.out.println(u.toDisplayString());
		}
		for(User u : s1.owners) {
			System.out.println(u.toDisplayString());
		}
		
		System.out.println();
		System.out.println("\n\n\n\n\n");
		
		StoreDataIO.storeStoreData(s1);
		
		System.out.println("Printing users after store:");
		for(User u : s1.customers) {
			System.out.println(u.toDisplayString());
		}
		for(User u : s1.owners) {
			System.out.println(u.toDisplayString());
		}
		System.out.println("\n\n\n\n\n");
		
		Store s2 = new Store();
		StoreDataIO.LoadStoreData(s2);
		
		System.out.println("Printing users after loading into another store:");
		for(User u : s2.customers) {
			System.out.println(u.toDisplayString());
		}
		for(User u : s2.owners) {
			System.out.println(u.toDisplayString());
		}
		System.out.println();
		System.out.println("\n\n\n\n\n");
		

	}

}
