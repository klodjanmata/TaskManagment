import Entity.Task;
import Repository.TaskRepository;
import Util.Helper;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Application {
    private static final TaskRepository taskRep = new TaskRepository();

    public static void main(String[] args) {
        Application app = new Application();

    }


    private static void printMenu() {
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


    private static void executeAction(int choice) {
        switch (choice) {
            case 1:
                addTask();
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

    private static int getChoice() {
        int choice = -1;
        try {
            choice = Helper.getIntFromUser("Enter choice: ");
        } catch (Exception e) {
            System.out.println("Invalid input. ");
            choice = -1;
        }
        return choice;
    }

    private static void addTask(){
        Task task = new Task();
        task.setTitle(Helper.getStringFromUser("Enter title: "));
        task.setDescription(Helper.getStringFromUser("Enter description: "));
        task.setProject_id(Helper.getIntFromUser("Enter project ID: "));
        task.setAssignedTo(Helper.getStringFromUser("Task assigned to employee with id: "));
        task.setPriority(Helper.getStringFromUser("Priority (LOW/MEDIUM/HIGH): "));
        task.setStatus(Helper.getStringFromUser("Status (PENDING/IN PROGRESS/DONE): "));
        task.setDeadline(Helper.getLocalDateFromUser());
        task.setCreatedAt(Helper.getLocalDateFromUser());
        task.setDependsOnTaskId(Helper.getIntFromUser("Depends on task id: "));

        taskRep.save(task);
    }

    private static void updateTask(){
        int taskID = Helper.getIntFromUser("Enter the task ID to update: ");
        Task task = taskRep.getById(taskID);

        if(task == null){
            System.out.println("Task not found! ");
        }



    }

    private static void deleteTask(){
        int id = Helper.getIntFromUser("Enter task ID to delete: ");
        Task task = taskRep.getById(id);

        if(task !=null){
            taskRep.delete(task);
            System.out.println("Task is deleted! ");
        }else{
            System.out.println("Task not found! ");
        }
    }

    private static void printTaskById(){
        int TaskID = Helper.getIntFromUser("Enter task ID: ");
        Task task = taskRep.getById(TaskID);
        System.out.println(task != null ? task : "Task not found!");
    }

    private static void printAllTasks(){
        List<Task> tasks = taskRep.findAll();
        if(tasks.isEmpty()){
            System.out.println("No tasks found! ");
        }else{
            tasks.forEach(System.out::println);
        }
    }

    private static void printTasksByEmployee(){
        String name = Helper.getStringFromUser("Enter employee name: ");
        taskRep.findAll().stream().filter(task -> task.getAssignedTo().equalsIgnoreCase(name)).forEach(System.out::println);
    }

    private static void printTaskByProjectID(){
        int projectID = Helper.getIntFromUser("Enter project ID: ");
        taskRep.findAll().stream().filter(task-> task.getProject_id() == projectID).forEach(System.out::println);
    }

    private static void filterByPriority(){
        String priority = Helper.getStringFromUser("Enter priority (LOW/MEDIUM/HIGH)");
        taskRep.findAll().stream().filter(task -> task.getPriority().equalsIgnoreCase(priority)).forEach(System.out::println);
    }

    private static void filterByStatus(){
        String status = Helper.getStringFromUser("Enter status (PENDING/IN PROGRESS/DONE)");
        taskRep.findAll().stream().filter(task -> task.getStatus().equalsIgnoreCase(status)).forEach(System.out::println);
    }

    private static void sortByDeadline(){
        taskRep.findAll().stream().sorted(Comparator.comparing(Task::getDeadline)).forEach(System.out::println);
    }
}
