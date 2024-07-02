import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int quantity;

    Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}

public class LibrarySystem {
    private static final Map<String, Book> library = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Library System Menu:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    borrowBooks(scanner);
                    break;
                case 3:
                    returnBooks(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (library.containsKey(title)) {
            Book existingBook = library.get(title);
            existingBook.quantity += quantity;
            System.out.println("Updated the quantity of " + title + " to " + existingBook.quantity);
        } else {
            library.put(title, new Book(title, author, quantity));
            System.out.println("Added " + title + " by " + author + " with quantity " + quantity);
        }
    }

    private static void borrowBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to borrow: ");
        int numToBorrow = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (library.containsKey(title)) {
            Book book = library.get(title);
            if (book.quantity >= numToBorrow) {
                book.quantity -= numToBorrow;
                System.out.println("You have borrowed " + numToBorrow + " copies of " + title);
            } else {
                System.out.println("Not enough copies of " + title + " available.");
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    private static void returnBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to return: ");
        int numToReturn = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (library.containsKey(title)) {
            Book book = library.get(title);
            book.quantity += numToReturn;
            System.out.println("You have returned " + numToReturn + " copies of " + title);
        } else {
            System.out.println("Book not found in the library. Cannot return books that are not in the system.");
        }
    }
}
