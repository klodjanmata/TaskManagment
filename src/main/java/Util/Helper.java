package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Helper {

    public static int getIntFromUser(String s){
        Scanner input = new Scanner(System.in);
        System.out.println(s);
        int number = input.nextInt();
        return number;
    }

    public static String getStringFromUser(String s){
        Scanner input = new Scanner(System.in);
        System.out.println(s);
        String string = input.nextLine();
        return string;
    }

    public static Date getDateFromUser(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.print("FORMAT: dd.MM.yyyy\t");
        String date = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            Date d = new Date();
            d.setYear(90);
            d.setMonth(0);
            d.setDate(1);
            return d;
        }
    }
    public static LocalDate getLocalDateFromUser(){
        return LocalDate.now();
    }
}
