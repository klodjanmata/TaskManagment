package Service;

import Entity.Employees;
import Repository.EmployeesRepository;
import Util.Helper;

import java.util.List;

public class EmployeService {
    private static EmployeesRepository employeesRepository = new EmployeesRepository();

    public static void addEmployee() {
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

        Employees employeeToUpdate = employeesRepository.getEmployessById(id);
        if (employeeToUpdate != null) {
            employeeToUpdate.setPosition(Helper.getStringFromUser("New Position: "));
            employeesRepository.update(employeeToUpdate); // Corrected line
            System.out.println("Employee updated: " + employeeToUpdate);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void deleteEmployee() {
        int id = Helper.getIntFromUser("Enter Employee ID to delete: ");

        Employees employeeToDelete = employeesRepository.getEmployessById(id);
        if (employeeToDelete != null) {
            employeesRepository.delete(employeeToDelete);
            System.out.println("Employee deleted: " + employeeToDelete);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void listEmployees() {
        List<Employees> employeesList = employeesRepository.findAll();
        System.out.println("List of employees:");
        employeesList.forEach(System.out::println);
    }
}