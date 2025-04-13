package FilesIO;

import Entity.Comments;
import Entity.Employees;
import Entity.Task;
import Repository.CommentsRepository;
import Repository.EmployeesRepository;
import Repository.TaskRepository;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class CommentsCSVUtil {
    private static final String FILENAMEIMPORT = "Files\\Import\\Comments.csv";
    private static final String FILENAMEEXPORT = "Files\\Export\\Comments.csv";
    private static final String SEPARATOR = ",";
    private final CommentsRepository commentsRepository = new CommentsRepository();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final TaskRepository taskRepository = new TaskRepository();
    private static final EmployeesRepository employeeRepository = new EmployeesRepository();


    public void writeToFile(List<Comments> commentsList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAMEEXPORT))) {
            bw.write(getHeader());
            for (Comments comments : commentsList){
                bw.newLine();
                bw.write(comments.getId() + SEPARATOR);
                bw.write(comments.getTask_id() + SEPARATOR);
                bw.write(comments.getEmployee_id() + SEPARATOR);
                bw.write(comments.getContent() + SEPARATOR);
                bw.write(comments.getCreated_at() + SEPARATOR);

            }
            bw.close();
        }catch (IOException e){
            System.out.println("Error while writing employees to file");
            e.printStackTrace();
        }
    }

    public List<Comments> readFromFile () {
        List<Comments> comments = new ArrayList<Comments>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAMEIMPORT))) {
            List<Comments> commentsList = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] info = line.split(SEPARATOR);
                Comments c = new Comments();

                Task t = taskRepository.findById(Integer.parseInt(info[1]));
                c.setTask_id(t);

                Employees e = employeeRepository.findById(Integer.parseInt(info[2]));
                c.setEmployee_id(e);

                c.setContent(info[3]);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                c.setCreated_at(LocalDate.parse(info[4], formatter));

                commentsList.add(c);
            }

            br.close();
            return commentsList;
        } catch (IOException e) {
            System.out.println("Error while reading employees from file");
            e.printStackTrace();
        }
        return comments;
    }

    public void saveCommentsToDB() {
        saveToDB(readFromFile());
    }

    private void saveToDB(List<Comments> commentsList) {
        for (Comments comments : commentsList) {
            commentsRepository.save(comments);
        }
    }

    public void exportCommentsFromDBToCSV() {
        List<Comments> commentsFromDB = commentsRepository.seeAllComments();
        writeToFile(commentsFromDB);
    }

    private String getHeader () {
        return  "ID" + SEPARATOR +
                "Task ID" + SEPARATOR +
                "Employee ID" + SEPARATOR +
                "Created at: " + SEPARATOR;
    }
}

