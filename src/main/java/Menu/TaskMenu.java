package Menu;

import Entity.Task;
import Repository.TaskRepository;
import Service.TaskService;
import Util.Helper;

import java.util.Comparator;
import java.util.List;

import static Service.TaskService.deleteTask;
import static Service.TaskService.updateTask;

public class TaskMenu {
    private final TaskService taskService = new TaskService();


    public static void printMenu() {
        System.out.println(" Choose action: \n" +
                "1 - Add a new task" +
                "2 - Update task" +
                "3 - Delete task " +
                "4 - Print task by ID"+
                "5 - Print all tasks in a project" +
                "6 - Print all tasks assigned to an employee" +
                "7 - Print tasks by project ID"+
                "8 - Filter task by status" +
                "9 - Filter task by priority" +
                "10 - Print task sorted by deadline" +
                "0 - Exit");
    }


    public static executeAction(int choice) {
        switch (choice) {
            case 1:
                taskService.addTask();
                break;
            case 2:
                updateTask();
                break;
            case 3:
                deleteTask();
                break;
            case 4:
                printTaskById();
                break;
            case 5:
                printAllTasks();
                break;
            case 6:
                printTasksByEmployee();
            case 7:
                printTaskByProjectID();
                break;
            case 8:
                filterByStatus();
                break;
            case 9:
                filterByPriority();
                break;
            case 10:
                sortByDeadline();
                break;
            default:
                System.out.println("invalid choice! Please choose again! ");
        }
    }


}
