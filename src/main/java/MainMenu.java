import Entity.Comments;
import Entity.Employees;
import Entity.Task;
import Menu.EmployeMenu;
import Menu.ProjectMenu;
import Menu.TaskMenu;
import Repository.CommentsRepository;
import Repository.EmployeesRepository;
import Service.EmployeService;
import Service.ProjectService;
import Util.Helper;

import java.util.List;

public class MainMenu {


    public static void main(String[] args) {
        int choice = -1;

        while (choice != 0) {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = getChoice();
            switch (choice) {
                case 1:
                    EmployeMenu.employeesManagementMenu();
                    break;
                case 2:
                    System.out.println("Projects Management selected");
                    ProjectMenu.printMenu();
                    ProjectMenu.executeAction(getChoice());
                    break;
                case 3:
                    System.out.println("Tasks Management selected");
                    TaskMenu.printMenu();
                    TaskMenu.executeAction(getChoice());
                    break;

                case 4:
                    System.out.println("View Team Collaboration");
                    commentManagementMenu();
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Choose an action: ");
        System.out.println("1 - Employees Management");
        System.out.println("2 - Projects Management");
        System.out.println("3 - Tasks Management");
        System.out.println("4 - Team Collaboration");
        System.out.println("0 - Exit");
    }


    public static void commentManagementMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Comment Management - Choose an action:");
            System.out.println("1 - Add Comment");
            System.out.println("2 - Update Comment");
            System.out.println("3 - Delete Comment");
            System.out.println("4 - View All Comments");
            System.out.println("0 - Go back!");
            System.out.print("Enter your choice: ");
            choice = Helper.getIntFromUser();
            switch (choice) {
                case 1:
                    addComment();
                    break;
                case 2:
                    updateComment();
                    break;
                case 3:
                    deleteComment();
                    break;
                case 4:
                    viewAllComment();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    public static void addComment() {
        Comments newComment = new Comments();
        System.out.println("Enter Task ID: ");
        int taskId = Helper.getIntFromUser();

        System.out.println("Enter Employee ID: ");
        int employeeId = Helper.getIntFromUser();

        Task task = new Task();
        task.setId(taskId);

        Employees employee = new Employees();
        employee.setId(employeeId);

        newComment.setTask_id(task);
        newComment.setEmployee_id(employee);

        System.out.println("Enter content: ");
        newComment.setContent(Helper.getStringFromUser());

        newComment.setCreated_at(Util.Helper.getLocalDateFromUser());

        cr.save(newComment);

        System.out.println("New comment added successfully! ");

    }


    public static void updateComment() {
        System.out.print("Enter Comment ID to update: ");
        int id = Helper.getIntFromUser();

        Comments commentToUpdate = cr.getCommentById(id);
        if (commentToUpdate != null) {
            System.out.print("New Comment: ");
            commentToUpdate.setContent(Helper.getStringFromUser());
            cr.update(commentToUpdate);
            System.out.println("Comment updated: " + commentToUpdate);
        } else {
            System.out.println("Comment with ID " + id + " not found.");
        }
    }


    public static void deleteComment() {
        System.out.print("Enter Comment ID to delete: ");
        int id = Helper.getIntFromUser();

        Comments commentToDelete = cr.getCommentById(id);
        if (commentToDelete != null) {
            cr.delete(commentToDelete);
            System.out.println("Comment deleted: " + commentToDelete);
        } else {
            System.out.println("Comment with ID " + id + " not found.");
        }
    }


    public static void viewAllComment() {
        List<Comments> commentsList = cr.seeAllComments();
        System.out.println("List of comments:");
        commentsList.forEach(System.out::println);
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




    public static void projectMenagmentMenu() {
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



}