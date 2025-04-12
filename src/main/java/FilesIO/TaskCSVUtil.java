package FilesIO;

import Entity.Comments;
import Entity.Task;
import Entity.Employees;
import Repository.EmployeesRepository;
import Repository.ProjectRepository;
import Repository.TaskRepository;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskCSVUtil {

    public static String FILENAME = "Files\\Import\\TasksToImport.csv";
    public static final String SEPARATOR = ",";

    private final TaskRepository taskRepository = new TaskRepository();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final EmployeesRepository employeesRepository = new EmployeesRepository();

    public void writeToFile(List<Task> tasks) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write(getHeader());
            for (Task t : tasks) {
                bw.newLine();
                bw.write(t.getTitle() + SEPARATOR);
                bw.write(t.getDescription() + SEPARATOR);

                bw.write(t.getAssignedTo() + SEPARATOR);
                bw.write(t.getPriority() + SEPARATOR);
                bw.write(t.getStatus() + SEPARATOR);
                bw.write(t.getCreatedAt() + SEPARATOR);
                bw.write(t.getDeadline() + SEPARATOR);
                bw.write((t.getDependsOnTask() != null ? t.getDependsOnTask().getId() : "null") + SEPARATOR);
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error while writing Tasks!");
            e.printStackTrace();
        }
    }

    public List<Task> readFromFile() {
        List<Task> tasks = new ArrayList<Task>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            boolean firstLine = true;
            String line;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] info = line.split(SEPARATOR);

                // Ensure the info array has the expected number of elements
                if (info.length < 9) {
                    System.out.println("Skipping malformed line: " + line);
                    continue; // Skip lines with less than expected columns
                }

                Task t = new Task();
                t.setTitle(info[1]);
                t.setDescription(info[2]);
                t.setProject(projectRepository.findById(Integer.parseInt(info[3])));
                t.setAssignedTo(employeesRepository.findById(Integer.parseInt(info[4])));

                t.setPriority(info[5]);
                t.setStatus(info[6]);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                t.setCreatedAt(LocalDate.parse(info[7], formatter));
                t.setDeadline(LocalDate.parse(info[8], formatter));

                // Check if DEPENDS_ON_TASK_ID is available, otherwise set null or default
                if (info.length > 9 && !info[9].isEmpty()) {
                    t.setDependsOnTask(taskRepository.findById(Integer.parseInt(info[9])));
                } else {
                    t.setDependsOnTask(null); // Set null if no DEPENDS_ON_TASK_ID
                }

                tasks.add(t);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error while reading tasks.");
            e.printStackTrace();
        }
        return tasks;
    }



    public void saveTasksToDB() {
        saveToDB(readFromFile());
    }

    private void saveToDB(List<Task> tasksList) {
        for (Task tasks : tasksList) {
            taskRepository.save(tasks);
        }
    }

    public void exportTasksFromDBToCSV() {
        List<Task> tasksFromDB = taskRepository.findAll();
        writeToFile(tasksFromDB);
    }

    private String getHeader() {
        return "TITLE" + SEPARATOR +
                "DESCRIPTION" + SEPARATOR +
                "ASSIGNED_TO" + SEPARATOR +
                "PRIORITY" + SEPARATOR +
                "STATUS" + SEPARATOR +
                "CREATED_AT" + SEPARATOR +
                "DEADLINE" + SEPARATOR +
                "DEPENDS_ON_TASK_ID";
    }
}
