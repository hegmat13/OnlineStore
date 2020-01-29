package drivers;

import GUI.GUI_ItemThumbnail;
import GUI.GUI_skeleton;
import GUI.ItemGUI;
import online_store_group_project.Item;
import online_store_group_project.Owner;
import online_store_group_project.Store;

public class ItemGUIDriver {
	public static void main(String[] args)
	{
		Store store = new Store();
		Owner owner = new Owner();
		Item item1 = new Item(store, owner); 
		item1.setQuantity(5);
		item1.setName("Bagel");
		item1.setPrice(1.0);
		item1.setDescription("It's a friggin bagel. What more description do ya need?");
		GUI_ItemThumbnail itemTN = new GUI_ItemThumbnail(new GUI_skeleton(store), item1);
		ItemGUI testGUI = new ItemGUI(item1);
	}
}
