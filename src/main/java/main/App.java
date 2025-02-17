package main;
import java.util.Scanner;
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        
        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää kirja");
            System.out.println("2) Listaa kirjat");
            System.out.println("3) Lainaa fiktiokirja");
            System.out.println("4) Palauta fiktiokirja");
            System.out.println("0) Lopeta ohjelma");

            if (sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch (i) {
                    case 1:
                        System.out.println("Minkä kirjan haluat lisätä? 1) Fiktiokirja, 2) Tietokirja");
                        String bookType = sc.nextLine();
                        System.out.println("Anna kirjan nimi: ");
                        String setTitle = sc.nextLine();
                        System.out.println("Anna kirjailijan nimi: ");
                        String setAuthor = sc.nextLine();
                        System.out.println("Anna sivumäärä: ");
                        int pages = Integer.parseInt(sc.nextLine());
                        System.out.println("Anna kirjojen määrä: ");
                        int copies = Integer.parseInt(sc.nextLine());

                        if (bookType.equals("1")) {
                            FictionBook fictionBook = new FictionBook(setTitle, setAuthor, pages, copies);
                            library.addBook(fictionBook);
                            System.out.println("Kirja lisätty!");
                        } else if (bookType.equals("2")) {
                            NonFictionBook nonFictionBook = new NonFictionBook(setTitle, setAuthor, pages, copies);
                            library.addBook(nonFictionBook);
                            System.out.println("Kirja lisätty!");
                        } else {
                            System.out.println("Virheellinen kirjavalinta.");
                            break;
                        }
                        break;

                    case 2:
                        if (library.getBooks().isEmpty()) {
                            System.out.println("Kirjasto on tyhjä.");
                            break;
                        }
                        else {
                            library.listBooks();
                            int sumCopies = 0;
                            for (Book book : library.getBooks()) {
                                sumCopies += book.getCopies();
                            } // Tehdään summamuuttuja, joka laskee kirjojen määrän kirjastossa. Tämä auttaa pitämään koodin ohjeiden mukaisena.
                            System.out.println("Kirjojen määrä kirjastossa on: " + sumCopies);
                        }
                        break;

                    case 3:
                        System.out.println("Anna lainattavan kirjan nimi: ");
                        String borrowTitle = sc.nextLine();
                        boolean found = false;
                        for (Book book : library.getBooks()) {
                            if (book instanceof Borrowable && book.getTitle().equals(borrowTitle)) {
                                ((Borrowable) book).borrow();
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Kirjaa ei löytynyt tai se ei ole lainattavissa");
                        }
                        break;

                    case 4:
                        System.out.println("Anna palautettavan kirjan nimi: ");
                        String returnTitle = sc.nextLine();
                        found = false;
                        for (Book book : library.getBooks()) {
                            if (book instanceof Borrowable && book.getTitle().equals(returnTitle)) {
                                ((Borrowable) book).returnBook();
                                found = true;
                                break;
                            }
                        }
                        break;

                    case 0:
                        exit = true;

                        System.out.println("Kiitos ohjelman käytöstä.");
                        break;

                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }
        }
        sc.close();
    }
}