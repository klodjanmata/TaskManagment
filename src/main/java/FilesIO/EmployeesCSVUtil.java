package FilesIO;

import Entity.Employees;
import Repository.EmployeesRepository;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesCSVUtil {
    private static final String FILENAME = "Files\\Import\\Employees.csv";
    private static final String SEPARATOR = ",";
    private final EmployeesRepository employeesRepository = new EmployeesRepository();

    public void writeToFile(List<Employees> employeesList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write(getHeader());
            for (Employees employees : employeesList){
                bw.newLine();
                bw.write(employees.getName() + SEPARATOR);
                bw.write(employees.getSurname() + SEPARATOR);
                bw.write(employees.getEmail() + SEPARATOR);
                bw.write(employees.getPosition() + SEPARATOR);
            }
            bw.close();
        }catch (IOException e){
            System.out.println("Error while writing employees to file");
            e.printStackTrace();
        }
    }

    private List<Employees> readFromFile () {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
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
                e.setName(data[0]);
                e.setSurname(data[1]);
                e.setEmail(data[2]);
                e.setPosition(data[3]);
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


    private String getHeader () {
            return  "ID" + SEPARATOR +
                    "NAME" + SEPARATOR +
                    "SURNAME" + SEPARATOR +
                    "EMAIL" + SEPARATOR +
                    "POSITION" + SEPARATOR;
        }
    }

