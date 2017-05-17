package bigbox.db;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import bigbox.business.Store;

public class StoreTextFile implements StoreDAO {
	// create my instance variables
	private ArrayList<Store> stores = null;
	private Path storesPath = null;
	private File storesFile = null;
	private final String FIELD_SEP = "\t";

	// create my constructors
	public StoreTextFile() {
		// stores = getAllStores();
		storesPath = Paths.get("stores.txt");
		storesFile = storesPath.toFile();
		stores = this.getAllStores();
	}

	@Override
	public Store getStoreByDivionAndStoreNumber(String inDiv, String inStoreNbr) {
		Store store = null;
		for (Store s : stores) {
			if (s.getDivisionNbr().equals(inDiv) && s.getStoreNbr().equals(inStoreNbr)) {
				store = s;
			}
		}
		return store;
	}

	public ArrayList<Store> getAllStores() {
		// if the store already has been read don't read it again
		if (stores != null)

			return stores;

		stores = new ArrayList<>();
		if (Files.exists(storesPath)) 
										// FileNotFoundExeption
		{
			try (BufferedReader in = new BufferedReader(new FileReader(storesFile))) {
				// read all the different stores stored in the array list
				String line = in.readLine();
				while (line != null) {
					String[] columns = line.split(FIELD_SEP);
					String id = columns[0];
					String divisionNbr= columns[1];
					String storeNbr = columns[2];
					String sales = columns[3];
					String name = columns[4];
					String address = columns[5];
					String city = columns[6];
					String state = columns[7];
					String zip = columns[8];

					Store s = new Store(Integer.parseInt(id), divisionNbr, storeNbr, Double.parseDouble(sales), name,
							address, city, state, zip);
					stores.add(s);
					line = in.readLine();
				}
			} catch (IOException e) {
				System.out.println(e);
				return null;

			}
			

		}
		return stores;

	}

	
	
	
	@Override
	public ArrayList<Store> getAllStoresByDivision(String inDiv) {
		ArrayList<Store> storesForDiv = new ArrayList<>();
		for (Store s : stores) {
			if (s.getDivisionNbr().equals(inDiv)) {
				storesForDiv.add(s);
			}
		}
		return storesForDiv;
	}
	
	@Override
	public boolean addStore(Store inStore) {
		 stores.add(inStore);
	        return this.saveStores();
	}

	

    public boolean deleteStore(Store c)
    {
       stores.remove(c);
        return this.saveStores();
    }

    /*
    public boolean updateCustomer(Store newStore)
    {
        // get the old customer and remove it
    	Store oldStore = this.getStore(newStore.getEmail());
        int i = stores.indexOf(oldStore);
        stores.remove(i);

        // add the updated customer
        stores.add(i, newStore);

        return this.saveStores();
    }
    */

    private boolean saveStores()
    {   
        try (PrintWriter out = 	new PrintWriter(
        		     			new BufferedWriter (
        						new FileWriter(storesFile))))
        {
        for (Store c : stores)
    	{
        	out.print(c.getId() + FIELD_SEP);
    		out.print(c.getDivisionNbr() + FIELD_SEP);
    		out.print(c.getStoreNbr() + FIELD_SEP);
    		out.print(c.getSales() + FIELD_SEP);
    		out.print(c.getName() + FIELD_SEP);
    		out.print(c.getAddress() + FIELD_SEP);
        	out.print(c.getCity() + FIELD_SEP);
    		out.print(c.getState() + FIELD_SEP);
    		out.println(c.getZip());
    	}
    	}
       catch (IOException e)
       {
    	   System.out.println(e);
    	   return false;
       }
       // saving the Store objects in the array list to the file

        
        return true;
    }
}
	

	/*private int getNextId() {
		int maxID = 1;
		for (Store s : stores) {
			maxID = Math.max(maxID, s.getId());
		}
		// once max id is determined, add 1 to it for new facID assignment
		return maxID + 1;
	}*/

