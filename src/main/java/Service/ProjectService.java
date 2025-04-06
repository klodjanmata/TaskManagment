package Service;

import Entity.Employees;
import Entity.Project;
import Entity.Task;

import java.util.Date;
import java.util.List;

public class ProjectService {



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
