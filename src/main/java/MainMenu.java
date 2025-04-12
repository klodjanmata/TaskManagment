
import FilesIO.ImportFromCSV;
import Menu.CommentsMenu;
import Menu.EmployeMenu;
import Menu.ProjectMenu;
import Menu.TaskMenu;
import Util.Helper;


public class MainMenu {
    private static final TaskMenu taskMenu = new TaskMenu();
    private static final ImportFromCSV importFromCSV = new ImportFromCSV();

    public static void main(String[] args) {
        int choice = -1;

        while (choice != 0) {
            printMenu();
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
                    taskMenu.printMenu();
                    taskMenu.executeAction(getChoice());
                    break;

                case 4:
                    System.out.println("View Team Collaboration");
                    CommentsMenu.commentsMenu();
                    break;
                case 5:
                    importFromCSV.importAllEntities();
                    break;
                case 6:
                    exportFromCSV.exportAllEntities();
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
        System.out.println("5 - Import from files");
        System.out.println("6 - Export from files");
        System.out.println("0 - Exit");
    }


    public static int getChoice() {
        return Helper.getIntFromUser("Enter your choice: ");
    }
}




