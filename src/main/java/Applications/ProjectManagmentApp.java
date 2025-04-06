package Applications;

import Entity.Employees;
import Entity.Project;
import Entity.Task;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProjectManagmentApp {

    static ProjectManagmentApp projectManagement = new ProjectManagmentApp();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getChoice();
            executeAction(choice);
        }
    }

    private static void printMenu() {
        System.out.println("Project menagment system \n" +
                "1 - Create a new project \n" +
                "2 - Update a project \n" +
                "3 - Delete a project \n" +
                "4 - Assign employees to a project \n" +
                "5 - View employees assigned to a project \n" +
                "6 - View all tasks by project \n" +
                "7 - Generate project-wise task project \n" +
                "8 - Exit");
    }

    private static int getChoice() {
        System.out.print("Enter a number:");
        return scanner.nextInt();
    }

    public static void executeAction(int choice) {
        switch (choice) {
            case 1:
                createProject();
                break;
            case 2:
                updateProject();
                break;
            case 3:
                deleteProject();
                break;
            case 4:
                assignEmployeesToProject();
                break;
            case 5:
                viewEmployeesAssignedToProject();
                break;
            case 6:
                viewAllTasksByProject();
                break;
            case 7:
                generateTaskReportByProject();
                break;
            case 8:
                System.out.println("Exit");
            default:
                System.out.println("Invalid choice. Please chose again.");
        }
    }

    private static void createProject() {
        scanner.nextLine();
        System.out.print("Enter project Id");
        int id = scanner.nextInt();
        System.out.print("Enter project name");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter project description");
        String description = scanner.nextLine();
        System.out.print("Enter start date");
        String startDate = scanner.nextLine();
        System.out.print("Enter end date");
        String endDate = scanner.nextLine();

        Project project = new Project();
        project.setId(id);
        project.setName(name);
        project.setDiscription(description);
        project.setDateOfStart(parseDate(startDate));
        project.setDateOfEnd(parseDate(endDate));

        projectManagement.createProject(project);
        System.out.println("Project is created");

    }

    private void createProject(Project project) {

    }


    private static void updateProject() {
        System.out.print("Enter project ID to update");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        Project project = new Project();
        project.setId(projectId);
        System.out.print("Enter new project name");
        project.setName(scanner.nextLine());
        System.out.print("Enter new description");
        project.setDiscription(scanner.nextLine());
        projectManagement.updateProject(project);
        System.out.print("Project is updated");
    }

    private void updateProject(Project project) {

    }


    private static void deleteProject() {
        scanner.nextLine();
        System.out.print("Enter project ID to delete");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        Project project = new Project();
        project.setId(projectId);
        projectManagement.deleteProject(project);
        System.out.println("Project is deleted");

    }

    private void deleteProject(Project project) {
    }


    private static void assignEmployeesToProject() {
        System.out.print("Enter project ID: ");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        Project project = new Project();
        project.setId(projectId);
        System.out.println("Enter employee IDs to assign");
        String employeeId = scanner.nextLine();
        List<Employees> employees = getEmployeesById(employeeId);
        projectManagement.assignEmployeesToProject(project, employees);
        System.out.println("Employees assigned to project");
    }

    private void assignEmployeesToProject(Project project, List<Employees> employees) {
    }

    private static List<Employees> getEmployeesById(String employeeId) {
        return null;
    }


    private static List<Employees> viewEmployeesAssignedToProject() {
        System.out.print("Enter project ID to view employees: ");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        Project project = new Project();
        project.setId(projectId);
        List<Employees> employees = projectManagement.viewEmployeesAssignedToProject(project);
        System.out.println("Employees assigned to project:");
        for (Employees employee : employees) {
            System.out.println(employee);
        }
        return employees;
    }

    private List<Employees> viewEmployeesAssignedToProject(Project project) {
        return
    }


    private static void viewAllTasksByProject() {
        System.out.print("Enter project Id to view all tasks");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        Project project = new Project();
        project.setId(projectId);
        List<Task> tasks = projectManagement.viewAllTasksByProject(project);
        System.out.println("Tasks associated to the project:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private List<Task> viewAllTasksByProject(Project project) {
        return null;
    }

    private static void generateTaskReportByProject() {
        System.out.print("Enter project ID to generate task report");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        List<Task> tasks = projectManagement.generateTaskReportByProject(projectId);
        System.out.println("Project-wise task report:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private List<Task> generateTaskReportByProject(int projectId) {

        return null;
    }


    private static Date parseDate(String startDate) {
        return null;
    }

}