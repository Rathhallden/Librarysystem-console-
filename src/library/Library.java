package library;

import java.util.Scanner;

public class Library {
    static Scanner cin = new Scanner(System.in);
    private String libraryname, libraryaddress; //encap property with private

    public void input() { //method input librayname and libraryaddress
        do {
            System.out.print("=> Enter Library's name     :   ");  //input ln
            libraryname = cin.nextLine();
            if (Regex.onlystring(libraryname))  //validate with regex
                System.out.println("INPUT IS INVALID !");
        } while (Regex.onlystring(libraryname));
        do {
            System.out.print("=> Enter Library's Address  :   "); //input la
            libraryaddress = cin.nextLine();
            if (Regex.onlystring(libraryaddress)) //validate with regex
                System.out.println("INPUT IS INVALID !");
        } while (Regex.onlystring(libraryaddress));
    }

    public void setLibraryaddress(String libraryaddress) {
        this.libraryaddress = libraryaddress;
    }

    public String getLibraryaddress() {
        return libraryaddress;
    }

    public void setLibraryname(String libraryname) {
        this.libraryname = libraryname;
    }

    public String getLibraryname() {
        return libraryname;
    }

}
