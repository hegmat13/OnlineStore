package GUI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TabButton extends JPanel{
	
	private int index;
	
	public TabButton(String text, int i) {
		super();
		this.index = i;
		CoolLabel tabLabel = new CoolLabel(text, Color.WHITE, 14);
		add(tabLabel);
		
	}
	
	public int getIndex() {
		return index;
	}
}
