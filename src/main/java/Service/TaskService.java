package Service;

import Entity.Employees;
import Entity.Project;
import Entity.Task;
import Repository.ProjectRepository;
import Repository.TaskRepository;
import Repository.EmployeesRepository;
import Util.Helper;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository = new TaskRepository();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final EmployeesRepository employeesRepository = new EmployeesRepository();

    public void addTask() {
        Task task = new Task();
        task.setTitle(Helper.getStringFromUser("Enter title: "));
        task.setDescription(Helper.getStringFromUser("Enter description: "));

        int projectId = Helper.getIntFromUser("Enter project ID: ");
        Project project = projectRepository.Projectid(projectId);
        if (project == null) {
            System.out.println("Project not found!");
            return;
        }
        task.setProject(project);

        // Assign employee using the employee ID
        int employeeId = Helper.getIntFromUser("Task assigned to employee with id: ");
        Employees employee = employeesRepository.findById(employeeId);
        if (employee != null) {
            task.setAssignedTo(employee);
            System.out.println("Task assigned to: " + employee.getName());
        } else {
            System.out.println("Employee not found!");
            return;
        }

        task.setPriority(Helper.getStringFromUser("Priority (LOW/MEDIUM/HIGH): "));
        task.setStatus(Helper.getStringFromUser("Status (PENDING/IN PROGRESS/DONE): "));
        task.setDeadline(Helper.getLocalDateFromUser());
        task.setCreatedAt(LocalDate.now());

        int dependsOnId = Helper.getIntFromUser("Depends on task ID (0 if none): ");
        if (dependsOnId != 0) {
            Task dependsOn = taskRepository.findById(dependsOnId);
            if (dependsOn != null) {
                task.setDependsOnTask(dependsOn);
            } else {
                System.out.println("Warning: Depends-on task not found. Skipping.");
            }
        }

        taskRepository.save(task);
    }

    public void updateTask() {
        int taskId = Helper.getIntFromUser("Enter the task ID to update: ");
        Task task = taskRepository.findById(taskId);

        if (task == null) {
            System.out.println("Task not found!");
            return;
        }

        task.setTitle(Helper.getStringFromUser("Enter new title: "));
        task.setDescription(Helper.getStringFromUser("Enter new description: "));

        // Update assigned employee by employee ID
        int employeeId = Helper.getIntFromUser("Assigned to (new employee id): ");
        Employees employee = employeesRepository.findById(employeeId);
        if (employee != null) {
            task.setAssignedTo(employee);
            System.out.println("Task reassigned to: " + employee.getName());
        } else {
            System.out.println("Employee not found!");
        }

        task.setPriority(Helper.getStringFromUser("Priority (LOW/MEDIUM/HIGH): "));
        task.setStatus(Helper.getStringFromUser("Status (PENDING/IN PROGRESS/DONE): "));
        task.setDeadline(Helper.getLocalDateFromUser());

        taskRepository.update(task);
        System.out.println("Task updated.");
    }

    public void deleteTask() {
        int id = Helper.getIntFromUser("Enter task ID to delete: ");
        Task task = taskRepository.findById(id);

        if (task != null) {
            taskRepository.delete(task);
            System.out.println("Task is deleted!");
        } else {
            System.out.println("Task not found!");
        }
    }

    public void printTaskById() {
        int taskID = Helper.getIntFromUser("Enter task ID: ");
        Task task = taskRepository.findById(taskID);
        System.out.println(task != null ? task : "Task not found!");
    }

    public void printAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    public void printTasksByEmployee() {
        String name = Helper.getStringFromUser("Enter employee name: ");
        taskRepository.findAll().stream()
                .filter(task -> task.getAssignedTo() != null && task.getAssignedTo().getName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    public void printTaskByProjectID() {
        int projectID = Helper.getIntFromUser("Enter project ID: ");
        taskRepository.findAll().stream()
                .filter(task -> task.getProject() != null && task.getProject().getId() == projectID)
                .forEach(System.out::println);
    }

    public void filterByPriority() {
        String priority = Helper.getStringFromUser("Enter priority (LOW/MEDIUM/HIGH): ");
        taskRepository.findAll().stream()
                .filter(task -> task.getPriority().equalsIgnoreCase(priority))
                .forEach(System.out::println);
    }

    public void filterByStatus() {
        String status = Helper.getStringFromUser("Enter status (PENDING/IN PROGRESS/DONE): ");
        taskRepository.findAll().stream()
                .filter(task -> task.getStatus().equalsIgnoreCase(status))
                .forEach(System.out::println);
    }

    public void sortByDeadline() {
        taskRepository.findAll().stream()
                .sorted(Comparator.comparing(Task::getDeadline))
                .forEach(System.out::println);
    }
}


