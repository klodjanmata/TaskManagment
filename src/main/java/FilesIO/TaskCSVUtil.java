package FilesIO;

import Entity.Task;
import Entity.Employees;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskCSVUtil {

    public static String FILENAME = "Files\\Tasks.csv";
    public static final String SEPARATOR = ",";

    public void writeToCSV(List<Task> tasks) {
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

    public List<Task> readFromCSV() {
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
                Task t = new Task();
                t.setTitle(info[0]);
                t.setDescription(info[1]);
                if (!info[2].equals("null")) {
                    Employees emp = new Employees();
                    emp.setId(Integer.parseInt(info[2]));
                    t.setAssignedTo(String.valueOf(emp));
                }

                t.setPriority(info[3]);
                t.setStatus(info[4]);

                DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                t.setCreatedAt(LocalDate.parse(info[5], formatter));
                t.setDeadline(LocalDate.parse(info[6], formatter));

                if (!info[7].equals("null")) {
                    Task depends = new Task();
                    depends.setId(Integer.parseInt(info[7]));
                    t.setDependsOnTask(depends);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error while reading tasks.");
            e.printStackTrace();
        }
        return tasks;
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
