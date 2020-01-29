package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class CoolButton extends JButton {
	public CoolButton(String text) {
		super(text);
		this.setPreferredSize(new Dimension(100, 30));
		this.setSize(new Dimension(100, 30));
		this.setBackground(Color.WHITE);
	}
	
	public CoolButton(String text, int width, int height) {
		super(text);
		Dimension d = new Dimension(width, height);
		this.setSize(d);
		this.setPreferredSize(d);
		this.setBackground(Color.WHITE);
	}
}
