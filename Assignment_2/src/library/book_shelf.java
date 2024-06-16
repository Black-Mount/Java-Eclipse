package library;

import java.util.*;

public class book_shelf {
    // Inner class representing a Book
    private static class Book {
        private String title;
        private String author;
        private int quantity;  // Total quantity of this book in the library
        private int borrowed;  // Quantity of this book currently borrowed

        // Constructor to initialize a new Book object
        public Book(String title, String author, int quantity) {
            this.title = title;
            this.author = author;
            this.quantity = quantity;
            this.borrowed = 0;  // Initially, no books of this type are borrowed
        }

        // Getters and setters for Book attributes
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getBorrowed() {
            return borrowed;
        }

        public void setBorrowed(int borrowed) {
            this.borrowed = borrowed;
        }

        // Method to increase the quantity of this book
        public void increaseQuantity(int amount) {
            this.quantity += amount;
        }

        // Method to decrease the quantity of this book (borrow operation)
        public void borrow(int amount) {
            this.borrowed += amount;
            this.quantity -= amount;
        }

        // Method to return borrowed books of this type (return operation)
        public void returnBooks(int amount) {
            this.borrowed -= amount;
            this.quantity += amount;
        }
    }

    // Inner class representing a Library
    private static class Library {
        private Map<String, Book> books;  // Map to store books by title

        // Constructor to initialize the library with an empty map of books
        public Library() {
            this.books = new HashMap<>();
        }

        // Method to add a new book to the library or update its quantity if already exists
        public void addBook(String title, String author, int quantity) {
            if (books.containsKey(title)) {
                // Book already exists, update quantity
                Book existingBook = books.get(title);
                existingBook.increaseQuantity(quantity);
            } else {
                // New book, add to library
                Book newBook = new Book(title, author, quantity);
                books.put(title, newBook);
            }
            System.out.println("Book added/updated successfully.");
        }

        // Method to borrow books from the library
        public void borrowBook(String title, int quantity) {
            if (books.containsKey(title)) {
                Book requestedBook = books.get(title);
                if (requestedBook.getQuantity() >= quantity) {
                    requestedBook.borrow(quantity);
                    System.out.println("Books borrowed successfully.");
                } else {
                    System.out.println("Insufficient quantity of books available.");
                }
            } else {
                System.out.println("Book not found in the library.");
            }
        }

        // Method to return borrowed books to the library
        public void returnBook(String title, int quantity) {
            if (books.containsKey(title)) {
                Book returnedBook = books.get(title);
                if (returnedBook.getBorrowed() >= quantity) {
                    returnedBook.returnBooks(quantity);
                    System.out.println("Books returned successfully.");
                } else {
                    System.out.println("Invalid quantity to return.");
                }
            } else {
                System.out.println("Book not found in the library system.");
            }
        }

        // Method to display the status (available and borrowed quantities) of all books in the library
        public void displayBookStatus() {
            System.out.println("\n===== Book Status =====");
            for (Book book : books.values()) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Available Quantity: " + book.getQuantity());
                System.out.println("Borrowed Quantity: " + book.getBorrowed());
                System.out.println("------------------------------");
            }
        }
    }

    // Main method to run the library management system
    public static void main(String[] args) {
        Library library = new Library();  // Create a new library instance
        Scanner scanner = new Scanner(System.in);  // Scanner to read user input

        // Main program loop for interacting with the library system
        while (true) {
            // Display menu options
            System.out.println("\n===== Santiago's Library =====");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Display Book Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();  // Read user choice
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add new book
                    System.out.print("Enter book title: ");
                    String addTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String addAuthor = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int addQuantity = scanner.nextInt();
                    library.addBook(addTitle, addAuthor, addQuantity);
                    break;
                case 2:
                    // Borrow books
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    System.out.print("Enter quantity to borrow: ");
                    int borrowQuantity = scanner.nextInt();
                    library.borrowBook(borrowTitle, borrowQuantity);
                    break;
                case 3:
                    // Return books
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    System.out.print("Enter quantity to return: ");
                    int returnQuantity = scanner.nextInt();
                    library.returnBook(returnTitle, returnQuantity);
                    break;
                case 4:
                    // Display book status
                    library.displayBookStatus();
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting Santiago's Library, goodbye!");
                    scanner.close();  // Close the scanner
                    System.exit(0);  // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
