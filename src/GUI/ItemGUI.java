package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import online_store_group_project.Customer;
import online_store_group_project.Item;
import online_store_group_project.User;

public class ItemGUI extends JPanel{

	Customer user;
	Item item;
	CoolButton addToCartButton;
	JComboBox quantityBar;
	JPanel rightBar;
	JTextArea description;
	JPanel centerPanel;
	
	public ItemGUI(Item item, User user){
		this.item = item;
		this.user = (Customer)user;
		
		setPreferredSize(new Dimension(1880, 250));
		setBackground(new Color(40, 40, 40));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
		buildFrame();
		setVisible(true);
	}

	public void buildFrame() {
		JPanel photoPanel = new JPanel();
		photoPanel.setPreferredSize(new Dimension(200, 250));
		photoPanel.setOpaque(false);
		
		rightBar = new JPanel();
		rightBar.setLayout(new GridLayout(0, 1));
		rightBar.setOpaque(false);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		centerPanel.setPreferredSize(new Dimension(900, 250));
		
		rightBar.setPreferredSize(new Dimension(200, 50));

		description = new JTextArea();
		description.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		description.setEditable(false);
		description.setOpaque(false);
		description.setText(item.getDescription());
		
		ArrayList<String> options = new ArrayList<String>();
		int i;
		
		for(i = 0; i < item.getQuantity(); i = i + 1) {
			options.add(String.valueOf(i + 1));
		}
		
		String[] CBInput = new String[i];
		CBInput = options.toArray(CBInput);
		
		
		//TODO: need to test this
		JPanel buyBox = new JPanel();
		buyBox.setPreferredSize(new Dimension(200, 100));
		buyBox.setOpaque(false);
		quantityBar = new JComboBox(CBInput);
		
		addToCartButton = new CoolButton("Add to Cart");
		addToCartButton.addActionListener(new buttonListener());
		//This part may be unnecessary// quantityBar.addActionListener(new comboBoxListener());
		
		//topBar.setSize(1080, 1080);
		
		//topBar.setOpaque(true);
		//topBar.setBackground(Color.BLUE);
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(250, 30));
		titlePanel.setOpaque(false);
		CoolLabel titleLabel = new CoolLabel(item.getName().toUpperCase());
		titlePanel.add(titleLabel);
		
		buyBox.add(addToCartButton);
		buyBox.add(quantityBar);
		rightBar.add(buyBox);
		photoPanel.add(titlePanel);
		photoPanel.add(new ItemImage(item, 225));
		centerPanel.add(description);
		
//		add(topBar, BorderLayout.NORTH);
		add(photoPanel);
		add(centerPanel);
		add(rightBar);
	}

	private class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			
			if(source.equals(addToCartButton)) 
			{
				handleAddToCart();
			}
		
		}
		
		public void handleAddToCart() {
			Item tempItem = new Item(item);
			tempItem.setQuantity(Integer.parseInt(quantityBar.getSelectedItem().toString()));
			user.addToCart(tempItem);
			item.setQuantity(item.getQuantity() - Integer.parseInt(quantityBar.getSelectedItem().toString()));
		}
	}
	
//	private class searchBarListener implements ActionListener{
//		public void actionPerformed(ActionEvent e)
//		{
//			ArrayList<Item> itemMatches = new ArrayList<Item>();
//			String query = searchBar.getText();
//			//TODO: this line will use a global store var// itemMatches = store.searchItems(query);
//			
//			if(itemMatches.size() == 0) {
//		        JOptionPane.showMessageDialog(null, "No items matching that search.");	
//			}
//			else {
//				//new ItemsInSearchGUI(store, itemMatches);
//				//TODO: this part needs to use the Item Thumbnails, or perhaps the items-in-search page will do this
//			}
//		}
//	}
	//This part may be unnecessary
	/*private class comboBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}*/
}
