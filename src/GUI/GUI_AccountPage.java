package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data_storage.StoreDataIO;
import online_store_group_project.Customer;
import online_store_group_project.Item;
import online_store_group_project.Order;
import online_store_group_project.Owner;

public class GUI_AccountPage extends JPanel {
	
	public GUI_AccountPage(GUI_skeleton driver) {
		super();
		Dimension dim = new Dimension(driver.getWidth(), 900);
		setBackground(new Color(40, 40, 40));
		this.setPreferredSize(dim);
		this.setSize(dim);
		if(driver.activeUser.getIsCustomer()) {
			JPanel ordersPanel = new JPanel();
			ordersPanel.setPreferredSize(new Dimension(driver.getWidth(), 660));
			Customer activeCustomer = (Customer)driver.activeUser;
			JPanel headerPanel = new JPanel();
			CoolLabel headerLabel = new CoolLabel("ORDERS");
			headerPanel.setOpaque(false);
			headerPanel.add(headerLabel);
			
			JPanel ordersList = new JPanel();
			ordersList.setOpaque(false);
			ordersList.setSize(new Dimension(driver.getWidth(), 660));
			ordersList.setPreferredSize(new Dimension(driver.getWidth(), 660));
			headerPanel.setPreferredSize(new Dimension(driver.getWidth(), 30));
			headerPanel.setSize(new Dimension(driver.getWidth(), 30));
			for(Order o: activeCustomer.getOrders()) {
				BuyerOrderItem orderItem = new BuyerOrderItem(o, driver.getWidth());
				ordersList.add(orderItem);
			}
			
			ordersPanel.add(headerPanel);
			ordersPanel.add(ordersList);
			ordersPanel.setOpaque(false);
			add(ordersPanel);
		}
		else {
			JPanel ordersPanel = new JPanel();
			ordersPanel.setPreferredSize(new Dimension(driver.getWidth(), 660));
			Owner activeCustomer = (Owner)driver.activeUser;
			JPanel headerPanel = new JPanel();
			CoolLabel headerLabel = new CoolLabel("ORDERS");
			headerPanel.setOpaque(false);
			headerPanel.add(headerLabel);
			
			JPanel ordersList = new JPanel();
			ordersList.setOpaque(false);
			ordersList.setSize(new Dimension(driver.getWidth(), 660));
			ordersList.setPreferredSize(new Dimension(driver.getWidth(), 660));
			headerPanel.setPreferredSize(new Dimension(driver.getWidth(), 30));
			headerPanel.setSize(new Dimension(driver.getWidth(), 30));
			for(Order o: activeCustomer.getReceivedOrders()) {
				SellerOrderItem orderItem = new SellerOrderItem(o, driver.getWidth());
				ordersList.add(orderItem);
			}
			
			ordersPanel.add(headerPanel);
			ordersPanel.add(ordersList);
			ordersPanel.setOpaque(false);
			add(ordersPanel);
		}
	}
	
	private class BuyerOrderItem extends JPanel{
		public BuyerOrderItem(Order order, int width) {
			super();
			Dimension dim = new Dimension(1080, 100);
			setOpaque(false);
			CoolLabel orderSummary;
			CoolLabel orderTotal = new CoolLabel(String.format("Total: $%.2f", order.getTotal()));
			CoolLabel orderDate = new CoolLabel(StoreDataIO.dateFormat.format(order.getTimestamp()));
			CoolLabel sellerInfo = new CoolLabel(String.format("Seller: %s", order.getSeller().getUsername()));
			setSize(dim);
			setPreferredSize(dim);
			
			ItemImage itemImage = new ItemImage(order.getItems().get(0), 100);
			
			JPanel itemInfoDiv = new JPanel();
			itemInfoDiv.setOpaque(false);
			itemInfoDiv.setLayout(new GridLayout(3,0));
			itemInfoDiv.setPreferredSize(new Dimension(930, 100));
			itemInfoDiv.setBorder(new EmptyBorder(10, 10, 10, 10));
			if(order.getItems().size() > 2) {
				orderSummary = new CoolLabel(String.format("%s and %s more items", order.getItems().get(0).getName(), order.getItems().size() - 1));
			}
			else if(order.getItems().size() > 1) {
				orderSummary = new CoolLabel(String.format("%s and 1 more item", order.getItems().get(0).getName()));
			}
			else {
				orderSummary = new CoolLabel(order.getItems().get(0).getName());
			}
			
			
			itemInfoDiv.add(orderSummary);
			itemInfoDiv.add(orderTotal);
			itemInfoDiv.add(orderDate);
			itemInfoDiv.add(sellerInfo);
			
			add(itemImage);
			add(itemInfoDiv);
		}
	}
	
	private class SellerOrderItem extends JPanel{
		public SellerOrderItem(Order order, int width) {
			super();
			Dimension dim = new Dimension(1080, 100);
			setOpaque(false);
			CoolLabel orderSummary;
			CoolLabel orderTotal = new CoolLabel(String.format("Total: $%.2f", order.getTotal()));
			CoolLabel orderDate = new CoolLabel(StoreDataIO.dateFormat.format(order.getTimestamp()));
			CoolLabel sellerInfo = new CoolLabel(String.format("Buyer: %s", order.getBuyer().getUsername()));
			setSize(dim);
			setPreferredSize(dim);
			
			ItemImage itemImage = new ItemImage(order.getItems().get(0), 100);
			
			JPanel itemInfoDiv = new JPanel();
			itemInfoDiv.setOpaque(false);
			itemInfoDiv.setLayout(new GridLayout(3,0));
			itemInfoDiv.setPreferredSize(new Dimension(930, 100));
			itemInfoDiv.setBorder(new EmptyBorder(10, 10, 10, 10));
			if(order.getItems().size() > 2) {
				orderSummary = new CoolLabel(String.format("%s and %s more items", order.getItems().get(0).getName(), order.getItems().size() - 1), Color.BLACK);
			}
			else if(order.getItems().size() > 1) {
				orderSummary = new CoolLabel(String.format("%s and 1 more item", order.getItems().get(0).getName()), Color.BLACK);
			}
			else {
				orderSummary = new CoolLabel(order.getItems().get(0).getName());
			}
			
			
			itemInfoDiv.add(orderSummary);
			itemInfoDiv.add(orderTotal);
			itemInfoDiv.add(orderDate);
			itemInfoDiv.add(sellerInfo);
			
			add(itemImage);
			add(itemInfoDiv);
		}
	}
}
