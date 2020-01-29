package online_store_group_project;

import java.util.ArrayList;

public class Category implements Comparable<Category> {

	private String Name; 
	private ArrayList<Item> items = new ArrayList<Item>(); 
	
	//Constructor 
	public Category(String name) {
		this.Name = name; 
	}
	
	//Setters and Getters 
	public void setName(String name) {
		this.Name = name; 
	}
	
	public String getName() {
		return Name; 
	}
	
	public ArrayList<Item> getItems(){
		return items; 
	}
	
	//Over-riding compare method to sort Categories alphabetically by name
	public int compareTo(Category cg1) {
	
		return this.getName().compareTo(cg1.getName());
	}	
	
	public void addItem(Item i1) {
		items.add(i1); 
	}
	
}
