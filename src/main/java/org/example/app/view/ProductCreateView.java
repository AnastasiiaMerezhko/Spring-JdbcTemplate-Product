package org.example.app.view;

import org.example.app.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductCreateView {

    public Product getData() {
        Scanner scanner = new Scanner(System.in);
        String tittle = "Input product name: ";
        System.out.println(tittle);
        String name = scanner.nextLine().trim();
        tittle = "Input quota: ";
        System.out.println(tittle);
        Integer quota = scanner.nextInt();
        tittle = "Input product price: ";
        System.out.println(tittle);
        double price = readDouble(scanner);

        return new Product(name, quota, price);
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

    private double readDouble(Scanner scanner) {
        String input = scanner.next();
        input = input.replace(',', '.');
        return Double.parseDouble(input);
    }

}
