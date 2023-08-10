import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee{

    private final String  employeeName ;
    private final int employeeID;

    public Employee(String employeeName   , int employeeID ) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public int getEmployeeID() {
        return employeeID;
    }



    @Override
    public String toString() {
        return ( "Employee Name = \" " + this.employeeName + " \"  ID = \" "
                + this.employeeID + " \" Salary = \" " + getEmployeeSalary() + " \" " );
    }

    public abstract double getEmployeeSalary();
}


class FullTimeEmployee extends Employee{

    private final double employeeMonthlySalary;
    public FullTimeEmployee(String EmployeeName, int EmployeeID , double EmployeeMonthlySalary ) {
        super(EmployeeName, EmployeeID);
        this.employeeMonthlySalary = EmployeeMonthlySalary;
    }


    @Override
    public double getEmployeeSalary() {
        return this.employeeMonthlySalary;
    }


}

class PartTimeEmployee extends Employee{

    private final int workHours;
    private final double hourlySalary;

    PartTimeEmployee(String Name , int ID , int WorkHours , double HourlySalary){
        super(Name , ID );
        this.workHours = WorkHours;
        this.hourlySalary = HourlySalary;
    }

    @Override
    public double getEmployeeSalary() {
        return (this.workHours * this.hourlySalary);
    }
}

class PayrollSystem{

    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee person)
    {
        employeeList.add(person);
    }

    public void removeEmployee(int id)
    {

        Employee EmployeeToRemove = null;

        for(Employee employeeForCounter : employeeList){
            if(employeeForCounter.getEmployeeID() == id) {
                EmployeeToRemove = employeeForCounter ;
                break;
            }

        }
        if (EmployeeToRemove != null) {
            employeeList.remove(EmployeeToRemove);
        }

    }

    public void displayEmployee(){

        System.out.println("-------------------------------------------------------");
        System.out.println("         Displaying all Employees with details ");
        System.out.println("-------------------------------------------------------");

        for (Employee employeeForCounter : employeeList ) {
            System.out.println(" Employee Name : " + employeeForCounter.getEmployeeName());
            System.out.println(" Employee ID : " + employeeForCounter.getEmployeeID());
            System.out.println(" Employee Salary : " + employeeForCounter.getEmployeeSalary());
        }
    }


}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        System.out.println(" /////////////////////////////////////////////////////////////////////////////");
        System.out.println("         WELCOME TO JAVA OOP PAY ROLL MANAGEMENT SYSTEM");
        System.out.println(" /////////////////////////////////////////////////////////////////////////////");

        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("                           Menu:");
            System.out.println("-------------------------------------------------------");

            System.out.println("1). Add Employee");
            System.out.println("2). Remove Employee");
            System.out.println("3). Display Employees");
            System.out.println("4). Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // Adding an employee
                    System.out.print("Enter employee type (FullTime/PartTime): ");
                    String employeeType = scanner.next();
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();

                    // Conditions for Full time Employee
                    if (employeeType.equalsIgnoreCase("FullTime")) {
                        System.out.print("Enter monthly salary: ");
                        double monthlySalary = scanner.nextDouble();
                        payrollSystem.addEmployee(new FullTimeEmployee(name, id, monthlySalary));
                    } // Conditions for Part time Employee
                    else if (employeeType.equalsIgnoreCase("PartTime")) {
                        System.out.print("Enter work hours: ");
                        int workHours = scanner.nextInt();
                        System.out.print("Enter hourly salary: ");
                        double hourlySalary = scanner.nextDouble();
                        payrollSystem.addEmployee(new PartTimeEmployee(name, id, workHours, hourlySalary));
                    } else {
                        System.out.println("Invalid employee type.");
                    }
                }
                case 2 -> {
                    // Removing an employee
                    System.out.print("Enter employee ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    payrollSystem.removeEmployee(idToRemove);
                }
                case 3 ->
                    // Displaying employees
                        payrollSystem.displayEmployee();
                case 4 -> {
                    // Exiting
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }

    }
}