package Service;

import Entity.Employees;
import Repository.EmployeesRepository;
import Util.Helper;

import java.util.List;

public class EmployeService {
    private final EmployeesRepository employeesRepository = new EmployeesRepository();
    public void addEmployee() {
        Employees newEmployee = new Employees();
        newEmployee.setName(Helper.getStringFromUser("Name: "));
        newEmployee.setSurname(Helper.getStringFromUser("Surname: "));
        newEmployee.setPosition(Helper.getStringFromUser("Position: "));
        newEmployee.setEmail(Helper.getStringFromUser("Email: "));

        employeesRepository.save(newEmployee);
        System.out.println("New employee added: " + newEmployee);
    }

    public static void updateEmployee() {
        int id = Helper.getIntFromUser("Enter Employee ID to update: ");

        Employees employeeToUpdate = er.getEmployessById(id);
        if (employeeToUpdate != null) {
            employeeToUpdate.setPosition(Helper.getStringFromUser("New Position: "));
            er.update(employeeToUpdate);
            System.out.println("Employee updated: " + employeeToUpdate);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = Helper.getIntFromUser();

        Employees employeeToDelete = er.getEmployessById(id);
        if (employeeToDelete != null) {
            er.delete(employeeToDelete);
            System.out.println("Employee deleted: " + employeeToDelete);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void listEmployees() {
        List<Employees> employeesList = er.findAll();
        System.out.println("List of employees:");
        employeesList.forEach(System.out::println);
    }


}
