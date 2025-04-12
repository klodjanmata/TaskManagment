package CsvFilesIo;

import Entity.Project;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProjectCSVUtil {
    private static final String FILENAME = "ProjectFiles\\Project.csv";
    private static final String SEPARATOR = ",";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public void writeToFile(List<Project> projects) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            writer.write(getHeader());
            for (Project p : projects) {
                writer.newLine();
                writer.write(p.getId() + SEPARATOR);
                writer.write(p.getName() + SEPARATOR);
                writer.write(p.getDiscription() + SEPARATOR);
                writer.write(dateFormat.format(p.getDateOfStart()) + SEPARATOR);
                writer.write(dateFormat.format(p.getDateOfEnd()) + SEPARATOR);

            }
        } catch (IOException e) {
            System.out.println("Error while writing Projects");
            e.printStackTrace();

        }
    }

    public List<Project> readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            List<Project> projects = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] fields = line.split(SEPARATOR);
                Project p = new Project();
                p.setId(Integer.parseInt(fields[0]));
                p.setName(fields[1]);
                p.setDiscription(fields[2]);
                p.setDateOfStart(dateFormat.parse(fields[3]));
                p.setDateOfEnd(dateFormat.parse(fields[4]));
                projects.add(p);
            }

            reader.close();
            return projects;
        } catch (IOException e) {
            System.out.println("Error while reading Projects");
            e.printStackTrace();
        } catch (ParseException pe) {
            System.out.println("Cannot parse date");
            pe.printStackTrace();
        }
        return new ArrayList<>();
    }

    private String getHeader() {
        return
                "ID" + SEPARATOR +
                "Name" + SEPARATOR +
                "Discription" + SEPARATOR +
                "DateOfStart" + SEPARATOR +
                "DateOfEnd";
    }
}