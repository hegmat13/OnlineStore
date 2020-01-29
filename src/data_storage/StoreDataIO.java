package data_storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import online_store_group_project.*;

public class StoreDataIO {
	
	public enum FileErrorCodes{
		Success,
		FileError,
		OutputError,
		UsernameInUseError,
		EmailInUseError
	}
	
	
	public static Store LoadStoreData() {
		Store store = new Store();
		LoadOwners(store);
		LoadCustomers(store);
		LoadItems(store);
		LoadOrders(store);
		LoadTransactions(store);
		store.users.addAll(store.owners);
		store.users.addAll(store.customers);
		
		return store;
	}
	
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	
	public static void LoadOwners(Store store) {
		File usersFile = new File("users.csv");
		ArrayList<Owner> owners = new ArrayList<Owner>();
		String[] csvLines = getLinesFromCsv("users.csv");
		System.out.println("Loading owners...\n");
		
		if(usersFile.exists() && csvLines != null) {
			for(String csvLine : csvLines) {
				//System.out.println(csvLine);
				String parsedUserData[] = csvLine.split("#");
				if(parsedUserData[0].equals("Owner")) {					
					Owner loadedOwner = new Owner(
							store,
							parsedUserData[1], 
							parsedUserData[2], 
							parsedUserData[3],
							parsedUserData[4],
							parsedUserData[5],
							parsedUserData[6]
					);
					
					String itemFilePath = "userData/" + loadedOwner.getUsername() + "/items.csv";
					//TODO: get owner items from item file
					loadedOwner.setItems(getItemsFromItemFile(store, itemFilePath));
					owners.add(loadedOwner);
				}
				
			}
			
		}
		store.owners = owners;
	}
	
	public static void LoadCustomers(Store store){
		File usersFile = new File("users.csv");
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String[] csvLines = getLinesFromCsv("users.csv");
		System.out.println("Loading customers...\n");
		
		if(usersFile.exists() && csvLines!= null) {
			for(String csvLine : csvLines) {
				//System.out.println(csvLine);
				String parsedUserData[] = csvLine.split("#");
				if(parsedUserData[0].equals("Customer")) {
					
					Customer customer = new Customer(
							store,
							parsedUserData[1], 
							parsedUserData[2], 
							parsedUserData[3],
							parsedUserData[4],
							parsedUserData[5],
							parsedUserData[6]
					);		
					customers.add(customer);
				}

			}	
		}
		store.customers = customers;
	}

	
	public static void LoadTransactions(Store store) {
		File transactionsFile = new File("transactions.csv");
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		String[] csvLines = getLinesFromCsv("transactions.csv");
		System.out.println("Loading Transactions...\n");
		
		//IN DATABASE: DATE, AMOUNT, FROMUSERID, TOUSERID, PAYMENTOPTION
		if(transactionsFile.exists() && csvLines!= null) {
			for(String csvLine : csvLines) {
				try {
					String parsedData[] = csvLine.split("#");
					Date date = dateFormat.parse(parsedData[0]);
					double amount = Double.parseDouble(parsedData[1]);
					User fromUser = store.getUserById(parsedData[2]);
					User toUser = store.getUserById(parsedData[3]);
					PaymentOptions paymentOption = PaymentOptions.valueOf(parsedData[4]);
					Transaction transaction = new Transaction(
							store,
							amount,
							date,
							fromUser,
							toUser,
							paymentOption
					);
					transactions.add(transaction);
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("Error parsing transaction data: index out of bounds");
				}
				catch(ParseException e) {
					System.out.println("Error parsing transaction data: parse exception");
				}

			}
		}
		store.transactions = transactions;		
	}
	
	public static void storeStoreData(Store store) {
		storeUsers(store);
		storeItems(store);
		storeOrders(store);
		storeTransactions(store);
	}
	
	public static void storeTransactions(Store store) {
		clearFile("transactions.csv");
		for(Transaction t : store.transactions) {
			writeLineToFile("transactions.csv", t.toCsvString(), true);
		}
	}
	
	public static void storeItems(Store store) {
		clearFile("items.csv");
		for(Item i : store.items) {
			writeLineToFile("items.csv", i.toCsvString(), true);
		}
	}
	
	public static void LoadItems(Store store) {
		store.items = getItemsFromItemFile(store, "items.csv");
	}
	
	public static void LoadOrders(Store store) {
		store.orders = getOrdersFromPath(store, "orders");
	}
	
	public static void storeOrders(Store store) {
		
		File orderFolder = new File("orders");
		if(!orderFolder.exists()) {
			orderFolder.mkdirs();
		}
		else {
			clearOrdersDirectory(orderFolder);
		}
		
		for(Order o : store.orders) {
			String orderFolderPath = "orders/" + o.getID();
			File orderFolderFile = new File(orderFolderPath);
			if(!orderFolderFile.exists()) {
				orderFolderFile.mkdirs();
			}
			
			String orderInfoString = String.format("%s#%s#%s#%s#%s",o.getID(), dateFormat.format(o.getTimestamp()), o.getSeller().getId(), o.getBuyer().getId(), o.getShippedStatus());
			String orderInfoFilePath = orderFolderPath + "/order-info.csv";
			writeLineToFile(orderInfoFilePath, orderInfoString, false);
			
			String orderItemsFilePath = orderFolderPath + "/order-items.csv";
			
			for(Item i: o.getItems()){
				//STRING FORMAT: id, seller id, name, description, category, price, quantity
				writeLineToFile(orderItemsFilePath, i.toCsvString(), true);
			}
		}
	}
	
