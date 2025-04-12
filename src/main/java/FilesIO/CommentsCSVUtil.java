package FilesIO;

import Entity.Comments;
import Entity.Employees;
import Entity.Task;
import Repository.CommentsRepository;
import Repository.EmployeesRepository;
import Repository.TaskRepository;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CommentsCSVUtil {
    private static final String FILENAME = "Files\\Comments.csv";
    private static final String SEPARATOR = ",";
    private final CommentsRepository commentsRepository = new CommentsRepository();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final TaskRepository taskRepository = new TaskRepository();
    private static final EmployeesRepository employeeRepository = new EmployeesRepository();
    public void writeToFile(List<Comments> commentsList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write(getHeader());
            for (Comments comments : commentsList){
                bw.newLine();
                bw.write(comments.getTask_id() + SEPARATOR);
                bw.write(comments.getEmployee_id() + SEPARATOR);
                bw.write(comments.getContent() + SEPARATOR);
                bw.write(dateFormat.format(comments.getCreated_at()) + SEPARATOR);

            }
            bw.close();
        }catch (IOException e){
            System.out.println("Error while writing employees to file");
            e.printStackTrace();
        }
    }

    public List<Comments> readFromFile () {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            List<Comments> commentsList = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(SEPARATOR);
                Comments c = new Comments();
                Task t = taskRepository.findById(Integer.parseInt(data[0]));
                c.setTask_id(t);
                Employees e = employeeRepository.findById(Integer.parseInt(data[0]));
                c.setEmployee_id(e);

                c.setContent(data[2]);
                c.setContent(data[3]);
                commentsList.add(c);
            }

            br.close();
            return commentsList;
        } catch (IOException e) {
            System.out.println("Error while reading employees from file");
            e.printStackTrace();
        }
        return null;
    }

    public void saveCommentsToDB() {
        saveToDB(readFromFile());
    }

    private void saveToDB(List<Comments> commentsList) {
        for (Comments comments : commentsList) {
            commentsRepository.save(comments);
        }
    }

    private String getHeader () {
        return  "ID" + SEPARATOR +
                "Task ID" + SEPARATOR +
                "Employee ID" + SEPARATOR +
                "Created at: " + SEPARATOR;
    }
}

