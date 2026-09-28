import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    // Display all departments
    public List<Department> getAllDepartments() {

        List<Department> departments = new ArrayList<>();

        String sql = "SELECT * FROM departments";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Department department = new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name")
                );

                departments.add(department);
            }

        } catch (Exception e) {
            System.out.println("Error while fetching departments!");
            e.printStackTrace();
        }

        return departments;
    }
}