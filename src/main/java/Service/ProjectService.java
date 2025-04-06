package Service;

import Entity.Employees;
import Entity.Project;
import Entity.Task;
import Repository.ProjectRepository;
import Util.Helper;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProjectService {
    private final ProjectRepository projectRepository = new ProjectRepository();


    public void createProject() {
        Project p = new Project();
        p.setName(Helper.getStringFromUser("Enter project name"));
        p.setDiscription(Helper.getStringFromUser("Enter project description"));
        p.setDateOfStart(Helper.getDateFromUser("Enter start date"));
        p.setDateOfEnd(Helper.getDateFromUser("Enter end date"));
        projectRepository.save(p);
        System.out.println("Project is created");

    }


    public void updateProject() {
        Project p = new Project();
        p.setId(Helper.getIntFromUser("Enter your id"));
        p.setName(Helper.getStringFromUser("Enter new project name"));
        p.setDiscription(Helper.getStringFromUser("Enter new discription"));
        projectRepository.save(p);
        System.out.println("Project is updated");

    }


    public void deleteProject() {
        Project p = new Project();
        p.setId(Helper.getIntFromUser("Enter project ID to delete"));
        projectRepository.save(p);
        System.out.println("Project is deleted");

    }


    public void assignEmployeesToProject() {
        Project p = new Project();
        p.setId(Helper.getIntFromUser("Enter project ID"));
        p.setId(Helper.getIntFromUser("Enter employee Id to assign"));
        projectRepository.save(p);
        System.out.println("Employees assigned to project");

    }


    public final List<Employees> viewEmployeesAssignedToProject() {
        Project p = new Project();
        p.setId(Helper.getIntFromUser("Enter project ID to view employees: "));
        projectRepository.save(p);
        System.out.println("Employees assigned to project:");
    }


    public void viewAllTasksByProject() {
        Project p = new Project();
        p.setId(Helper.getIntFromUser("Enter project Id to view all tasks"));
        projectRepository.save(p);
        System.out.println("Tasks associated to the project:");

    }


    public void generateTaskReportByProject() {
        Project p = new Project();
        p.setId(Helper.getIntFromUser("Enter project ID to generate task report"));
        projectRepository.save(p);
        System.out.println("Project-wise task report:");
    }
}

