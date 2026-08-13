// Question 39: Create a program that initializes class fields using a parameterized constructor.

class Book {
    private String title;
    private String author;
    private double price;

    // Parameterized constructor initializing fields
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayBookInfo() {
        System.out.println("Book Title:  " + title);
        System.out.println("Author:      " + author);
        System.out.println("Price:       $" + price);
    }
}

public class Q39_ParameterizedConstructor {
    public static void main(String[] args) {
        System.out.println("--- Parameterized Constructor Demo ---");

        // Initializing fields at object creation time
        Book book1 = new Book("Effective Java", "Joshua Bloch", 45.00);
        Book book2 = new Book("Clean Code", "Robert C. Martin", 40.50);

        System.out.println("--- Book 1 Details ---");
        book1.displayBookInfo();

        System.out.println("\n--- Book 2 Details ---");
        book2.displayBookInfo();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
