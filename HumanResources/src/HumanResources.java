import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HumanResources {

    static List<ArrayList> staffList = new ArrayList<ArrayList>();
    static ArrayList<Manager> managerList = new ArrayList();
    static ArrayList<Employee> employeeList = new ArrayList();
    static ArrayList<Department> deptList = new ArrayList<>();

    private void showOption() {
        System.out.println("Please let us know what information you want to access: " +
                "\n 1. Display the staff list of the company." +
                "\n 2. Display the department list. " +
                "\n 3. Display the staff list according to their departments. " +
                "\n 4. Add a new staff to the list." +
                "\n 5. Search any staff's info according to his/her name or ID. " +
                "\n 6. Display the salary slips of all staffs by ascending." +
                "\n 7. Display the salary slips of all staffs be descending." +
                "\n 8. Exit");
    }

    private void displayStaffList() {
        for (Manager manager: managerList) {
            manager.displayInformation();
        }
        for (Employee employee: employeeList) {
            employee.displayInformation();
        }
    }

//    private void displayDepartmentList() {
//        for (Department department: deptList) {
//            department.toString();
//        }
//    }

    private void displayStaffListByDepartment(String department) {
        for (Manager manager: managerList) {
            if(manager.getDepartment().equals(department)) {
                manager.displayInformation();
            }
        }
        for (Employee employee: employeeList) {
            if(employee.getDepartment().equals(department)) {
                employee.displayInformation();
            }
        }
    }

    private void addManager(Manager newManager) {
        managerList.add(newManager);
    }

    private void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
    }


    private Department takeDepartmentInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department name: ");
        String deptName = sc.nextLine();
        System.out.print("Enter department id: ");
        int deptId = sc.nextInt();
        System.out.print("Total employee: ");
        int totalEmployee = sc.nextInt();
        Department department = new Department(deptId, deptName, totalEmployee);
        return department;
    }

    private void searchManagerByName(String name) {
            for (Manager newManager : managerList) {
                if (newManager.getName().equals(name)){
                newManager.displayInformation();
            } else {
                    System.out.println("Not found");
                }
        }

    }

    private void searchEmployeeByName(String name) {
        for (Employee newEmployee: employeeList) {
            if(newEmployee.getName().equals(name)) {
               newEmployee.displayInformation();
            } else {
                System.out.println("Not found");
            }

        }

    }

    private void searchManagerById(int id) {
        for (Manager newManager: managerList) {
            if(newManager.getId() == id) {
                newManager.displayInformation();
            } else {
                System.out.println("Not found");
            }
        }
    }

    private void searchEmployeeById(int id) {
        for (Employee newEmployee: employeeList) {
            if(newEmployee.getId() == id) {
                newEmployee.displayInformation();
            } else {
                System.out.println("Not found");
            }
        }
    }

    private Manager takeManagerInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Manager Department: ");
        String department = sc.nextLine();
        System.out.print("Enter Manager Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Manager name: ");
        String name = sc.nextLine();
        System.out.print("Enter Manager ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Manager age: ");
        int age = sc.nextInt();
        System.out.print("Enter Manager salary grading: ");
        double salaryGrading = sc.nextDouble();
        System.out.print("Enter Manager start working date (dd/mm/yyyy): ");
        String startWorkingDate = sc.next();
        System.out.print("Enter Manager vacation days: ");
        int vacationDays = sc.nextInt();

        Manager newManager = new Manager(id, name, age, salaryGrading, startWorkingDate, department, vacationDays, title);
        return newManager;
    }

    private Employee takeEmployeeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Department: ");
        String department = sc.nextLine();
        System.out.print("Enter Employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Employee age: ");
        int age = sc.nextInt();
        System.out.print("Enter Employee salary grading: ");
        double salaryGrading = sc.nextDouble();
        System.out.print("Enter Employee start working date (dd/mm/yyyy): ");
        String startWorkingDate = sc.next();
        System.out.print("Enter Employee vacation days: ");
        int vacationDays = sc.nextInt();
        System.out.print("Enter Employee overtime: ");
        double overtime = sc.nextDouble();

        Employee newEmployee = new Employee(id, name, age, salaryGrading, startWorkingDate, department, vacationDays, overtime);
        return newEmployee;
    }

    private void displaySalaryAscending() {
        ArrayList<Double> staffSalary = new ArrayList<Double>();
        for (Manager manager: managerList) {
            staffSalary.add(manager.calculateSalary());
        }
        for (Employee employee: employeeList) {
            staffSalary.add(employee.calculateSalary());
        }
        Collections.sort(staffSalary);
        for (Double number: staffSalary) {
            for (Manager manager: managerList) {
                if(manager.calculateSalary() == number) {
                    System.out.println("Name: " + manager.getName() + number);
                }
            }
            for (Employee employee: employeeList) {
                if(employee.calculateSalary() == number) {
                    System.out.println("Name: " + employee.getName() + ", Salary: " + number);
                }
            }
        }
    }

    private void displaySalaryDescending() {
        ArrayList<Double> staffSalary = new ArrayList<Double>();
        for (Manager manager: managerList) {
            staffSalary.add(manager.calculateSalary());
        }
        for (Employee employee: employeeList) {
            staffSalary.add(employee.calculateSalary());
        }
        Collections.sort(staffSalary, Collections.reverseOrder());
        for (Double number: staffSalary) {
            for (Manager manager: managerList) {
                if(manager.calculateSalary() == number) {
                    System.out.println("Name: " + manager.getName() + number);
                }
            }
            for (Employee employee: employeeList) {
                if(employee.calculateSalary() == number) {
                    System.out.println("Name: " + employee.getName() + ", Salary: " + number);
                }
            }
        }
    }

    public static void main(String[] args) {
        HumanResources main = new HumanResources();
        Scanner sc = new Scanner(System.in);
        int choiceNumber;
        System.out.println("Welcome to the Human Resources Management Program!!!");
        do {
            main.showOption();
            choiceNumber = sc.nextInt();
            switch (choiceNumber) {
                case 1: //Display the staff list of the company
                    if (staffList.isEmpty()) {
                        System.out.println("The list is empty." +
                                "\n Press 4 to add new staff in to the list.");
                    } else {
                        System.out.println("Here is the staff list of the company: ");
                        main.displayStaffList();
                    }
                    break;
                case 2: //Display the department list.
                    if (deptList.isEmpty()) {
                        System.out.println("The list is empty." +
                                "\n Do you want to update the list?" +
                                "\n 1. Yes to continue 2. No to exit");
                        int choice = sc.nextInt();
                        System.out.println("How many departments do you want to add on?");
                            choice = sc.nextInt();
                        for (int i = 0; i < choice; i++) {
                            Department department = main.takeDepartmentInput();
//                            main.addDepartment(department);
                            deptList.add(department);
                        }
                        for(Department department: deptList) {
                            System.out.println(department);
                        }
                    } else {
                        System.out.println("Here is the department list of the company: ");
                        for(Department department: deptList) {
                            System.out.println(department);
                        }
                    }
                    break;
                case 3: //Display the staff list according to their departments.
                    if (staffList.isEmpty()) {
                        System.out.println("The list is empty.");
                    } else {
                        System.out.print("Enter department name: ");
                        String name = sc.next();
                        System.out.println("Here is the staff list of the company according to their department: ");
                        main.displayStaffListByDepartment(name);
                    }
                    break;
                case 4: //Add a new staff to the list.
                    System.out.println("How many staffs do you want to add on?");
                    int addNum = sc.nextInt();
                    for (int i = 0; i < addNum; i++) {
                        System.out.println("Is he/she an Manager or Employee : 1. Manager, 2. Employee ");
                        int option = sc.nextInt();
                        if (option == 1) {
                            Manager newManager = main.takeManagerInput();
                            main.addManager(newManager);
                            staffList.add(managerList);
                        }
                        if (option == 2) {
                            Employee newEmployee = main.takeEmployeeInput();
                            main.addEmployee(newEmployee);
                            staffList.add(employeeList);
                        }
                    }
                    break;
                case 5: //Search any staff's info according to his/her name or ID.
                    System.out.println("Press 1 to search by name" +
                                    "\n Press 2 to search by ID");
                    int option = sc.nextInt();
                        if (option == 1) {
                            System.out.println("Press 1 if he/she is a manager." +
                                            "\n Press 2 if he/she is an employee.");
                            option = sc.nextInt();
                            if (option == 1) {
                                System.out.print("Please enter manager's name: ");
                                String name = sc.next();
                                main.searchManagerByName(name);
                            } else if (option == 2) {
                                System.out.print("Please enter employee's name:");
                                String name = sc.next();
                                main.searchEmployeeByName(name);
                            }
                        } else if (option == 2){
                                System.out.println("Press 1 if he/she is a manager." +
                                                    "\n Press 2 if he/she is an employee.");
                                option = sc.nextInt();
                            if (option == 1) {
                                System.out.print("Please enter manager's id: ");
                                int id = sc.nextInt();
                                main.searchManagerById(id);
                            } else if (option == 2) {
                                System.out.print("Please enter employee's id: ");
                                int id = sc.nextInt();
                                main.searchEmployeeById(id);
                            }
                        }
                    break;
                case 6: //Display the salary slips of all staffs by ascending.
                        System.out.println("Here are the salary slips of all staffs by ascending.");
                        main.displaySalaryAscending();
                    break;
                case 7: //Display the salary slips of all staffs be descending.
                    System.out.println("Here are the salary slips of all staffs by descending.");
                    main.displaySalaryDescending();
                    break;
                case 8: //Exit.
                    System.exit(01);
                    break;
            }

        } while (choiceNumber != 8);


    }
}






