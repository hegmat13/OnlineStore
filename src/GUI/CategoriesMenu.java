package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;

import online_store_group_project.Item;
import online_store_group_project.Store;


public class CategoriesMenu extends JMenu{
	private GUI_skeleton GUISkele;
	private Store store;
	
	public CategoriesMenu(Store store, GUI_skeleton skele) {
		super("Categories");
		this.store = store;
		GUISkele = skele;
		for (int i = 0; i < store.getCategories().size(); i = i + 1) {
			CoolMenuItem tempCategory = new CoolMenuItem(store.getCategories().get(i), i);
			tempCategory.addActionListener(new MenuListener());
			add(tempCategory);
		}
	}
	
	private class MenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			CoolMenuItem source = (CoolMenuItem) e.getSource();
			ArrayList<Item> itemsInCat = new ArrayList<Item>();
			itemsInCat = store.getItemsInCategory(source.getText());
			GUISkele.switchPage(new ItemsListPage(itemsInCat, GUISkele));
		}
	}
}
