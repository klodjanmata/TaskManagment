package FilesIO;

public class ExportToCSV {
    private final EmployeesCSVUtil employeesCSVUtil = new EmployeesCSVUtil();
    private final ProjectCSVUtil projectCSVUtil = new ProjectCSVUtil();
    private final TaskCSVUtil taskCSVUtil = new TaskCSVUtil();
    private final CommentsCSVUtil commentsCSVUtil = new CommentsCSVUtil();

    public void exportAllEntities() {
        employeesCSVUtil.exportEmployeesFromDBToCSV();
        projectCSVUtil.exportProjectFromDBToCSV();
        taskCSVUtil.exportTasksFromDBToCSV();
        commentsCSVUtil.exportCommentsFromDBToCSV();
    }
}

