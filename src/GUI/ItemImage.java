package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import online_store_group_project.Item;

public class ItemImage extends JPanel{  
	      
	    
	    private BufferedImage image;
	    private int sideLength;
	    
	    public ItemImage(Item imageItem, int sideLength) {
	    	this.sideLength = sideLength;
	    	this.setPreferredSize(new Dimension(sideLength, sideLength));
	    	this.setSize(sideLength, sideLength);
	    	
	    	String path = "images/items/" + imageItem.getName().replaceAll(" ", "_").toLowerCase() + "/Thumb.jpg";
	    	try {
	    		image = ImageIO.read(new File(path));
	    	}
	    	catch (IOException ex){
	    		try {
	    			image = ImageIO.read(new File("images/items/default.jpg"));
	    		}
	    		catch (IOException ex_2){
	    			System.out.println("Error reading default image file.");
	    		}
	    	}	
		}
	    
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if(image == null) {
	    		try {
	    			image = ImageIO.read(new File("images/items/default.jpg"));
	    		}
	    		catch (IOException ex_2){
	    			System.out.println("Error reading default image file.");
	    		}
	        }
	        Image scaledImage = image.getScaledInstance(sideLength,sideLength,Image.SCALE_SMOOTH);
	        g.drawImage(scaledImage, 0, 0, this); // see javadoc for more info on the parameters            
	    }
	  
} 