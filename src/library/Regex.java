package library;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean Verifynum(String input) {
        String rg = "\\d{1,100}"; //set regex can input number(1-100)
        Pattern pattern = Pattern.compile(rg);
        Matcher matcher = pattern.matcher(input);
        boolean check = matcher.matches();
        return check;
    }

    public static boolean invalid(String input) {
        String rg = "[0]||[a-z A-Z]{1,20}||\\W{1,20}[a-z A-Z]{1,20}||[a-z A-Z]{1,20}\\W{1,20}||\\W{1,20}"; //set regex can input beside number
        Pattern pattern = Pattern.compile(rg);
        Matcher matcher = pattern.matcher(input);
        boolean check = matcher.matches();
        return check;
    }

    public static boolean Readenter() {
        Scanner cin = new Scanner(System.in);
        String rg = ""; //set regex only enter key
        String text;
        System.out.print("\n" + "Press 'Enter' to continue....");
        text = cin.nextLine();
        Pattern pattern = Pattern.compile(rg);
        Matcher matcher = pattern.matcher(text);
        boolean check = matcher.matches();
        return check;
    }

    public static boolean onlystring(String input) {
        String rg = "\\d{1,100}||\\W{1,100}||\\d{1,50}\\W{1,50}||\\W{1,50}\\d{1,50}"; //set regex only string
        Pattern pattern = Pattern.compile(rg);
        Matcher matcher = pattern.matcher(input);
        boolean check = matcher.matches();
        return check;
    }

}

