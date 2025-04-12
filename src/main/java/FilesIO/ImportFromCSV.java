package FilesIO;

public class ImportFromCSV {
    private final CommentsCSVUtil commentsCSVUtil = new CommentsCSVUtil();
    private final EmployeesCSVUtil employeesCSVUtil = new EmployeesCSVUtil();
    private final ProjectCSVUtil projectCSVUtil = new ProjectCSVUtil();
    private final TaskCSVUtil taskCSVUtil = new TaskCSVUtil();

    public void importAllEntities() {
        employeesCSVUtil.saveEmployeesToDB();
        projectCSVUtil.saveProjectsToDB();
        taskCSVUtil.saveTasksToDB();
        commentsCSVUtil.saveCommentsToDB();
    }

}
