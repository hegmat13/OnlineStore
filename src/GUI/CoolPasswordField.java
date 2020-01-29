package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class CoolPasswordField extends JPasswordField {
	
	private String name;
	
	public CoolPasswordField(String name) {
		super();
		Dimension dim = new Dimension(100, 30);
		this.name = name;
		this.setSize(dim);
		this.setPreferredSize(dim);
		this.setBackground(Color.WHITE);
		setForeground(Color.GRAY);
		setBorder(new EmptyBorder(5,5,5,5));
		setFont(new Font("Lucida Sans", Font.PLAIN, 18));
		this.setOpaque(true);
		
		addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				handleFocusLost();
			}
			public void focusGained(FocusEvent e) {
				handleFocusGained();
			}
		});
		
		handleFocusLost();
	}
	
	public CoolPasswordField(String name, Dimension dim) {
		super();
		this.name = name;
		this.setSize(dim);
		this.setPreferredSize(dim);
		this.setBackground(Color.WHITE);
		setForeground(Color.GRAY);
		setBorder(new EmptyBorder(5,5,5,5));
		setFont(new Font("Lucida Sans", Font.PLAIN, 18));
		this.setOpaque(true);
		
		addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				handleFocusLost();
			}
			public void focusGained(FocusEvent e) {
				handleFocusGained();
			}
		});
		
		handleFocusLost();
	}
	
	private void handleFocusLost() {
		if(new String(this.getPassword()).trim().equals("")) {
			this.setText(name);
		}
	}
	
	private void handleFocusGained() {
		if(new String(this.getPassword()).trim().equals(name)) {
			this.setText("");
		}
	}
}
