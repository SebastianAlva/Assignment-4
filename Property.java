/**
 * 
 * @author sebas
 *
 */
public class Property {

	private String propertyName; // name of property
	private String city; // name of the city
	private double rentAmount; // holds the plot object
	private String owner; // name of house owner
	private Plot plot;
	
	//property part
	public Property()
	{
		propertyName = "";
		city = "";
		rentAmount = 0;
		owner = "";
		this.plot = new Plot(0, 0, 1, 1);
	}
	 
	public Property(Property p) 
	{
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.owner = p.owner;
		this.rentAmount = p.rentAmount;
		this.plot = p.plot;
	}

	public Property(String propertyName, String city, double rentAmount, String owner) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	//setters and getters part 
	public String getCity() {
		return city;
	}

	public String getOwner() {
		return owner;
	}

	public Plot getPlot() {
		return plot;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setPlot(int x, int y, int width, int depth) {
		this.plot = new Plot(x, y, width, depth);
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	
	/**
	 * to String part
	 * print name, city, owner, rent, amount
	 */
	public String toString() {
		String str = "Property Name: " + propertyName + "\n" + "Located in: " + city + "\n" + "Belonging to: " + owner
				+ "\n" + "Rent Amount: " + rentAmount + " ";
		return str;
	}






}