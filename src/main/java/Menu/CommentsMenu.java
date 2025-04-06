package Menu;

import Service.CommentService;
import Util.Helper;

public class CommentsMenu {
    public static void commentsManagmentMenu () {
        CommentService commentService = new CommentService();
        int choice = -1;
        while (choice != 0) {
            System.out.println("Comment Management - Choose an action:");
            System.out.println("1 - Add Comment");
            System.out.println("2 - Update Comment");
            System.out.println("3 - Delete Comment");
            System.out.println("4 - View All Comments");
            System.out.println("0 - Go back!");

            choice = Helper.getIntFromUser("Enter your choice: ");
            switch (choice) {
                case 1:
                    commentService.addComment();
                    break;
                case 2:
                    commentService.updateComment();
                    break;
                case 3:
                 commentService.deleteComment();
                    break;
                case 4:
                   commentService.viewAllComment();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu..." );
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

}
