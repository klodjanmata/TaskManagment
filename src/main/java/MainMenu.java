import Entity.Comments;
import Entity.Employees;
import Entity.Task;
import Menu.CommentsMenu;
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
                    CommentsMenu.commentsMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
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


    public static int getChoice() {
        return Helper.getIntFromUser("Enter your choice: ");
    }
}




