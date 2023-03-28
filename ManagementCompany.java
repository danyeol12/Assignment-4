package property;

public class ManagementCompany {
    private String name;
    private String taxId;
    private double managementFee;
    private final int MAX_PROPERTY = 5;
    private Property[] properties = new Property[MAX_PROPERTY];
    private final int MGMT_WIDTH = 10;
    private final int MGMT_DEPTH = 10;
    private Plot plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    private int propertyCount = 0;

    
    public int getMAX_PROPERTY() {
    	return MAX_PROPERTY;
    }
    
    public Plot getPlot() {
    	return plot;
    }
    
    public String getName() {
    	return name;
    }
    
    public ManagementCompany(String name, String taxId, double managementFee) {
        this.name = name;
        this.taxId = taxId;
        this.managementFee = managementFee;
        properties = new Property[MAX_PROPERTY];
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxId, double managementFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxId = taxId;
        this.managementFee = managementFee;
        properties = new Property[MAX_PROPERTY];
        plot = new Plot(x, y, width, depth);
    }

    public int addProperty(Property property) {
        if (propertyCount >= MAX_PROPERTY) {
            return -1;
        }

        if (property == null) {
            return -2;
        }

        Plot propPlot = property.getPlot(); 
        if (propPlot == null || !plot.encompasses(propPlot)) {
            return -3;
        }

        for (int i = 0; i < propertyCount; i++) {
            if (properties[i].getPlot() != null && properties[i].getPlot().overlaps(propPlot)) {
                return -4;
            }
        }

        properties[propertyCount] = new Property(property);
        return propertyCount++;
    }

    public int addProperty(String propertyName, String city, double rent, String ownerName) {
        Property property = new Property(propertyName, city, rent, ownerName);
        return addProperty(property);
    }

    public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
        Property property = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
        return addProperty(property);
    }

    public double totalRent() {
        double totalRent = 0;
        for (int i = 0; i < propertyCount; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    private int maxRentPropertyIndex() {
        int maxIndex = 0;
        for (int i = 1; i < propertyCount; i++) {
            if (properties[i].getRentAmount() > properties[maxIndex].getRentAmount()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public double maxRentProp() {
        return properties[maxRentPropertyIndex()].getRentAmount();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("List of the properties for ").append(name).append(", taxID: ").append(taxId).append("\n");
        result.append("______________________________________________________\n");

        for (int i = 0; i < propertyCount; i++) {
            result.append(properties[i].toString()).append("\n");
        }

        result.append("______________________________________________________\n");
        result.append("total management Fee: ").append(managementFee * totalRent() / 100);
        return result.toString();
    }

}
