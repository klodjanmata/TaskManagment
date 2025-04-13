package FilesIO;

import Entity.Employees;
import Repository.EmployeesRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesCSVUtil {
    private static final String FILENAMEIMPORT = "Files\\Import\\Employees.csv";
    private static final String FILENAMEEXPORT = "Files\\Export\\Employees.csv";
    private static final String SEPARATOR = ",";
    private final EmployeesRepository employeesRepository = new EmployeesRepository();

    public void writeToFile(List<Employees> employeesList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAMEEXPORT))) {
            bw.write(getHeader());
            for (Employees employee : employeesList) {
                bw.newLine();
                bw.write(
                    employee.getId() + SEPARATOR +
                        employee.getName() + SEPARATOR +
                        employee.getSurname() + SEPARATOR +
                        employee.getEmail() + SEPARATOR +
                        employee.getPosition()
                );
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error while writing employees to file");
            e.printStackTrace();
        }
    }


    private List<Employees> readFromFile () {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAMEIMPORT))) {
            List<Employees> employeesList = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(SEPARATOR);
                Employees e = new Employees();
                e.setName(data[1]);
                e.setSurname(data[2]);
                e.setEmail(data[3]);
                e.setPosition(data[4]);
                employeesList.add(e);
            }
            br.close();
            return employeesList;
        } catch (IOException e) {
            System.out.println("Error while reading employees from file");
            e.printStackTrace();
        }
        return null;
    }

    public void saveEmployeesToDB() {
        saveToDB(readFromFile());
    }

    private void saveToDB(List<Employees> employeesList) {
        for (Employees employees : employeesList) {
            employeesRepository.save(employees);
        }
    }

    public void exportEmployeesFromDBToCSV() {
        List<Employees> employeesFromDB = employeesRepository.findAll();
        writeToFile(employeesFromDB);
    }


    private String getHeader () {
            return  "ID" + SEPARATOR +
                    "NAME" + SEPARATOR +
                    "SURNAME" + SEPARATOR +
                    "EMAIL" + SEPARATOR +
                    "POSITION" + SEPARATOR;
        }
    }

