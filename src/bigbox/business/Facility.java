package bigbox.business;

// All my constructors for facility class
public class Facility {
	private int id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;

	public Facility() {
		id = 0;
		name = "";
		address = "";
		city = "";
		state = "";
		zip = "";
	}

	public Facility(int idIn, String nameIn, String addressIn, String cityIn, String stateIn, String zipIn) {
		this.setId(idIn);
		this.setName(nameIn);
		this.setAddress(addressIn);
		this.setCity(cityIn);
		this.setState(stateIn);
		this.setZip(zipIn);

	}
	// getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public String toString() {
		return "id: " + id + "\n" + "name: " + name + "\n" + "address: " + address + "\n" + "city: " + city + "\n"
				+ "state: " + state + "\n" + "zip:  " + zip + "\n";
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
	