package Menu;

import Service.TaskService;

public class TaskMenu {
    private final TaskService taskService = new TaskService();


    public void printMenu() {
        System.out.println("Task menu - Choose an action: " +
                "1 - Add a new task\n" +
                "2 - Update task\n" +
                "3 - Delete task\n" +
                "4 - Print task by ID\n"+
                "5 - Print all tasks in a project\n" +
                "6 - Print all tasks assigned to an employee\n" +
                "7 - Print tasks by project ID\n"+
                "8 - Filter task by status\n" +
                "9 - Filter task by priority\n" +
                "10 - Print task sorted by deadline\n" +
                "0 - Exit");
    }

    public  void executeAction(int choice) {
        switch (choice) {
            case 1:
                taskService.addTask();
                break;
            case 2:
                taskService.updateTask();
                break;
            case 3:
                taskService.deleteTask();
                break;
            case 4:
                taskService.printTaskById();
                break;
            case 5:
                taskService.printAllTasks();
                break;
            case 6:
                taskService.printTasksByEmployee();
            case 7:
                taskService.printTaskByProjectID();
                break;
            case 8:
                taskService.filterByStatus();
                break;
            case 9:
                taskService.filterByPriority();
                break;
            case 10:
                taskService.sortByDeadline();
                break;
            case 0:
                System.out.println("Returning to main menu...");
            default:
                System.out.println("invalid choice! Please choose again! ");
        }
    }


}
