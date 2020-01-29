package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TabSelect extends JPanel {
	
	private int index;
	private Dimension dimension;
	private JPanel selectedTab;
	private ArrayList<TabButton> tabButtons;
	private ArrayList<JPanel> tabs;
	
	public TabSelect(ArrayList<JPanel> tabs) {
		super();
		this.tabs = tabs;
		tabButtons = new ArrayList<TabButton>();
		index = 0;
		dimension = new Dimension(400, 300);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(dimension);
		this.setSize(dimension);
		
		JPanel tabBar = new JPanel();
		tabBar.setPreferredSize(new Dimension(400, 30));
		tabBar.setOpaque(false);
		
		int tabWidth = 400/(tabs.size()+1);
		Dimension tabDimension = new Dimension(tabWidth, 30);
		
		int i = 0;
		for(JPanel tab : tabs){
			TabButton selectorTab = new TabButton(tab.getName(), i);
			selectorTab.setSize(tabDimension);
			selectorTab.setPreferredSize(tabDimension);
			tabButtons.add(selectorTab);
			
			selectorTab.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					selectTab(((TabButton)e.getSource()).getIndex());
				}
			});
			
			tabBar.add(selectorTab);
			i++;
		}
		
		add(tabBar, BorderLayout.NORTH);
		selectTab(0);
	}
	
	public void selectTab(int index) {
		if(selectedTab != null) {
			this.remove(selectedTab);
		}
		
		this.selectedTab = tabs.get(index);
		for(TabButton tabButton: tabButtons) {
			if(tabButton.getIndex() == index) {
				tabButton.setBackground(new Color(239, 157, 0));
			}
			else {
				tabButton.setBackground(Color.GRAY);
			}
			tabButton.repaint();
			tabButton.revalidate();
		}
		selectedTab.setPreferredSize(new Dimension(400, 270));
		System.out.println(selectedTab);
		this.add(selectedTab, BorderLayout.SOUTH);
		
		repaint();
		revalidate();
		return;
	}
}
