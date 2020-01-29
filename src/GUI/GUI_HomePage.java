package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import online_store_group_project.Item;
import online_store_group_project.Store;

public class GUI_HomePage extends JPanel {
	
	final int PAGE_WIDTH = 1920;
	
	public GUI_HomePage(GUI_skeleton driver) {
		// TODO Auto-generated constructor stub		
		FeaturedItems featured = new FeaturedItems(driver);
		this.setSize(PAGE_WIDTH-40, 900);
		this.setBackground(new Color(40, 40, 40));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(featured);
		this.setVisible(true);
	}
	
	private class FeaturedItems extends JPanel {
		
		public FeaturedItems(GUI_skeleton driver) {
			Store store = driver.store;
			this.setSize(PAGE_WIDTH, GUI_ItemThumbnail.ITEM_THUMBNAIL_HEIGHT*2 + 30);
			this.setLayout(new BorderLayout());
			this.setOpaque(false);
			
			JPanel header = new JPanel();
			header.setSize(PAGE_WIDTH, 30);
			
			CoolLabel headerLabel = new CoolLabel("FEATURED ITEMS", Color.BLACK);
			header.add(headerLabel);
			
			JPanel topItemsPanel = new JPanel();
			topItemsPanel.setSize(PAGE_WIDTH, GUI_ItemThumbnail.ITEM_THUMBNAIL_HEIGHT);
			JPanel bottomItemsPanel = new JPanel();
			bottomItemsPanel.setSize(PAGE_WIDTH, GUI_ItemThumbnail.ITEM_THUMBNAIL_HEIGHT);
			
			int itemsPerRow = PAGE_WIDTH / GUI_ItemThumbnail.ITEM_THUMBNAIL_WIDTH;
			int totalItems = itemsPerRow * 2;
			int numStoreItems = store.getAllItems().size();
			
			ArrayList<Item> featuredItems = new ArrayList<Item>();
			while(featuredItems.size() < totalItems) {
				int randIndex = (int)Math.round(Math.random() * (double)(numStoreItems - 1));
				Item randomItem = store.getAllItems().get(randIndex);
				if(!featuredItems.contains(randomItem)) {
					featuredItems.add(randomItem);
				};
			}
			
			for(int i = 0; i < featuredItems.size()/2; i++) {
				GUI_ItemThumbnail itemThumb = new GUI_ItemThumbnail(driver, featuredItems.get(i));
				topItemsPanel.add(itemThumb);
			}
			for(int i = featuredItems.size()/2; i < featuredItems.size(); i++) {
				GUI_ItemThumbnail itemThumb = new GUI_ItemThumbnail(driver, featuredItems.get(i));
				bottomItemsPanel.add(itemThumb);
			}
			
			this.add(header, BorderLayout.NORTH);
			this.add(topItemsPanel);
			this.add(bottomItemsPanel, BorderLayout.SOUTH);
		}
		
		
	}
}
