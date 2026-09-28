import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssetDAO {

    // Add new asset
    public void addAsset(Asset asset) {

        String sql = "INSERT INTO assets " +
                "(asset_id, asset_name, category, purchase_date, purchase_cost, " +
                "depreciation_rate, department, location, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, asset.getAssetId());
            ps.setString(2, asset.getAssetName());
            ps.setString(3, asset.getCategory());
            ps.setString(4, asset.getPurchaseDate());
            ps.setDouble(5, asset.getPurchaseCost());
            ps.setDouble(6, asset.getDepreciationRate());
            ps.setString(7, asset.getDepartment());
            ps.setString(8, asset.getLocation());
            ps.setString(9, asset.getStatus());

            ps.executeUpdate();

            System.out.println("Asset added successfully!");

        } catch (Exception e) {
            System.out.println("Error while adding asset!");
            e.printStackTrace();
        }
    }

    // Display all assets
    public List<Asset> getAllAssets() {

        List<Asset> assets = new ArrayList<>();

        String sql = "SELECT * FROM assets";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Asset asset = new Asset(
                    rs.getString("asset_id"),
                    rs.getString("asset_name"),
                    rs.getString("category"),
                    rs.getString("purchase_date"),
                    rs.getDouble("purchase_cost"),
                    rs.getDouble("depreciation_rate"),
                    rs.getString("department"),
                    rs.getString("location"),
                    rs.getString("status")
                );

                assets.add(asset);
            }

        } catch (Exception e) {
            System.out.println("Error while fetching assets!");
            e.printStackTrace();
        }

        return assets;
    }

    // Delete asset
    public void deleteAsset(String assetId) {

        String sql = "DELETE FROM assets WHERE asset_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, assetId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Asset deleted successfully!");
            } else {
                System.out.println("Asset not found!");
            }

        } catch (Exception e) {
            System.out.println("Error while deleting asset!");
            e.printStackTrace();
        }
    }
}