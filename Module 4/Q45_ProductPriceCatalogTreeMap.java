// Question: Write a program to store a list of products and their prices in a TreeMap and display the products in sorted order by name.

import java.util.Map;
import java.util.TreeMap;

public class Q45_ProductPriceCatalogTreeMap {
    public static void main(String[] args) {
        System.out.println("--- Section 12: Advanced Questions ---");
        System.out.println("--- Q45: Product Price Catalog using TreeMap ---\n");

        // TreeMap automatically sorts product names alphabetically in natural ascending order
        TreeMap<String, Double> productCatalog = new TreeMap<>();

        // Inserting unsorted products and prices
        System.out.println("Inserting products into catalog (unsorted order):");
        productCatalog.put("Wireless Mouse", 29.99);
        productCatalog.put("Gaming Keyboard", 89.99);
        productCatalog.put("Apple MacBook Air", 1099.00);
        productCatalog.put("USB-C Hub", 19.50);
        productCatalog.put("Dell 4K Monitor", 349.99);
        productCatalog.put("Bluetooth Speaker", 49.00);

        System.out.println("\n--- Product Catalog (Sorted Alphabetically by Product Name) ---");
        System.out.printf("%-25s | %-10s%n", "PRODUCT NAME", "PRICE ($)");
        System.out.println("----------------------------------------");

        for (Map.Entry<String, Double> product : productCatalog.entrySet()) {
            System.out.printf("%-25s | $%-10.2f%n", product.getKey(), product.getValue());
        }

        System.out.println("----------------------------------------");
        System.out.println("First Product (Alphabetical) : " + productCatalog.firstKey() + " ($" + productCatalog.firstEntry().getValue() + ")");
        System.out.println("Last Product (Alphabetical)  : " + productCatalog.lastKey() + " ($" + productCatalog.lastEntry().getValue() + ")");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
