package Menu;

import Service.ProjectService;

public class ProjectMenu {

    public static final ProjectService projectService = new ProjectService();

    public static void printMenu() {
        System.out.println("Project management system\n" +
                "Choose an option: " +
                "1 - Create a new project \n" +
                "2 - Update a project \n" +
                "3 - Delete a project \n" +
                "4 - Assign employees to a project \n" +
                "5 - View employees assigned to a project \n" +
                "6 - View all tasks by project \n" +
                "7 - Generate project-wise task project \n" +
                "0 - Exit");
    }

    public static void executeAction(int choice) {
        switch (choice) {
            case 1:
                projectService.createProject();
                break;
            case 2:
                projectService.updateProject();
                break;
            case 3:
                projectService.deleteProject();
                break;
            case 4:
                projectService.assignEmployeesToProject();
                break;
            case 5:
                projectService.viewEmployeesAssignedToProject();
                break;
            case 6:
                projectService.viewAllTasksByProject();
                break;
            case 7:
                projectService.generateTaskReportByProject();
                break;
            case 0:
                System.out.println("Returning to main menu...");
            default:
                System.out.println("Invalid choice. Please chose again!");
        }
    }
}
