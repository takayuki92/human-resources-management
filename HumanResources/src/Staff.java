public abstract class Staff {
    private int id;
    private String name;
    private int age;
    private double salaryGrading;
    private String startWorkingDate;
    private String department;
    private int vacationDays;

    public Staff (int id, String name, int age, double salaryGrading, String startWorkingDate, String department, int vacationDays) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryGrading = salaryGrading;
        this. startWorkingDate = startWorkingDate;
        this.department = department;
        this.vacationDays = vacationDays;
    }

    abstract void displayInformation();

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSalaryGrading() {
        return salaryGrading;
    }
    public String getStartWorkingDate() {
        return startWorkingDate;
    }
    public String getDepartment() {
        return department;
    }
    public int getVacationDays() {
        return vacationDays;
    }

}
