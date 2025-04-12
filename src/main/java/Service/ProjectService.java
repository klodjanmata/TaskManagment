package Service;

import Entity.Employees;
import Entity.Project;
import Entity.Task;
import Repository.EmployeesRepository;
import Repository.ProjectRepository;
import Util.Helper;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final EmployeesRepository employeesRepository = new EmployeesRepository();

    public void createProject() {
        Project p = new Project();
        p.setName(Helper.getStringFromUser("Enter project name"));
        p.setDiscription(Helper.getStringFromUser("Enter project description"));
        p.setDateOfStart(Helper.getDateFromUser("Enter start date"));
        p.setDateOfEnd(Helper.getDateFromUser("Enter end date"));
        projectRepository.save(p);
        System.out.println("Project is created");
    }

    public void updateProject() {
        int id = Helper.getIntFromUser("Enter project ID to update");
        Project p = projectRepository.findById(id);

        if (p != null) {
            p.setName(Helper.getStringFromUser("Enter new project name"));
            p.setDiscription(Helper.getStringFromUser("Enter new description"));
            p.setDateOfStart(Helper.getDateFromUser("Enter new start date"));
            p.setDateOfEnd(Helper.getDateFromUser("Enter new end date"));
            projectRepository.update(p);
            System.out.println("Project is updated");
        } else {
            System.out.println("Project not found");
        }
    }

    public void deleteProject() {
        int id = Helper.getIntFromUser("Enter project ID to delete");
        Project p = projectRepository.findById(id);

        if (p != null) {
            projectRepository.delete(p);
            System.out.println("Project is deleted");
        } else {
            System.out.println("Project not found");
        }
    }

    public void assignEmployeesToProject() {
        int projectId = Helper.getIntFromUser("Enter project ID");
        Project project = projectRepository.findById(projectId);

        if (project == null) {
            System.out.println("Project not found");
            return;
        }

        List<Employees> employeesList = new ArrayList<>();
        boolean addMore = true;

        while (addMore) {
            int empId = Helper.getIntFromUser("Enter employee ID to assign");
            Employees employee = employeesRepository.findById(empId);

            if (employee != null) {
                if (!employeesList.contains(employee)) {
                    employeesList.add(employee);
                    System.out.println("Employee added");
                } else {
                    System.out.println("Employee already assigned");
                }
            } else {
                System.out.println("Employee not found");
            }

            addMore = Helper.getStringFromUser("Add more employees? (yes/no)").equalsIgnoreCase("yes");
        }

        project.setEmployees(employeesList);
        projectRepository.update(project);
        System.out.println("Employees assigned to project");
    }

    public final List<Employees> viewEmployeesAssignedToProject() {
        int projectId = Helper.getIntFromUser("Enter project ID to view employees");
        Project project = projectRepository.findById(projectId);

        if (project != null) {
            List<Employees> employees = project.getEmployees();

            if (employees != null && !employees.isEmpty()) {
                System.out.println("Employees assigned to project:");
                for (Employees e : employees) {
                    System.out.println(e.getName());
                }
            } else {
                System.out.println("No employees assigned to this project");
            }

            return employees;
        } else {
            System.out.println("Project not found");
            return null;
        }
    }

    public void viewAllTasksByProject() {
        int projectId = Helper.getIntFromUser("Enter project ID to view all tasks");
        Project project = projectRepository.findById(projectId);

        if (project != null) {
            List<Task> tasks = project.getTasks();

            if (tasks != null && !tasks.isEmpty()) {
                System.out.println("Tasks assigned to this project:");
                for (Task t : tasks) {
                    System.out.println(t.getId());
                }
            } else {
                System.out.println("No tasks assigned to this project");
            }
        } else {
            System.out.println("Project not found");
        }
    }



    public void generateTaskReportByProject() {
        int projectId = Helper.getIntFromUser("Enter project ID to generate task report");
        Project project = projectRepository.findById(projectId);

        if (project != null) {
            List<Task> tasks = project.getTasks();

            System.out.println("\n=== Task Report for Project: " + project.getName() + " ===");

            if (tasks != null && !tasks.isEmpty()) {
                for (Task t : tasks) {
                    System.out.println("Task ID   : " + t.getId());
                    if (t.getAssignedTo() != null) {
                        System.out.println("Assigned to (Employee ID): " + project.getName());
                    } else {
                        System.out.println("Assigned to: none");
                    }
                    System.out.println("-------------------------------");
                }
            } else {
                System.out.println("No tasks found for this project");
            }
        } else {
            System.out.println("Project not found");
        }
    }

    public void viewAllProjects() {
        List<Project> projects = projectRepository.findAll();

        if (projects != null && !projects.isEmpty()) {
            System.out.println("All Projects:");
            for (Project p : projects) {
                System.out.println("ID: " + p.getId() + ", Name: " + p.getName());
            }
        } else {
            System.out.println("No projects found.");
        }
    }
}