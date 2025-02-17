package main;

public class NonFictionBook extends Book {
    private String title;
    private String author;
    private int pages;
    private int copies;
    
    public NonFictionBook(String title, String author, int pages, int copies) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.copies = copies;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public int getCopies() {
        return copies;
    }
    
    @Override
    public String categorize() {
        return "Tietokirja";
    }

    @Override
    public void displayInfo() {
        System.out.println("Nimi: " + getTitle() + ", Kirjailija: " + getAuthor() + ", Sivut: " + getPages() + ", Määrä: " + getCopies());
    }
}
