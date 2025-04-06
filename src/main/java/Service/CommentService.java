package Service;

import Entity.Comments;
import Entity.Employees;
import Entity.Task;
import Repository.CommentsRepository;
import Repository.EmployeesRepository;
import Repository.TaskRepository;
import Util.Helper;

import java.util.List;

public class CommentService {
   private final CommentsRepository commentsRepository = new CommentsRepository();
   private final EmployeesRepository employeesRepository = new EmployeesRepository();
   private final TaskRepository taskRepository = new TaskRepository();

    public void addComment (){
        Comments newComment = new Comments();
        int taskId = Helper.getIntFromUser("Enter Task ID: ");
        int employeeId = Helper.getIntFromUser("Enter Employee ID: ");
        Task task = taskRepository.findById(taskId);
        Employees employee = employeesRepository.findById(employeeId);
        newComment.setTask_id(task);
        newComment.setEmployee_id(employee);
        newComment.setContent(Helper.getStringFromUser("Enter content: "));
        newComment.setCreated_at(Helper.getLocalDateFromUser());
        commentsRepository.save(newComment);
        System.out.println("New comment added successfully! Comment ID: " + newComment.getId());
    }


    public void updateComment() {
        int id = Helper.getIntFromUser("Enter Comment ID to update: ");

        Comments commentToUpdate = commentsRepository.getCommentById(id);
        if (commentToUpdate != null) {
            commentToUpdate.setContent(Helper.getStringFromUser("New Comment: "));
            commentsRepository.update(commentToUpdate);
            System.out.println("Comment updated: " + commentToUpdate);
        } else {
            System.out.println("Comment with ID " + id + " not found.");
        }
    }


    public void deleteComment(){
        int id = Helper.getIntFromUser("Enter Comment ID to delete: ");

        Comments commentToDelete = commentsRepository.getCommentById(id);
        if (commentToDelete != null) {
            commentsRepository.delete(commentToDelete);
            System.out.println("Comment deleted: " + commentToDelete);
        } else {
            System.out.println("Comment with ID " + id + " not found.");
        }
    }


    public void viewAllComment() {
        List<Comments> commentsList = commentsRepository.seeAllComments();
        System.out.println("List of comments:");
        commentsList.forEach(System.out::println);
    }

}
