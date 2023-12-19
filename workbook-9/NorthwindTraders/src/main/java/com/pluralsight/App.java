package com.pluralsight;

import com.pluralsight.model.Product;
import com.pluralsight.service.ProductAlreadyExistsException;
import com.pluralsight.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ProductAlreadyExistsException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        Scanner scanner = new Scanner(System.in);
        ProductService productService = ctx.getBean(ProductService.class);

        boolean repeat = true;

        do {
            System.out.println("""
                    MENU
                    1. List Products
                    2. Add Product
                    3. Exit""");
            System.out.print("Pick an option: ");
            int choice = Integer.parseInt( scanner.nextLine());
            switch (choice){
                case 1:
                    productService.listProducts();
                    break;
                case 2:
                    System.out.println("Type a product ID");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What is the name of the product to add?");
                    String name = scanner.nextLine();
                    System.out.println("What is the category of the product to add?");
                    String category = scanner.nextLine();
                    System.out.println("How much does the product cost?");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Product newProduct = new Product(id, name, category, price);
                    productService.addToInventory(newProduct);
                    break;
                case 3:
                    System.out.println("Thank you for using this program. Goodbye.");
                    repeat = false;
                default:
                    System.out.println("Invalid choice.");
            }
        }while(repeat);
    }


}
