import java.util.Scanner;

public class Manager extends Staff implements ICalculator{
    private String title;

    public Manager (int id, String name, int age, double salaryGrading, String startWorkingDate, String department,
                    int vacationDays, String title) {
        super(id, name,age, salaryGrading, startWorkingDate, department, vacationDays);
        this.title =title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public double calculateSalary() {
        double salary = 0.0;
        if (title.equals("Business Leader")) {
            salary = super.getSalaryGrading() * 5000000 + 8000000;
        } else if (title.equals("Project Leader")) {
            salary = super.getSalaryGrading() * 5000000 + 5000000;
        } else if (title.equals("Technical Leader")) {
            salary = super.getSalaryGrading() * 5000000 + 6000000;
        }
        return Math.round(salary);
    }

    @Override
    public void displayInformation() {
        System.out.println("Department: " + super.getDepartment());
        System.out.println("Title: " + title);
        System.out.println("Name: " + super.getName() + ", ID:" + super.getId());
        System.out.println("Age: " + super.getAge());
        System.out.println("Salary: " + calculateSalary());
        System.out.println("Starting working date: " + super.getStartWorkingDate());
        System.out.println("Vacation days: " + super.getVacationDays());
    };
}
