package library;

import java.util.Scanner;

public class Book extends Library { //extend from class Library to access method in library
    private int id, publishyear;  //encap with private
    private String title, author, status;  //encap with private

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPublishyear(int py) {
        this.publishyear = py;
    }

    public int getPublishyear() {
        return publishyear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void addbook(Book obj[], int size) { //method add book
        Scanner cin = new Scanner(System.in);
        String py;
        id = size += 1;
        System.out.println("=> Book ID              :   " + id);
        do {
            System.out.print("=> Enter Book's Name    :   ");
            title = cin.nextLine();
            if (Regex.onlystring(title))
                System.out.println("INPUT IS INVALID !");
        } while (Regex.onlystring(title));
        do {
            System.out.print("=> Enter Author         :   ");
            author = cin.nextLine();
            if (Regex.onlystring(author))
                System.out.println("INPUT IS INVALID !");
        } while (Regex.onlystring(author));
        do {
            System.out.print("=> Enter Published Year :   ");
            py = cin.nextLine();
            if (Regex.invalid(py))
                System.out.println("INPUT IS INVALID !");
        } while (!Regex.Verifynum(py));
        publishyear = Integer.parseInt(py);
        status = "Available";
    }
}
