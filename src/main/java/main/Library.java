package main;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void listBooks() {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("Kirjan kategoria: " + book.categorize());
        }
        
        int sumCopies = 0;
        for (Book sumbook : books) {
            sumCopies += sumbook.getCopies();
        }
        System.out.println("Kirjojen määrä kirjastossa on: " + sumCopies);
    }   

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    
}
