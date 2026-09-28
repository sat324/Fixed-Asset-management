public class Employee {

    private int employeeId;
    private String employeeName;
    private int departmentId;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
               ", Employee Name: " + employeeName +
               ", Department ID: " + departmentId;
    }
}