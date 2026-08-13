// Question 6: Develop a program to implement multiple inheritance using interfaces.

// First Interface
interface Printable {
    void print();
}

// Second Interface
interface Showable {
    void show();
}

// Class implementing multiple interfaces
class Document implements Printable, Showable {
    private String title;

    public Document(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("Printing document: " + title);
    }

    public void show() {
        System.out.println("Displaying document preview on screen: " + title);
    }
}

public class Q06_MultipleInheritanceInterface {
    public static void main(String[] args) {
        System.out.println("--- Multiple Inheritance via Interfaces Demo ---");
        Document doc = new Document("Java_Assignment.docx");

        doc.print();
        doc.show();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
