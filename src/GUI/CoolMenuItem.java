package GUI;

import javax.swing.JMenuItem;

public class CoolMenuItem extends JMenuItem{
	int i;
	public CoolMenuItem(String text, int in) {
		super(text);
		i = in;
	}
	
	public int getI() {
		return i;
	}
}
