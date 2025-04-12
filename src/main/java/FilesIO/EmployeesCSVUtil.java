package FilesIO;

import Entity.Employees;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesCSVUtil {
    private static final String FILENAME = "ProjectFiles\\Employees.csv";
    private static final String SEPARATOR = ",";

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

    public List<Employees> readFromFile () {
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



    public HashMap<String, Employees> readAndReturnMap(){
        return convertListToMap(readFromFile());
    }

    public void writeMapToFile(HashMap<String, Employees> lecturerMap){
        writeToFile(converMapToList(lecturerMap));
    }

    public List<Employees> converMapToList(HashMap<String, Employees> map){
        List<Employees> list = new ArrayList<>();
        list.addAll(map.values());
        return list;
    }

    public HashMap<String, Employees> convertListToMap(List<Employees> list){
        HashMap<String, Employees> map = new HashMap<>();
        map = (HashMap<String, Employees>) list.stream()
                .collect(Collectors.toMap(Employees::getName, employees -> employees));
        return map;
    }


    private String getHeader () {
            return  "ID" + SEPARATOR +
                    "NAME" + SEPARATOR +
                    "SURNAME" + SEPARATOR +
                    "EMAIL" + SEPARATOR +
                    "POSITION" + SEPARATOR;
        }
    }

