package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import data_storage.StoreDataIO;
import online_store_group_project.*;

public class GUI_skeleton extends JFrame{
	HomeButton homeButton;
	CoolButton cartButton;
	
	JTextField searchBar;
	JPanel topBar;
	JPanel currentPage;
	public User activeUser;
	public Store store;
	
	public GUI_skeleton(Store store){
		super("Amazeon");
		activeUser = new Customer();
		activeUser.setStore(store);
		this.store = store;
		setSize(1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	saveData();
		    	System.exit(0);
		    }
		});
		
		buildFrame();
		setVisible(true);
	}
	
	private void saveData() {
		StoreDataIO.storeStoreData(this.store);
	}

	public void buildFrame() {
		homeButton = new HomeButton(120, 60);
		AccountButton accountButton = new AccountButton(60, 60);
		
		JPanel searchBarContainer = new JPanel();
		searchBarContainer.setBorder(new EmptyBorder(5, 15, 5, 15));
		searchBarContainer.setPreferredSize(new Dimension(600, 50));
		searchBar = new JTextField("Search");
		searchBar.setBorder(new EmptyBorder(0, 10, 0, 10));
		searchBar.setPreferredSize(new Dimension(600, 30));
		searchBar.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				
			}
			public void focusGained(FocusEvent e) {
				
			}
		});
		
		topBar = new JPanel();
		topBar.setBorder(new EmptyBorder(5, 5, 5, 5));
		topBar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
		
		cartButton = new CoolButton("Cart");
		cartButton.addActionListener(new buttonListener());
		searchBar.addActionListener(new searchBarListener());
		
		topBar.add(homeButton);
		searchBarContainer.add(searchBar);
		topBar.add(searchBarContainer);
		topBar.add(accountButton);
		topBar.add(cartButton);
		topBar.setPreferredSize(new Dimension(1080, 70));
		
		add(topBar, BorderLayout.NORTH);
		
		this.currentPage = new GUI_HomePage(this);
		add(currentPage);
	}
	
	public void goHome() {
		switchPage(new GUI_HomePage(this));
	}
	
	public void goToAccountPage() {
		if(activeUser.getId() == null) {
			switchPage(new GUI_SignInPage(this));
		}
		else {
			switchPage(new GUI_AccountPage(this));
		}
	}
	
	public void logInUser(User user) {
		if(user != null) {
			this.activeUser = user;
		}
	}
	
	public void switchPage(JPanel page) {
		System.out.println("switching page");
		remove(currentPage);
		this.currentPage = page;
		add(currentPage);
		repaint();
		revalidate();
	}
	
	private class HomeButton extends JPanel{
		
		private Image image;
		private int width;
		private int height;
		
		public HomeButton(int width, int height) {
			super();
			this.width = width;
			this.height = height;
			this.setPreferredSize(new Dimension(width, height));
			this.setSize(width, height);
			
			try {
				image = ImageIO.read(new File("images/amazeon.png"));
			}
			catch (IOException ex_2){
				System.out.println("Error reading default home image file.");
			}
			
			this.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					goHome();
				}
			});
		}
		
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Image scaledImage = image.getScaledInstance(this.width,this.height,Image.SCALE_SMOOTH);
	        g.drawImage(scaledImage, 0, 0, this); // see javadoc for more info on the parameters            
	    }
	}
	
	private class AccountButton extends JPanel{
		
		private Image image;
		private int width;
		private int height;
		
		public AccountButton(int width, int height) {
			super();
			this.width = width;
			this.height = height;
			this.setPreferredSize(new Dimension(width, height));
			this.setSize(width, height);
			
			try {
				image = ImageIO.read(new File("images/account.png"));
			}
			catch (IOException ex_2){
				System.out.println("Error reading default account image file.");
			}
			
			this.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					goToAccountPage();
				}
			});
		}
		
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Image scaledImage = image.getScaledInstance(this.width,this.height,Image.SCALE_SMOOTH);
	        g.drawImage(scaledImage, 0, 0, this); // see javadoc for more info on the parameters            
	    }
	}

	private class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());

			if(source.equals(cartButton))
			{
				handleCart();
			}
		
		}
		
		public void handleHome(){
			//new HomePageGUI();
		}
		
	}
	
	public void checkout() {
		if(activeUser.getIsCustomer()) {
			if(((Customer)activeUser).getCart().size() > 0) {
				Order o = new Order();
				o.setBuyer((Customer)activeUser);
				o.setSeller(((Customer)activeUser).getCart().get(0).getSeller());
				for(Item i : ((Customer)activeUser).getCart()) {
					o.addItem(i);
				}
				o.setTimestamp(new Date());
				((Customer)activeUser).addOrder(o);
				((Customer)activeUser).emptyCart();
				JOptionPane.showMessageDialog(null, "Successfully checked out!");	
			}
			else {
				JOptionPane.showMessageDialog(null, "You have no items in your cart");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "You must be a customer to check out");
			//CANT CHECK OUT AS OWNER
		}
	}
	
	public void handleCart() {
		switchPage(new GUI_Cart(this));
	}
	
	private class searchBarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			ArrayList<Item> itemMatches = new ArrayList<Item>();
			String query = searchBar.getText();
			itemMatches = store.searchItems(query);
			
			if(itemMatches.size() == 0) {
		        JOptionPane.showMessageDialog(null, "No items matching that search.");	
			}
			else {
				switchPage(new ItemGUI(itemMatches.get(0), activeUser));
			}
		}
	}
	

}
