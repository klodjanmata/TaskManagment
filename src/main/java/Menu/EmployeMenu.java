package Menu;

import Service.EmployeService;
import Util.Helper;

public class EmployeMenu {
    public static void employeesManagementMenu() {
        EmployeService employeService = new EmployeService();
        int choice = -1;

        while (choice != 0) {
            System.out.println("Employees Management - Choose an action:");
            System.out.println("1 - Add Employee");
            System.out.println("2 - Update Employee");
            System.out.println("3 - Delete Employee");
            System.out.println("4 - View All Employees");
            System.out.println("0 - Go Back");

            System.out.print("Enter your choice: ");
            choice = Helper.getIntFromUser();
            switch (choice) {
                case 1:
                    employeService.addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    listEmployees();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu..." );
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
