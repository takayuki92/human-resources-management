public class Department {
    private int deptId;
    private String deptName;
    private int totalEmployee;

    public Department (int deptId, String deptName, int totalEmployee) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.totalEmployee = totalEmployee;
    }

    public String toString() {
        return "Department Name: " + deptName + "\n Department ID: " + deptId
                + "\n Total of Employee: " + totalEmployee;
    }

}
