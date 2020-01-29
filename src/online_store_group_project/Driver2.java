package online_store_group_project;

import java.util.Scanner;

public class Driver2 {
	public static void main(String[] args) {

		Store OurStore = new Store();
		Scanner inp = new Scanner(System.in);
		String info;
		System.out.println("Enter email address: ");
		info = inp.nextLine();
		boolean taken = OurStore.userExists(info);
		if (!taken) {
			System.out.println("Enter username: ");
			info = inp.nextLine();
			taken = OurStore.userExists(info);
		}
		if (!taken) {
			User u1 = new Customer(); // with all of the other parameters
		}
	}
}
