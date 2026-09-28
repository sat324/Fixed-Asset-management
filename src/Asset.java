public class Asset {

    private String assetId;
    private String assetName;
    private String category;
    private String purchaseDate;
    private double purchaseCost;
    private double depreciationRate;
    private String department;
    private String location;
    private String status;

    public Asset() {
    }

    public Asset(String assetId, String assetName, String category,
                 String purchaseDate, double purchaseCost,
                 double depreciationRate, String department,
                 String location, String status) {

        this.assetId = assetId;
        this.assetName = assetName;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchaseCost = purchaseCost;
        this.depreciationRate = depreciationRate;
        this.department = department;
        this.location = location;
        this.status = status;
    }

    public String getAssetId() {
        return assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getCategory() {
        return category;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public double getDepreciationRate() {
        return depreciationRate;
    }

    public String getDepartment() {
        return department;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Asset ID: " + assetId +
               ", Name: " + assetName +
               ", Category: " + category +
               ", Purchase Date: " + purchaseDate +
               ", Cost: " + purchaseCost +
               ", Depreciation Rate: " + depreciationRate +
               ", Department: " + department +
               ", Location: " + location +
               ", Status: " + status;
    }
}