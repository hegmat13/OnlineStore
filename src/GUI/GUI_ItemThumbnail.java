package GUI;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import online_store_group_project.Item;

public class GUI_ItemThumbnail extends JPanel{
	
	public static final int ITEM_THUMBNAIL_WIDTH = 200;
	public static final int ITEM_THUMBNAIL_HEIGHT = 230;
	
	private Item item;
	private GUI_skeleton driver;
	
	public GUI_ItemThumbnail(GUI_skeleton driver, Item item) {
		// TODO Auto-generated constructor stub
		super();
		this.setSize(ITEM_THUMBNAIL_WIDTH, ITEM_THUMBNAIL_HEIGHT);
		this.setPreferredSize(new Dimension(ITEM_THUMBNAIL_WIDTH, ITEM_THUMBNAIL_HEIGHT));
		//this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setLayout(new BorderLayout());
		
		this.item = item;
		this.driver = driver;
		if(item.getName().trim().equals("White T-shirt")){
			System.out.println("test");
		}
		
		ItemImage imagePanel = new ItemImage(item, ITEM_THUMBNAIL_WIDTH);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(1, 0));
		infoPanel.setPreferredSize(new Dimension(ITEM_THUMBNAIL_WIDTH, ITEM_THUMBNAIL_HEIGHT - ITEM_THUMBNAIL_WIDTH));
		
		String displayedName = item.getName();
		if(displayedName.length() > 14) {
			displayedName = displayedName.substring(0, 11);
			displayedName = displayedName.concat("...");
		}
		JLabel nameLabel = new JLabel(displayedName);
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.WHITE);
		namePanel.setSize(new Dimension(ITEM_THUMBNAIL_WIDTH*3/4, ITEM_THUMBNAIL_HEIGHT - ITEM_THUMBNAIL_WIDTH));
		
		JLabel priceLabel = new JLabel(String.format("$%.2f", item.getPrice()));
		JPanel pricePanel = new JPanel();
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		pricePanel.setBackground(new Color(0, 150, 20));
		
		pricePanel.add(priceLabel);
		namePanel.add(nameLabel);
		
		infoPanel.add(namePanel);
		infoPanel.add(pricePanel);
		
		this.add(imagePanel);
		this.add(infoPanel, BorderLayout.SOUTH);
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				handleClick();
			}
		});
				
		this.setVisible(true);
	}
	
	private void handleClick() {
		driver.switchPage(new ItemGUI(this.item, driver.activeUser));
	}
	
	
	public Item getItem() {
		return item;
	}
}