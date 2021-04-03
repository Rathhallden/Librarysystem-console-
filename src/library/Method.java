package library;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Date;
import java.util.Scanner;

public class Method {
    static Scanner cin = new Scanner(System.in);

    public static String Setsizelibrary() {
        String inputsize; //local var for read string
        do {
            System.out.print("=> Enter Size of Library    :   ");
            inputsize = cin.nextLine();
            if (Regex.invalid(inputsize)) //validate with user input
                System.out.println("INPUT IS INVALID !");
        } while (!Regex.Verifynum(inputsize)); //until user input number loop stop
        return inputsize; //return String inputsize to main
    }

    public static void Setinfolibrary(Book library, int size, int n) {
        library.input(); //object a call method from class Library
        Date date = new Date(); //create object date to read date
        String currentdate = String.format("%tc", date); //read date and time
        System.out.println("'" + library.getLibraryname().toUpperCase() + "'" + " Library is already created in " + "'" + library.getLibraryaddress().toUpperCase() + "'" + " with " + "'" + n + "'" + " size" + " successfully" + " on " + currentdate);
    }

    public static String Validatechoose() {
        String choose;
        do {
            System.out.print("=> Choose option [1-6] : "); //input choice
            choose = cin.nextLine();
            if (Regex.invalid(choose)) //validate with input
                System.out.println("INPUT IS INVALID !");
        } while (!Regex.Verifynum(choose)); //until user input number loop will stop
        return choose; //return choose to main
    }

    public static void Addbook(Book obj[], int size) {
        System.out.println("\n" + "====================( ADD BOOK INFO )====================");
        obj[size] = new Book(); //array object demand initialize with object first then can use
        obj[size].addbook(obj, size); //object with index size(0) call method add book in class book
        System.out.println("\n" + "\t" + "Book is Add Successfully ");
    }

