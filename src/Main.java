import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AssetDAO assetDAO = new AssetDAO();
        MaintenanceDAO maintenanceDAO = new MaintenanceDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        AssetCategoryDAO categoryDAO = new AssetCategoryDAO();

        while (true) {

            System.out.println("\n===== FIXED ASSET MANAGEMENT SYSTEM =====");
            System.out.println("1. View All Assets");
            System.out.println("2. Add Asset");
            System.out.println("3. Delete Asset");
            System.out.println("4. View Maintenance Records");
            System.out.println("5. Add Maintenance Record");
            System.out.println("6. View Departments");
            System.out.println("7. View Employees");
            System.out.println("8. View Asset Categories");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n----- ALL ASSETS -----");

                    List<Asset> assets = assetDAO.getAllAssets();

                    for (Asset asset : assets) {
                        System.out.println(asset);
                    }

                    break;

                case 2:

                    System.out.println("\n----- ADD NEW ASSET -----");

                    System.out.print("Enter Asset ID: ");
                    String assetId = sc.nextLine();

                    System.out.print("Enter Asset Name: ");
                    String assetName = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Purchase Date (YYYY-MM-DD): ");
                    String purchaseDate = sc.nextLine();

                    System.out.print("Enter Purchase Cost: ");
                    double purchaseCost = sc.nextDouble();

                    System.out.print("Enter Depreciation Rate: ");
                    double depreciationRate = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Location: ");
                    String location = sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    Asset asset = new Asset(
                            assetId,
                            assetName,
                            category,
                            purchaseDate,
                            purchaseCost,
                            depreciationRate,
                            department,
                            location,
                            status
                    );

                    assetDAO.addAsset(asset);

                    break;

                case 3:

                    System.out.println("\n----- DELETE ASSET -----");

                    System.out.print("Enter Asset ID to delete: ");
                    String deleteId = sc.nextLine();

                    assetDAO.deleteAsset(deleteId);

                    break;

                case 4:

                    System.out.println("\n----- MAINTENANCE RECORDS -----");

                    List<Maintenance> maintenanceList =
                            maintenanceDAO.getAllMaintenance();

                    for (Maintenance maintenance : maintenanceList) {
                        System.out.println(maintenance);
                    }

                    break;

                case 5:

                    System.out.println("\n----- ADD MAINTENANCE RECORD -----");

                    System.out.print("Enter Asset ID: ");
                    String maintenanceAssetId = sc.nextLine();

                    System.out.print("Enter Maintenance Date (YYYY-MM-DD): ");
                    String maintenanceDate = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter Cost: ");
                    double cost = sc.nextDouble();

                    sc.nextLine();

                    Maintenance maintenance = new Maintenance(
                            maintenanceAssetId,
                            maintenanceDate,
                            description,
                            cost
                    );

                    maintenanceDAO.addMaintenance(maintenance);

                    break;

                case 6:

                    System.out.println("\n----- DEPARTMENTS -----");

                    List<Department> departments =
                            departmentDAO.getAllDepartments();

                    for (Department dept : departments) {
                        System.out.println(dept);
                    }

                    break;

                case 7:

                    System.out.println("\n----- EMPLOYEES -----");

                    List<Employee> employees =
                            employeeDAO.getAllEmployees();

                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }

                    break;

                case 8:

                    System.out.println("\n----- ASSET CATEGORIES -----");

                    List<AssetCategory> categories =
                            categoryDAO.getAllCategories();

                    for (AssetCategory cat : categories) {
                        System.out.println(cat);
                    }

                    break;

                case 9:

                    System.out.println("Thank you for using Fixed Asset Management System!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}