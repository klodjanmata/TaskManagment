package Service;

import Entity.Employees;
import Entity.Project;
import Entity.Task;
import Repository.ProjectRepository;
import Util.Helper;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProjectService {
    private final ProjectRepository projectRepository = new ProjectRepository();


    public void createProject() {
        Project p = new Project();
        p.setName(Helper.getStringFromUser("Enter project name"));
        p.setDiscription(Helper.getStringFromUser("Enter project description"));
        p.setDateOfStart(Helper.getDateFromUser("Enter start date"));
        p.setDateOfEnd(Helper.getDateFromUser("Enter end date"));
        projectRepository.save(p);
        System.out.println("Project is created");

    }

    private void createProject(Project project) {

    }


    public void updateProject() {
        System.out.print("Enter project ID to update");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        Project project = new Project();
        project.setId(projectId);
        System.out.print("Enter new project name");
        project.setName(scanner.nextLine());
        System.out.print("Enter new description");
        project.setDiscription(scanner.nextLine());
        projectRepository.save(project);
        System.out.print("Project is updated");
    }


    public static void deleteProject() {
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


    public static void assignEmployeesToProject() {
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


    public static List<Employees> viewEmployeesAssignedToProject() {
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


    public static void viewAllTasksByProject() {
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

    public static void generateTaskReportByProject() {
        System.out.print("Enter project ID to generate task report");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        List<Task> tasks = projectService.generateTaskReportByProject(projectId);
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
