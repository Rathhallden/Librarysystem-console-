package library;

import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;
import org.nocrala.tools.texttablefmt.Table;

public class Main {
    public static void main(String[] args) {
        int size = 0; //index start of array object
        System.out.println("\n" + "====================( SET UP LIBRARY )====================");
        String inputsize = Method.Setsizelibrary(); //read library size (String)
        int n = Integer.parseInt(inputsize); //convert into Integer
        Book[] obj = new Book[n]; //create n array object
        Book library = new Book(); //create simple object for call method in class Library
        Method.Setinfolibrary(library, size, n); //call info library
        do {
            System.out.println("\n" + "====================" + "( " + library.getLibraryname().toUpperCase() + "," + library.getLibraryaddress().toUpperCase() + " )" + "====================");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Show Available Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.println("==============================");
            String validate = Method.Validatechoose(); //read input from user with validate (String)
            int choose = Integer.parseInt(validate); //convert into integer
            switch (choose) {
                case 1:
                    if (size == n) //if index object equal size of object will display message
                        System.out.println("Full, Cannot add new book....");
                    else {
                        Method.Addbook(obj, size); //if not yet equal still can add book
                        size++; //after add book index increase 1
                    }
                    break;
                case 2:
                    Method.Showallbook(obj, size); //call Showallbook
                    break;
                case 3:
                    Method.Showavailablebook(obj, size); //call Showavailablebook
                    break;
                case 4:
                    Method.Borrowook(obj, size); //call Borrowbook
                    break;
                case 5:
                    Method.Returnbook(obj, size); //call Returnbook
                    break;
                case 6: {
                    System.out.println("-> good bye !"); //exit
                    System.exit(0);
                }
                default:
                    System.out.println("INPUT INVALID");
            }
            while (!Regex.Readenter()) {
            }//call regex read enter key
        } while (true); //loop always true after click enter key
    }
}
