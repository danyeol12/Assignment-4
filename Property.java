package property;

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    public Property(Property property) {
        if (property == null) {
            return;
        }
        this.propertyName = property.propertyName;
        this.city = property.city;
        this.rentAmount = property.rentAmount;
        this.owner = property.owner;
        if (property.plot != null) {
            this.plot = new Plot(property.plot);
        } else {
            this.plot = null;
        }
    }

	public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Plot getPlot() {
        if (plot == null) {
            return null;
        }
        return new Plot(plot.getX(), plot.getY(), plot.getWidth(), plot.getDepth());
    }

    public void setPlot(Plot plot) {
    	this.plot = plot;
    }

    public String toString() {
        return "Property Name: " + propertyName + "\n"
             + "Located in " + city + "\n"
             + "Belonging to: " + owner + "\n"
             + "Rent Amount: " + rentAmount + "\n";
    }
}