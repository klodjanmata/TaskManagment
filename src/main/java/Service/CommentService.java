package Service;

import Entity.Comments;
import Entity.Employees;
import Entity.Task;
import Repository.CommentsRepository;
import Util.Helper;

import java.util.List;

public class CommentService {
   private static CommentsRepository commentsRepository = new CommentsRepository();

    public static void addComment (){
        Comments newComment = new Comments();
        int taskId = Helper.getIntFromUser("Enter Task ID: ");
        int employeeId = Helper.getIntFromUser("Enter Employee ID: ");
        Task task = new Task();
        task.setId(taskId);
        Employees employee = new Employees();
        employee.setId(employeeId);
        newComment.setTask_id(task);
        newComment.setContent(Helper.getStringFromUser("Enter content: "));
        newComment.setCreated_at(Util.Helper.getLocalDateFromUser());
        commentsRepository.save(newComment);
        System.out.println("New comment added successfully! ");

    }


    public static void updateComment() {
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


    public static void deleteComment(){
        int id = Helper.getIntFromUser("Enter Comment ID to delete: ");

        Comments commentToDelete = commentsRepository.getCommentById(id);
        if (commentToDelete != null) {
            commentsRepository.delete(commentToDelete);
            System.out.println("Comment deleted: " + commentToDelete);
        } else {
            System.out.println("Comment with ID " + id + " not found.");
        }
    }


    public static void viewAllComment() {
        List<Comments> commentsList = commentsRepository.seeAllComments();
        System.out.println("List of comments:");
        commentsList.forEach(System.out::println);
    }
    private static int getChoice() {
        int choice = -1;
        try {
            choice = Helper.getIntFromUser("Enter choice: ");
        } catch (Exception e) {
            System.out.println("Invalid input. ");
            choice = -1;
        }
        return choice;
    }
}
