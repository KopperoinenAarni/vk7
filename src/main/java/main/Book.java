package main;

public abstract class Book {
    private String title;
    private String author;
    private int pages;
    private int copies;

    abstract void displayInfo();

    abstract String categorize();

    public abstract String getTitle();
    public abstract String getAuthor();
    public abstract int getPages();
    public abstract int getCopies();
}
