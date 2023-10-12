package org.example.app.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductDeleteView {

    public String getData() {
        Scanner scanner = new Scanner(System.in);
        String tittle = "Input id: ";
        System.out.println(tittle);
        return scanner.nextLine().trim();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
