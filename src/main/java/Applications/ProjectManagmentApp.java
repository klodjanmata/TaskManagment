package Applications;

import Entity.Employees;
import Entity.Project;
import Entity.Task;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProjectManagmentApp {

    static ProjectManagmentApp projectManagement = new ProjectManagmentApp();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getChoice();
            executeAction(choice);
        }
    }



    private static int getChoice() {
        System.out.print("Enter a number:");
        return scanner.nextInt();
    }



}