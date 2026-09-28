public class Maintenance {

    private int maintenanceId;
    private String assetId;
    private String maintenanceDate;
    private String description;
    private double cost;

    public Maintenance() {
    }

    public Maintenance(String assetId, String maintenanceDate,
                       String description, double cost) {

        this.assetId = assetId;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
        this.cost = cost;
    }

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public String getAssetId() {
        return assetId;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Asset ID: " + assetId +
               ", Maintenance Date: " + maintenanceDate +
               ", Description: " + description +
               ", Cost: " + cost;
    }
}