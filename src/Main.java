abstract class Employee{

    private String  employeeName ;
    private int employeeID;

    public Employee(String employeeName   , int employeeID ) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return ( "Employee Name = \" " + this.employeeName + " \"  ID = \" "
                + this.employeeID + " \" Salary = \" " + calculateSalary() + " \" " );
    }

}


class FullTimeEmployee extends Employee{

    private double employeeMonthlySalary;
    public FullTimeEmployee(String EmployeeName, int EmployeeID , double EmployeeMonthlySalary ) {
        super(EmployeeName, EmployeeID);
        this.employeeMonthlySalary = EmployeeMonthlySalary;
    }

    public double getEmployeeMonthlySalary() {
        return employeeMonthlySalary;
    }

    public void setEmployeeMonthlySalary(double employeeMonthlySalary) {
        this.employeeMonthlySalary = employeeMonthlySalary;
    }

    @Override
    public double calculateSalary() {
        return employeeMonthlySalary;
    }
}

class PartTimeEmployee extends Employee{

    private int workHours;
    private double hourlySalary;

    PartTimeEmployee(String Name , int ID , int WorkHours , double HourlySalary){
        super(Name , ID );
        this.workHours = WorkHours;
        this.hourlySalary = HourlySalary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double calculateSalary()
    {
        return this.workHours * this.hourlySalary ;
    }
}

 
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}