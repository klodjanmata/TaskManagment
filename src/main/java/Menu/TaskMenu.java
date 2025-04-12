package Menu;

import Service.TaskService;

public class TaskMenu {
    private final TaskService taskService = new TaskService();


    public void printMenu() {
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
            default:
                System.out.println("invalid choice! Please choose again! ");
        }
    }


}
