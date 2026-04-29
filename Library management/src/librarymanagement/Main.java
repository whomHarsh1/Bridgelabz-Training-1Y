package librarymanagement;



import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1. Librarian");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter your role: ");

            int role = sc.nextInt();

            switch (role) {

                // LIBRARIAN MENU
                case 1:
                    System.out.println("\n--- Librarian Menu ---");
                    System.out.println("1. Add Book");
                    System.out.println("2. View Book by ID");

                    int choice1 = sc.nextInt();

                    switch (choice1) {
                        case 1:
                            sc.nextLine(); // clear buffer
                            System.out.print("Enter Title: ");
                            String title = sc.nextLine();

                            System.out.print("Enter Author: ");
                            String author = sc.nextLine();

                            System.out.print("Enter Genre: ");
                            String genre = sc.nextLine();

                            System.out.print("Enter Book ID: ");
                            int id = sc.nextInt();

                            Book book = new Book(title, author, genre);
                            BookItem item = new BookItem(id, book);

                            library.addBookItem(item);

                            System.out.println(" Book Added Successfully!");
                            break;

                        case 2:
                            System.out.print("Enter Book ID: ");
                            int searchId = sc.nextInt();

                            BookItem found = library.searchById(searchId);

                            if (found != null) {
                                System.out.println(" Book Found: " + found.getBook().getTitle());
                            } else {
                                System.out.println(" Book Not Found");
                            }
                            break;
                    }
                    break;

                // STUDENT MENU
                case 2:
                    System.out.println("\n--- Student Menu ---");
                    System.out.println("1. Search Book by ID");

                    int choice2 = sc.nextInt();

                    switch (choice2) {
                        case 1:
                            System.out.print("Enter Book ID: ");
                            int searchId = sc.nextInt();

                            BookItem found = library.searchById(searchId);

                            if (found != null) {
                                System.out.println(" Book: " + found.getBook().getTitle());
                            } else {
                                System.out.println(" Book Not Found");
                            }
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Exiting... ");
                    return;

                default:
                    System.out.println(" Invalid Choice");
            }
        }
    }
}

