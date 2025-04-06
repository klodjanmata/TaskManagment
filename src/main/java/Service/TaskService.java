package Service;

import Entity.Task;
import Repository.TaskRepository;
import Util.Helper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository = new TaskRepository();


    public void addTask(){
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

        taskRepository.save(task);
    }

    public void updateTask(){
        int taskID = Helper.getIntFromUser("Enter the task ID to update: ");
        Task task = taskRepository.findById(taskID);

        if(task == null){
            System.out.println("Task not found! ");
        }

    }

    public void deleteTask(){
        int id = Helper.getIntFromUser("Enter task ID to delete: ");
        Task task = taskRepository.findById(id);

        if(task !=null){
            taskRepository.delete(task);
            System.out.println("Task is deleted! ");
        }else{
            System.out.println("Task not found! ");
        }
    }

    public  void printTaskById(){
        int TaskID = Helper.getIntFromUser("Enter task ID: ");
        Task task = taskRepository.findById(TaskID);
        System.out.println(task != null ? task : "Task not found!");
    }

    public   void printAllTasks(){
        List<Task> tasks = taskRepository.findAll();
        if(tasks.isEmpty()){
            System.out.println("No tasks found! ");
        }else{
            tasks.forEach(System.out::println);
        }
    }

    public  void printTasksByEmployee(){
        String name = Helper.getStringFromUser("Enter employee name: ");
        taskRepository.findAll().stream().filter(task -> task.getAssignedTo().equalsIgnoreCase(name)).forEach(System.out::println);
    }

    public  void printTaskByProjectID(){
        int projectID = Helper.getIntFromUser("Enter project ID: ");
        taskRepository.findAll().stream().filter(task-> task.getProject_id() == projectID).forEach(System.out::println);
    }

    public   void filterByPriority(){
        String priority = Helper.getStringFromUser("Enter priority (LOW/MEDIUM/HIGH)");
        taskRepository.findAll().stream().filter(task -> task.getPriority().equalsIgnoreCase(priority)).forEach(System.out::println);
    }

    public  void filterByStatus(){
        String status = Helper.getStringFromUser("Enter status (PENDING/IN PROGRESS/DONE)");
        taskRepository.findAll().stream().filter(task -> task.getStatus().equalsIgnoreCase(status)).forEach(System.out::println);
    }

    public  void sortByDeadline(){
        taskRepository.findAll().stream().sorted(Comparator.comparing(Task::getDeadline)).forEach(System.out::println);
    }
}
