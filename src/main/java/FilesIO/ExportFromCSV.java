package FilesIO;

public class ExportFromCSV {
    public void exportAllEntities() {
        employeesCSVUtil.exportEmployeesFromDBToCSV();
        projectCSVUtil.exportProjectsFromDBToCSV();
        taskCSVUtil.exportTasksFromDBToCSV();
        commentsCSVUtil.exportCommentsFromDBToCSV();
    }
}
