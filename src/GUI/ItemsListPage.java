package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import online_store_group_project.Customer;
import online_store_group_project.Item;
import online_store_group_project.Store;

public class ItemsListPage extends JPanel{
	private GUI_skeleton pageSkeleton;
	private ArrayList<GUI_ItemThumbnail> items;
	private Customer user;
	
	final int PAGE_WIDTH = 1920;
	
	public ItemsListPage(ArrayList<Item> items, GUI_skeleton driver) {
		pageSkeleton = driver;
		this.items = new ArrayList<GUI_ItemThumbnail>();
		user = (Customer) driver.activeUser;
		Cart cart = new Cart(driver);
		this.setSize(PAGE_WIDTH-40, 900);
		this.setBackground(new Color(40, 40, 40));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(cart);
		this.setVisible(true);
	}
	
	private class Cart extends JPanel{
		public Cart(GUI_skeleton driver) {
			this.setLayout(new GridLayout(0,1));
			
			JPanel header = new JPanel();
			header.setSize(PAGE_WIDTH, 30);
			
			CoolLabel headerLabel = new CoolLabel("Search Results", Color.BLACK);
			header.add(headerLabel);
			
			this.add(header);
			
			ArrayList<Item> cartItems = new ArrayList<Item>();
			for(int i = 0; i < user.getCart().size(); i = i + 1) {
				cartItems.add(user.getCart().get(i));
			}
			
			for(int i = 0; i < cartItems.size(); i++) {
				GUI_ItemThumbnail itemThumb = new GUI_ItemThumbnail(driver, cartItems.get(i));
				this.add(itemThumb);
				
				items.add(itemThumb);
				
				JButton viewButton = new JButton("View Item " + String.valueOf(i));
				viewButton.addActionListener(new itemListener());
				this.add(viewButton);
			}
		}
	}
	
	
	
	
	
	
	
	/*
	GUI_skeleton pageSkeleton;
	ArrayList<GUI_ItemThumbnail> items;
	JPanel mainPanel;
	
	public ItemsListPage(ArrayList<Item> items, GUI_skeleton driver) {
		pageSkeleton = driver;
		this.items = new ArrayList<GUI_ItemThumbnail>();
		for(int i = 0; i < items.size(); i = i + 1) {
			GUI_ItemThumbnail tempTN = new GUI_ItemThumbnail(pageSkeleton, items.get(i));
			this.items.add(tempTN);
		}
		
		buildFrame();
		setVisible(true);	
	}
	
	public void buildFrame() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1));
		mainPanel.setPreferredSize(new Dimension(1040, 250));
		mainPanel.setBackground(new Color(40, 40, 40));
		mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		for(int i = 0; i < items.size(); i = i + 1) {
			
			JButton viewButton = new JButton("View Item " + String.valueOf(i));
			
			viewButton.addActionListener(new itemListener());
			
			scroll.add(items.get(i));
			scroll.add(viewButton);
		}
		mainPanel.add(scroll);
	}
	*/
	private class itemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton tempItem = (JButton)e.getSource();
			String temp2 = tempItem.getText().substring(10, tempItem.getText().length());
			int i = Integer.parseInt(temp2);
			Item item = items.get(i).getItem();
			pageSkeleton.switchPage(new ItemGUI(item, pageSkeleton.activeUser));
		}
		
	}
	
}
