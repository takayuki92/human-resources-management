public class Employee extends Staff implements ICalculator{
    private double overtimeNum;

    public Employee (int id, String name, int age, double salaryGrading, String startWorkingDate, String department, int vacationDays, double overtimeNum) {
        super(id, name,age, salaryGrading, startWorkingDate, department, vacationDays);
        this.overtimeNum = overtimeNum;
    }

    @Override
    public double calculateSalary() {
        double salary = 0;
        salary = getSalaryGrading() * 3000000 + overtimeNum * 200000;
        return Math.round(salary);
    }

    @Override
    public void displayInformation() {
        System.out.println("Department: " + super.getDepartment());
        System.out.println("Name: " + super.getName() + ", ID:" + super.getId());
        System.out.println("Age: " + super.getAge());
        System.out.println("Salary: " + calculateSalary());
        System.out.println("Starting working date: " + super.getStartWorkingDate());
        System.out.println("Vacation days: " + super.getVacationDays());
    }




}
