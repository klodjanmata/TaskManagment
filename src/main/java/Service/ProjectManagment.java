package Service;

import Entity.Employees;
import Entity.Project;
import Entity.Task;
import Repository.ProjectRepository;

import java.util.List;


public class ProjectManagment {

    private ProjectRepository projectRepository = new ProjectRepository();


    public void createProject(Project project) {
        projectRepository.save(project);
    }

    public void updateProject(Project project) {
        projectRepository.update(project);
    }


    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }


    public void assignEmployeesToProject(Project project, List<Employees> employees) {

        project.setEmployees(employees);
        projectRepository.update(project);
    }

    public List<Employees> viewEmployeesAssignedToProject(Project project) {
        return project.getEmployees();
    }


    public List<Task> viewAllTasksByProject(Project project) {
        return project.getTasks();
    }


    public List<Task> generateTaskReportByProject(int projectId) {

        Project project = projectRepository.getProjectid(projectId);
        if (project != null) {
            return project.getTasks();
        }
        return null;
    }
}

