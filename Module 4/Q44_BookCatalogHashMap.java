// Question: Create a program to implement a book catalog system using HashMap, where book titles are the keys and author names are the values. Allow searching by title.

import java.util.HashMap;
import java.util.Map;

public class Q44_BookCatalogHashMap {

    static class BookCatalog {
        private final Map<String, String> catalog = new HashMap<>();

        public void addBook(String title, String author) {
            catalog.put(title.trim(), author.trim());
            System.out.println("  [+] Added: \"" + title + "\" by " + author);
        }

        public void searchByTitle(String titleQuery) {
            System.out.println("\nSearching for title: \"" + titleQuery + "\"...");
            if (catalog.containsKey(titleQuery)) {
                System.out.println("  [FOUND] Author: " + catalog.get(titleQuery));
            } else {
                // Partial case-insensitive match helper
                boolean partialFound = false;
                for (Map.Entry<String, String> entry : catalog.entrySet()) {
                    if (entry.getKey().toLowerCase().contains(titleQuery.toLowerCase())) {
                        System.out.println("  [PARTIAL MATCH] \"" + entry.getKey() + "\" by " + entry.getValue());
                        partialFound = true;
                    }
                }
                if (!partialFound) {
                    System.out.println("  [NOT FOUND] No book with title matching \"" + titleQuery + "\"");
                }
            }
        }

        public void displayCatalog() {
            System.out.println("\n--- Complete Book Catalog (" + catalog.size() + " Books) ---");
            System.out.printf("%-35s | %-20s%n", "BOOK TITLE", "AUTHOR");
            System.out.println("---------------------------------------------------------");
            for (Map.Entry<String, String> entry : catalog.entrySet()) {
                System.out.printf("%-35s | %-20s%n", entry.getKey(), entry.getValue());
            }
            System.out.println("---------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 12: Advanced Questions ---");
        System.out.println("--- Q44: Book Catalog System using HashMap ---\n");

        BookCatalog library = new BookCatalog();

        // 1. Adding Books
        System.out.println("1. Populating Book Catalog:");
        library.addBook("Effective Java", "Joshua Bloch");
        library.addBook("Clean Code", "Robert C. Martin");
        library.addBook("Design Patterns", "Gang of Four (GoF)");
        library.addBook("Java: The Complete Reference", "Herbert Schildt");
        library.addBook("Head First Design Patterns", "Eric Freeman");

        // 2. Display Catalog
        library.displayCatalog();

        // 3. Search Operations
        System.out.println("\n2. Searching the Catalog:");
        library.searchByTitle("Effective Java");
        library.searchByTitle("Clean Code");
        library.searchByTitle("Design Patterns");
        library.searchByTitle("Non Existent Book");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
