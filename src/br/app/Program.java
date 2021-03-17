/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://www.youtube.com/watch?v=gj80JEqk5ms
 */
package br.app;

import br.model.entities.Client;
import br.model.entities.Order;
import br.model.entities.OrderItem;
import br.model.entities.Product;
import br.model.entities.enuns.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author roger
 */
public class Program {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Birth date (DD/MM/YYYY)");
        Date birthDate = sdf.parse(scan.next());
        
        Client client = new Client(name, email, birthDate);
        
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scan.next());
        
        Order order = new Order(new Date(), status, client);
        
        System.out.println("How many items to this order? ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            scan.nextLine();
            String productName = scan.nextLine();
            System.out.print("Product price: ");
            double productPrice = scan.nextDouble();
            System.out.print("Quantity: ");
            int quantity = scan.nextInt();
            
            Product product = new Product(productName, productPrice);
            
            OrderItem it = new OrderItem(quantity, productPrice, product);
            
            order.addItem(it);            
        }
        System.out.println("");
        System.out.println(order);
        
        

    }

}
