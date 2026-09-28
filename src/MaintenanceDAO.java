import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAO {

    // Add maintenance record
    public void addMaintenance(Maintenance maintenance) {

        String sql = "INSERT INTO maintenance " +
                "(asset_id, maintenance_date, description, cost) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, maintenance.getAssetId());
            ps.setString(2, maintenance.getMaintenanceDate());
            ps.setString(3, maintenance.getDescription());
            ps.setDouble(4, maintenance.getCost());

            ps.executeUpdate();

            System.out.println("Maintenance record added successfully!");

        } catch (Exception e) {
            System.out.println("Error while adding maintenance!");
            e.printStackTrace();
        }
    }

    // Display all maintenance records
    public List<Maintenance> getAllMaintenance() {

        List<Maintenance> maintenanceList = new ArrayList<>();

        String sql = "SELECT * FROM maintenance";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Maintenance maintenance = new Maintenance(
                        rs.getString("asset_id"),
                        rs.getString("maintenance_date"),
                        rs.getString("description"),
                        rs.getDouble("cost")
                );

                maintenanceList.add(maintenance);
            }

        } catch (Exception e) {
            System.out.println("Error while fetching maintenance!");
            e.printStackTrace();
        }

        return maintenanceList;
    }
}
