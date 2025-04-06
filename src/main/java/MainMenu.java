import Entity.Comments;
import Entity.Employees;
import Entity.Task;
import Repository.CommentsRepository;
import Repository.EmployeesRepository;

import java.util.List;

public class MainMenu {

    private static final EmployeesRepository er = new EmployeesRepository();
    private static final CommentsRepository cr = new CommentsRepository();

    public static void main(String[] args) {
        userInput();
    }

    public static void printMenu() {
        System.out.println("Choose an action: ");
        System.out.println("1 - Employees Management");
        System.out.println("2 - Projects Management");
        System.out.println("3 - Tasks Management");
        System.out.println("4 - Team Collaboration");
        System.out.println("0 - Exit");
    }


    public static void userInput() {
        int choice = -1;

        while (choice != 0) {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = Helper.getIntFromUser();
            switch (choice) {
                case 1:
                    employeesManagementMenu();
                    break;
                case 2:
                    System.out.println("Projects Management selected");

                    break;
                case 3:
                    System.out.println("Tasks Management selected");

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


    public static void employeesManagementMenu() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("Employees Management - Choose an action:");
            System.out.println("1 - Add Employee");
            System.out.println("2 - Update Employee");
            System.out.println("3 - Delete Employee");
            System.out.println("4 - View All Employees");
            System.out.println("0 - Go Back");

            System.out.print("Enter your choice: ");
            choice = Helper.getIntFromUser();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    listEmployees();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu..." );
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addEmployee() {
        Employees newEmployee = new Employees();

        System.out.print("Name: ");
        newEmployee.setName(Helper.getStringFromUser());
        System.out.print("Surname: ");
        newEmployee.setSurname(Helper.getStringFromUser());
        System.out.print("Position: ");
        newEmployee.setPosition(Helper.getStringFromUser());
        System.out.print("Email: ");
        newEmployee.setEmail(Helper.getStringFromUser());

        er.save(newEmployee);
        System.out.println("New employee added: " + newEmployee);
    }


    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = Helper.getIntFromUser();

        Employees employeeToUpdate = er.getEmployessById(id);
        if (employeeToUpdate != null) {
            System.out.print("New Position: ");
            employeeToUpdate.setPosition(Helper.getStringFromUser());
            er.update(employeeToUpdate);
            System.out.println("Employee updated: " + employeeToUpdate);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = Helper.getIntFromUser();

        Employees employeeToDelete = er.getEmployessById(id);
        if (employeeToDelete != null) {
            er.delete(employeeToDelete);
            System.out.println("Employee deleted: " + employeeToDelete);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void listEmployees() {
        List<Employees> employeesList = er.findAll();
        System.out.println("List of employees:");
        employeesList.forEach(System.out::println);
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
                    System.out.println("Returning to Main Menu..." );
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    public static void addComment (){
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


    public static void deleteComment(){
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
    }


