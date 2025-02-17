package main;

public class FictionBook extends Book implements Borrowable {
    private String title;
    private String author;
    private int pages;
    private int copies;
    private int maxCopies; 
    // maxCopies muuttuja auttaa tarkistamaan, onko kaikki kirjat paikalla, kun yritetään palauttaa kirja
    
    public FictionBook(String title, String author, int pages, int copies) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.copies = copies;
        this.maxCopies = copies;
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

    public int setCopies(int copies) {
        this.copies = copies;
        return copies;
    }
    
    @Override
    public String categorize() {
        return "Fiktiokirja";
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Nimi: " + getTitle() + ", Kirjailja " + getAuthor() + ", Sivut " + getPages() + ", Määrä " + getCopies());
    }
    
    @Override
    public void borrow() {
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
            System.out.println("Kirja " + this.getTitle() + " on nyt lainattu");
        }
        else {
            System.out.println("Kirja " + this.getTitle() + " ei enään ole lainattavissa");
        }
    }

    @Override
    public void returnBook() {
        if (getCopies() < maxCopies) {
            setCopies(getCopies() + 1);
            System.out.println("Kirja " + this.getTitle() + " on palautettu");
        }
        else {
            System.out.println("Kirja " + this.getTitle() + " ei ole lainassa");
        }
    }
}
