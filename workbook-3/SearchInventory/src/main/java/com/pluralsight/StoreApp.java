package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        if(inventory == null){
            return;
        }

        Collections.sort(inventory, Comparator.comparing(Product::getName));
        Scanner scanner = new Scanner(System.in);
        while (true) {

            // Display the options menu to the user.
            System.out.println("What do you want to do?");
            System.out.println("  1 - List all products");
            System.out.println("  2 - Lookup a product by its id");
            System.out.println("  3 - Find all products within a price range");
            System.out.println("  4 - Add a new product");
            System.out.println("  5 - Quit the application");
            System.out.println("Enter your command:");

            // Read the user's input command.
            int command = scanner.nextInt();

            // Consume the newline character left in the scanner buffer after reading the command.
            scanner.nextLine();

            // Use a switch statement to call the appropriate method based on the user's input command.
            switch (command) {
                case 1:
                    listAllProducts(inventory);
                    break;
                case 2:
                    lookupProductByID(inventory, scanner);
                    break;
                case 3:
                    findProductWithinPriceRange(inventory, scanner);
                    break;
                case 4:
                    addProduct(inventory, scanner);
                    break;
                case 5:
                    // Display a message to the user and exit the program.
                    System.out.println("Goodbye!");
                    return;
                default:
                    // Display an error message if the user inputs an invalid command.
                    System.out.println("Invalid command.");
                    break;
            }
        }



    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
            String input;
            while((input = bufferedReader.readLine()) != null){
                String[] tokens = input.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                float price = Float.parseFloat(tokens[2]);
                inventory.add(new Product(id, name, price));
            }

        } catch (Exception e){
            System.out.println("ERROR: Could not load inventory.");
            return null;
        }
        return inventory;
    }

    public static void listAllProducts(ArrayList<Product> inventory){
        System.out.println("We carry the following inventory: ");
        for (Product product : inventory){
            System.out.println(product);
        }
    }

    public static void lookupProductByID(ArrayList<Product> inventory, Scanner scanner){
        System.out.print("Please enter product ID: ");
        int id = scanner.nextInt();
        for (Product product : inventory){
            if (product.getId()==id){
                System.out.println("Product found!");
                System.out.println(product);
                return;
            }
        }
        System.out.println("ERROR: Product not found with given ID!");
    }

    public static void findProductWithinPriceRange(ArrayList<Product> inventory, Scanner scanner){
            // Prompt user to enter minimum price
            System.out.print("Enter minimum price: ");
            float minPrice = scanner.nextFloat();

            // Prompt user to enter maximum price
            System.out.print("Enter maximum price: ");
            float maxPrice = scanner.nextFloat();

            // Set a flag to determine if any matching vehicles were found
            boolean found = false;

            // Loop through the vehicles array
            for (Product product: inventory) {

                // Check if the current vehicle's price is within the given price range
                if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {

                    // If the product's price is within the range, print its details
                    System.out.println(product);

                    // Set the flag to true, indicating at least one matching vehicle was found
                    found = true;
                }
            }
            if(!found){
                System.out.println("ERROR: No products found!");
            }
    }
    public static void addProduct(ArrayList<Product> inventory, Scanner scanner){
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product price:");
        float price = scanner.nextFloat();

        inventory.add(new Product(id, name, price));
    }
}
