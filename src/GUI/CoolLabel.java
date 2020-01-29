package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class CoolLabel extends JLabel {
	 
	public CoolLabel(String text) {
		super(text);
		setForeground(Color.WHITE);
		setFont(new Font("Lucida Sans", Font.BOLD, 18));
	}
	
	public CoolLabel(String text, Color color, int fontSize) {
		super(text);
		setForeground(color);
		setFont(new Font("Lucida Sans", Font.BOLD, fontSize));
	}
	
	public CoolLabel(String text, Color color) {
		super(text);
		setForeground(color);
		setFont(new Font("Lucida Sans", Font.BOLD, 18));
	}
	
	public CoolLabel(String text, Color color, Color background, int width, int height) {
		super(text);
		Dimension dim = new Dimension(width, height);
		setBorder(new EmptyBorder(5,5,5,5));
		setSize(dim);
		setPreferredSize(dim);
		
		setBackground(background);
		setForeground(color);
		setOpaque(true);
	}
}
