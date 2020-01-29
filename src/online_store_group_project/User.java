package online_store_group_project;

import java.util.UUID;

public abstract class User {

	protected Store store;
	protected String id;
	protected String username;
	protected String emailAddress;
	protected String firstName;
	protected String lastName;
	protected String password;
	protected boolean isCustomer;
	
	public User() {
		
	}
	
	public User(Store store, String username, String emailAddress, String firstName, String lastName, String password) {
		Boolean EmailExists = store.userExists(emailAddress);
		Boolean UserNameExists = store.userExists(username); 
		
		if(!EmailExists && !UserNameExists) {
		this.id = UUID.randomUUID().toString();
		this.store = store;
		this.username = username;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		}
		else {
		System.out.println("User not created");
		}
	}
	
	public User(String id, Store store, String username, String emailAddress, String firstName, String lastName, String password) {
		this.id = id;
		this.store = store;
		this.username = username;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public abstract String toCsvString();
	
	public abstract String toDisplayString();
	
	public String getId() {
		return this.id;
	}
	
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean getIsCustomer() {
		return isCustomer;
	}

}