    public static void Showallbook(Book obj[], int size) {
        if (obj[0] == null) //if fist index of object 0 it mean not yet add book
            System.out.println("No Book Available !"); //display message
        else {
            System.out.println("\n" + "====================( ALL BOOK INFO )====================");
            CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center); //make item in table center
            Table t = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL); //create object from build-in class and set coloum and bordersytle
            t.setColumnWidth(0, 10, 20); //set width of column 0
            t.setColumnWidth(1, 15, 15); //set width of column 1
            t.setColumnWidth(2, 15, 15);
            t.setColumnWidth(3, 15, 15);
            t.setColumnWidth(4, 15, 15); // ....................4
            t.addCell("ID", numberStyle); //add this String to table
            t.addCell("TITLE", numberStyle); //...................
            t.addCell("AUTHOR", numberStyle);
            t.addCell("PUBLISHED DATE", numberStyle);
            t.addCell("STATUS", numberStyle); //.................
            for (int i = 0; i < size; i++) { //loop from index 0 to size of object
                String idstring = Integer.toString(obj[i].getId()); //declare String read id(integer)
                t.addCell(idstring); //add id to table (table can add only string)
                t.addCell(obj[i].getTitle());//add title to table
                t.addCell(obj[i].getAuthor());//................
                String pbString = Integer.toString(obj[i].getPublishyear()); //same like ID
                t.addCell(pbString); //.............
                t.addCell(obj[i].getStatus()); //.........
            }
            System.out.println(t.render()); //render data into table
        }
    }

    public static void Showavailablebook(Book obj[], int size) {
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
        if (obj[0] == null)  //if fist index of object 0 it mean not yet add book
            System.out.println("No Book Available !");
        else {
            System.out.println("\n" + "====================( AVAILABLE BOOK INFO )====================");
            t.setColumnWidth(0, 10, 20);    //the same like above
            t.setColumnWidth(1, 15, 15);
            t.setColumnWidth(2, 15, 15);
            t.setColumnWidth(3, 15, 15);
            t.setColumnWidth(4, 15, 15);
            t.addCell("ID", numberStyle);
            t.addCell("TITLE", numberStyle);
            t.addCell("AUTHOR", numberStyle);
            t.addCell("PUBLISHED DATE", numberStyle);
            t.addCell("STATUS", numberStyle);   //the same like above
            for (int i = 0; i < size; i++) { //loop from index 0 to size of object
                if (obj[i].getStatus().equals("Available")) { //if read status equal String available (display)
                    String idstring = Integer.toString(obj[i].getId());
                    t.addCell(idstring);
                    t.addCell(obj[i].getTitle());
                    t.addCell(obj[i].getAuthor());
                    String pbString = Integer.toString(obj[i].getPublishyear());
                    t.addCell(pbString);
                    t.addCell(obj[i].getStatus());
                }
            }
            System.out.println(t.render());
        }
    }

    public static void Borrowook(Book obj[], int size) {
        int id, count = 0;
        String trickid; //for read input id from user and validate with regex
        System.out.println("\n" + "====================( BORROW BOOK INFO )===================");
        do {
            System.out.print("=> Enter Book ID to Borrow : ");
            trickid = cin.nextLine(); //read input from user
            if (Regex.invalid(trickid)) //valid date with regex
                System.out.println("INPUT IS INVALID !");
        } while (!(Regex.Verifynum(trickid))); //until user input number then loop will stop
        id = Integer.parseInt(trickid); //convert id into integer
        for (int i = 0; i < size; i++) { //loop from index 0 to size of object
            if (id == obj[i].getId() && obj[i].getStatus().equals("Unavailable")) { //if id user input equal id obj and status equal Unavilable it mean that this book already borrow
                System.out.println("Book ID : " + id + " is Already Borrow Please Find another Book...."); //display message already borrow
                count++; //count1
            } else if (id == obj[i].getId()) { //if id user input only equal with id obj user can borrow
                System.out.println("Book ID              :   " + obj[i].getId()); //read id by getter
                System.out.println("Enter Book's Name    :   " + obj[i].getTitle()); //read title by title
                System.out.println("Enter Author         :   " + obj[i].getAuthor()); //read author by author
                System.out.println("Enter Published Year :   " + obj[i].getPublishyear() + " is Borrowed Successfully...");
                obj[i].setStatus("Unavailable"); //set status=unavailable by setter
                count++; //count1
            }
        }
        if (count == 0) //if count=0 it mean condition above not true so it mean id user input is not match with id obj
            System.out.println("Book ID : " + id + " is not exist...."); //display message
    }

    public static void Returnbook(Book obj[], int size) {
        System.out.println("\n" + "====================( RETURN BOOK INFO )====================");
        int Id, c = 0;
        String trickId;
        do {
            System.out.print("=> Enter Book ID to Return : ");
            trickId = cin.nextLine();//read input from user
            if (Regex.invalid(trickId))//valid date with regex
                System.out.println("INPUT IS INVALID !");
        } while (!(Regex.Verifynum(trickId))); //until user input number then loop will stop
        Id = Integer.parseInt(trickId);//convert id into integer
        for (int i = 0; i < size; i++) {//loop from index 0 to size of object
            if (Id == obj[i].getId() && obj[i].getStatus().equals("Unavailable")) { //if id user input equal id obj and status equal Unavilable it mean that this book can return
                System.out.println("Book ID              :   " + obj[i].getId()); //read id by getter
                System.out.println("Enter Book's Name    :   " + obj[i].getTitle());//read title by title
                System.out.println("Enter Author         :   " + obj[i].getAuthor());//read author by author
                System.out.println("Enter Published Year :   " + obj[i].getPublishyear() + " is Return Successfully...");
                obj[i].setStatus("Available"); //set status into available by setter
                c++;  //count 1
            }
        }
        if (c == 0)  //if count=0 it mean condition above not true so it mean id user input is not match with id and status
            System.out.println("Book ID : " + Id + " is Failed to return...."); //display message
    }
}

