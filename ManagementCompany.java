/**
 * 
 * @author sebas
 *
 */
public class ManagementCompany {
	// fields
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MAX_WIDTH = 10, count = 0;
	private int MAX_DEPTH = 10;
	private Plot plot;
	
	public double getMgmFeePer() {
		return mgmFeePer;
	}

	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Property[] getProperties() {
		return properties;
	}

	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	// managementCompany part (Constructor)
	public ManagementCompany() {
		properties = new Property[MAX_PROPERTY];
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
	}
/**
 * 
 * @param name
 * @param taxID
 * @param mgmFeePer
 */
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
	}
/**
 * 
 * @param name
 * @param taxID
 * @param mgmFeePer
 * @param x
 * @param y
 * @param width
 * @param depth
 */
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(x, y, MAX_WIDTH, MAX_DEPTH);
	}
/**
 * 
 * @param otherCompany
 */
	public ManagementCompany(ManagementCompany otherCompany) {
		properties = new Property[MAX_PROPERTY];
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = otherCompany.plot;
	}

//method Part
	/**
	 * 
	 * @return MAX_PORPERTY size of the array
	 */
	public int getMax_PROPERTY() {
		return MAX_PROPERTY;

	}
/**
 * 
 * @param property
 * @return
 */
	public int addProperty(Property property) {
		int i;
		for (i = 0; i < count; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot()))
			{
				return -4;
			}
		}
		if (property != null) {
			properties[count] = property;
			count++;
			return count;
		}
		else if (count == MAX_PROPERTY) {
			return -1;
		}
		else if (property == null){
			return -2;
		}
		else if (this.plot.encompasses(property.getPlot())) {
			return -3;
		}
		else{
			properties[count] = property;
			count++;
			return count;
			}

	}
/**
 * 
 * @param name
 * @param city
 * @param rent
 * @param owner
 * @return
 */
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner, 0, 0, 1, 1);
		properties[count] = property;
		count++;
		for (int i = 0; i < count; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		if (count == MAX_PROPERTY) {
			return -1;
		}
		if (this.plot.encompasses(property.getPlot())) {
			return -3;
		} else {
			properties[count] = property;
			count++;
			return count;
		}
	}
/**
 * 
 * @param name
 * @param city
 * @param rent
 * @param owner
 * @param x
 * @param y
 * @param width
 * @param depth
 * @return
 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		properties[count] = property;
		Plot plot = new Plot(x, y, width, depth);
		for (int i = 0; i < count; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		if (count == MAX_PROPERTY) {
			return -1;
		} else if (this.plot.encompasses(property.getPlot())) {
			return -3;
		} else {
			properties[count] = property;
			count++;
			return count;
		}
	}
/**
 * 
 * @return
 */
	public double totalRent() {
		double totalRent = 0.0;
		for (int i = 0; i < count; i++) {
			
				totalRent += properties[i].getRentAmount();
		}
		return totalRent;
	}

	public double maxRentProp() {
		double maxRentAmount = 0.0;
		maxRentAmount = properties[maxPropertyRentIndex()].getRentAmount();
		return maxRentAmount;
	}

	public int maxPropertyRentIndex() {
		int indexOfMaxRent = 0;

		for (int i = 0; i < count; i++) {
			if (properties[i] != null) {
				if (properties[indexOfMaxRent].getRentAmount() < properties[i].getRentAmount()) {
					indexOfMaxRent = i;
				}
			}

		}
		return indexOfMaxRent;
	}

	public String displayPropertyAtIndex(int i) {
		String str = "";
		if (properties[i] != null) {
			str = ("Owner: " + properties[i].getOwner() + " City: " + properties[i].getCity() + "Property Name: "
					+ properties[i].getPropertyName() + "Rent Amount: " + properties[i].getRentAmount() + "Plot: "
					+ properties[i].getPlot());
		}
		return str;
	}

	public String toString() {
		String print = "";
		System.out.println("List of the properties for Alliance, taxID: " + taxID);
		System.out.println("____________________________________________________");
		for (int i = 0; i < count; i++)
		{
			if (properties[i] != null)
			{
				print = ("Porperty Name: " + properties[i].getPropertyName() + "\n" + "Localed in: "
						+ properties[i].getCity() + "\n" + "Belonging to: " + properties[i].getOwner() + "\n"
						+ "Rent Amount: " + properties[i].getRentAmount());
			 	
			}
		}
		System.out.println("____________________________________________________");
		System.out.println("Total management Fee: " + mgmFeePer);
		return print;
	}
}