package bigbox.presentation;

import java.util.*;

import bigbox.business.Store;
import bigbox.db.DAOFactory;
import bigbox.db.StoreDAO;
import bigbox.db.StoreTextFile;
import bigbox.util.Validator;


public class BigBoxApp {

	private static StoreDAO storeDAO = null;

	public static void main(String args[]) {

		// display a welcome message
		System.out.println("Welcome to the Big Box App \n");
		Scanner sc = new Scanner(System.in);
		storeDAO = DAOFactory.getStoreDAO();

		// perform 1 or more selections

		String choice = "Y";
		while (choice.equalsIgnoreCase("Y")) {
			displayMenu();

			// get the input from the user
			String operation = Validator.getString(sc, "Enter a Command:  ");

			switch (operation.toLowerCase()) {

			case "list":
				displayAllStores();

				break;

			case "div":
				displayAllStoresForDiv();
				break;

			case "add":
				addStore();

				break;

			case "del":
				deleteStore();

				break;

			case "help":

				displayMenu();

				break;

			case "exit":

				exit();

				break;

			case "n":

				break;
			default:
				System.out.println("Error Input only accepts 'list', 'div', 'add', 'del', 'help', 'exit' \n");
				continue;
			}
		}
		sc.close();
	}

	private static void displayAllStores() {
		
		
	    // left this in here to see the differences 	
		// StoreArray sa = new StoreArray();
		// ArrayList<Store> stores = sa.getAllStores();

		ArrayList<Store> stores = storeDAO.getAllStores();
		for (Store s: stores) {
			System.out.println(s.toString());
		}

	}

	public static void addStore() {

		Scanner sc = new Scanner(System.in);
		String divisionnumber = Validator.getDivisionNbr(sc, "Enter The division number for the store: ", 3);

		String storenumber = Validator.getStoreNbr(sc, "Enter The store number for teh store: ", 5);

		double sales = Validator.getDouble(sc, "Enter The sales of the store: ");

		String name = Validator.getString(sc, "Enter the name of the store: ");

		String addresss = Validator.getString(sc, "Enter the address of the store: ");

		String city = Validator.getString(sc, "Enter the city of the store: ");

		String state = Validator.getString(sc, "Enter the state of the store: ");

		String zip = Validator.getStoreZip(sc, "Enter the zip code of the store: ", 5);

		Store store = new Store();

		store.setDivisionNbr(divisionnumber);
		store.setStoreNbr(storenumber);
		store.setSales(sales);
		store.setName(name);
		store.setAddress(addresss);
		store.setCity(city);
		store.setState(state);
		store.setZip(zip);

		storeDAO.addStore(store);
		System.out.println("store was added to the database.\n");
	}

	public static void deleteStore() {

		Scanner sc = new Scanner(System.in);
		String divisionnumber = Validator.getDivisionNbr(sc, "Enter The Division number: ", 3);

		String storenumber = Validator.getStoreNbr(sc, "Enter The Store number: ", 5);

		Store s = storeDAO.getStoreByDivionAndStoreNumber(divisionnumber,storenumber);

		storeDAO.deleteStore(s);
		System.out.println("store was deleteted from the database.\n");

	}

	public static void exit() {

		System.out.println("Bye.\n");
		System.exit(0);

	}

	private static void displayAllStoresForDiv() {

		// perform 1 or more selections
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			String division = Validator.getDivisionNbr(sc, "Please Enter Division Number: ", 3);

			// String store = Validator.getStringNumeric(ss, "Please Enter Store
			// Number: ", 5);
			ArrayList<Store> ss = storeDAO.getAllStoresByDivision(division);

			System.out.println("Store found for division " + division);

			System.out.println(ss);

			// see if the user wants to continue
			choice = Validator.getString(sc, "Continue? (y/n):  ");
			System.out.println();
		}
	}

	private static void displayMenu() {
		System.out.println("\n===COMMAND MENU=== \n" + "list\t\t- List all stores\n"
				+ "div\t\t- List all stores for a division\n" + "add\t\t- Add a store \n" + "del\t\t- Delete a store\n"
				+ "help\t\t- Show this menu\n" + "exit\t\t- Exit the the Application\n\n\n");
	}

}
