package Applications;

import Entity.Employees;
import Entity.Project;
import Entity.Task;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Menu.ProjectMenu.executeAction;
import static Menu.ProjectMenu.printMenu;

public class ProjectManagmentApp {

    public static ProjectManagmentApp projectManagement = new ProjectManagmentApp();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getChoice();
            executeAction(choice);
        }
    }



    private static int getChoice() {
        System.out.print("Enter a number:");
        return scanner.nextInt();
    }

    public List<Employees> viewEmployeesAssignedToProject(Project project) {
        return null;
    }

    public List<Task> viewAllTasksByProject(Project project) {
        return null;
    }

    public Object assignEmployeesToProject(Project project, List<Employees> employees) {
        return null;
    }

    public Object deleteProject(Project project) {
        return null;
    }

    public Object updateProject(Project project) {
        return null;
    }
}