package bigbox.business;

public class Store extends Facility {
	private String storeNbr;
	private String divisionNbr;

	private double sales;

	public Store() {
		super();
		storeNbr = "";
		divisionNbr = "";
		sales = 0;
	}

	public Store(int idIn, String divsionNbrIn, String storeNbrIn, double salesIn, String nameIn, String adressIn,
			String cityIn, String stateIn, String zipIn) {
		super(idIn, nameIn, adressIn, cityIn, stateIn, zipIn);
		this.setStoreNbr(storeNbrIn);
		this.setDivisionNbr(divsionNbrIn);
		this.setSales(salesIn);

	}

	public String getStoreNbr() {
		return storeNbr;
	}

	public void setStoreNbr(String storeNbr) {
		this.storeNbr = storeNbr;
	}

	public String getDivisionNbr() {
		return divisionNbr;
	}

	public void setDivisionNbr(String divisionNbr) {
		this.divisionNbr = divisionNbr;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(Double sales) {
		this.sales = sales;
	}

	public String toString() {
		return ("storeNbr: " + storeNbr + "\n" + "divisionNbr: " + divisionNbr + "\n" + "sales: " + sales + "\n")
				+ super.toString();

	}

}
    	