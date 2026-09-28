import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssetCategoryDAO {

    // Display all asset categories
    public List<AssetCategory> getAllCategories() {

        List<AssetCategory> categories = new ArrayList<>();

        String sql = "SELECT * FROM asset_categories";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                AssetCategory category = new AssetCategory(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );

                categories.add(category);
            }

        } catch (Exception e) {
            System.out.println("Error while fetching asset categories!");
            e.printStackTrace();
        }

        return categories;
    }
}