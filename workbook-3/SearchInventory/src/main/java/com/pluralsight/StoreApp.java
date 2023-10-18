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
        Collections.sort(inventory, Comparator.comparing(Product::getName));
        Scanner scanner = new Scanner(System.in);

        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.println(p);
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

        }
        /*inventory.add(new Product(1, "Shirt", 19.99f));
        inventory.add(new Product(2, "Pants", 29.99f));
        inventory.add(new Product(3, "Shoes", 49.99f));
        inventory.add(new Product(4, "Shampoo", 10.99f));
        inventory.add(new Product(5, "Jacket", 69.99f));*/
        return inventory;
    }
}