	public static ArrayList<Order> getOrdersFromPath(Store store, String orderFoldersPath){
		
		//get folders for each order
		String[] orderIds = getSubdirectories(new File(orderFoldersPath));
		ArrayList<Order> orders = new ArrayList<Order>();
		if(orderIds == null) {
			return orders;
		}
				
		//for each order, get order data and item data
		for(String orderId : orderIds) {
			ArrayList<Item> orderItems = new ArrayList<Item>();
			Date orderTimestamp;
			boolean orderShipped;
			Customer orderBuyer;
			Owner orderSeller;

			String orderInfoString = getCsvString(orderFoldersPath + "/" + orderId +  "/order-info.csv");
			
			try {
				String[] orderInfoSplit = orderInfoString.split("#");
				orderTimestamp = dateFormat.parse(orderInfoSplit[1]);
				orderSeller = store.getOwnerById(orderInfoSplit[2]);
				orderBuyer = store.getCustomerById(orderInfoSplit[3]);
				orderShipped = (orderInfoSplit[4] == "true") ? true : false;
				
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("couldnt read order data. order not added");
				continue;
			}
			catch(ParseException e) {
				System.out.println("couldnt parse order date. order not added");
				continue;
			}
			
			//gets items from order-items.csv
			
			String orderItemsPath = orderFoldersPath + "/" + orderId +  "/order-items.csv";
			orderItems = getItemsFromItemFile(store, orderItemsPath);

			Order o = new Order(store, orderId, orderBuyer, orderSeller, orderItems, orderTimestamp, orderShipped);
			orderBuyer.addOrder(o);
			orders.add(o);			
			//System.out.println(folderPath);
		}
		
		return orders;
	}
	
	public static ArrayList<Item> getItemsFromItemFile(Store store, String itemsFilePath){
		ArrayList<Item> items = new ArrayList<Item>();
		System.out.println(itemsFilePath);
		File itemsFile = new File(itemsFilePath);
		if(itemsFile.exists()) {
			String[] itemDataStrings = getLinesFromCsv(itemsFilePath);
			
			//STRING FORMAT: Store store, String id, Owner seller, String name, String description, String category, double price, int quantity
			for(String itemDataString : itemDataStrings) {
				try {
					String[] itemDataSplit = itemDataString.split("#");
					String itemId = itemDataSplit[0];
					Owner itemSeller = store.getOwnerById(itemDataSplit[1]);
					String itemName = itemDataSplit[2];
					String itemDescription = itemDataSplit[3];
					String itemCategory = itemDataSplit[4];
					double itemPrice = Double.parseDouble(itemDataSplit[5]);
					int itemQuantity = Integer.parseInt(itemDataSplit[6]);
					Item addedItem = new Item(store, itemId, itemSeller, itemName, itemDescription, itemCategory, itemPrice, itemQuantity);
					items.add(addedItem);
					itemSeller.addItem(addedItem);
				}
				catch(IndexOutOfBoundsException e) {
					System.out.println("Can't create item from this string: " + itemDataString);
				}
			}
		}
		return items;
	}
	
	public static void storeUsers(Store s) {
		clearFile("users.csv");
		for(Owner owner : s.owners) {
			storeOwner(owner);
		}
		for(Customer customer: s.customers) {
			storeCustomer(customer);
		}
	}
		
	public static void storeOwner(Owner o) {
		writeLineToFile("users.csv", o.toCsvString(), true);
		//storeOwnerItems(o);
	}
	
	public static void storeCustomer(Customer c) {
		writeLineToFile("users.csv", c.toCsvString(), true);
		//storeCustomerOrders(c);
	}
	
	public static File getFile(String filePath) {
		File file = new File(filePath);
		if(!file.exists()) {
			try {
				file.createNewFile();
			}
			catch(IOException e){
				System.out.println("Error creating file.");
			}
		}
		return file;
	}
	
	public static void clearOrdersDirectory(File directory) {
		for(File orderDir : directory.listFiles()) {
			for(File file : orderDir.listFiles()) {
				file.delete();
			}
			orderDir.delete();
		}
	}
	
	public static String getCsvString(String filePath) {
		String csvLine;
		String csvText = new String();
		BufferedReader reader;
		
		//get last version of csv
		try {
			reader = new BufferedReader(new FileReader(filePath));
			csvLine = reader.readLine();
			while(csvLine != null) {
				csvText = csvText.concat(csvLine + "\n");
				csvLine = reader.readLine();
			}
			
			if(csvText.length() != 0) {
				csvText += '\n';
			}
			reader.close();
			//System.out.println(csvLine);
		}
		catch(IOException e) {
			System.out.println("Problems getting lines from csv file");
			return null;
		}
		
		return csvText;
	}
	
	public static String[] getLinesFromCsv(String filePath) {
	
	//get last version of csv
	String csvLine = getCsvString(filePath);
	if(csvLine == null) {
		return null;
	}
	if(csvLine.trim().equals("")){
		return null;
	}
	return csvLine.split("\n");
	//System.out.println(csvLine);
	}
	
	public static String[] getSubdirectories(File folder) {
		String[] directories = folder.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		return directories;
	}
	
	public static void clearFile(String filePath) {
		getFile(filePath);
		
		try(FileWriter fw = new FileWriter(filePath, false);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			} catch (IOException e) {
				
			    System.out.println("Error appending line to file. IOException");
			}
	}
	
	public static void writeLineToFile(String filePath, String line, boolean append) {

	try(FileWriter fw = new FileWriter(filePath, append);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(line);
		} catch (IOException e) {
		    System.out.println("Error appending line to file. IOException");
		}
	}
	
}
