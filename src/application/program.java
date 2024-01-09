package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enumEntities.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class program {
    public static void main(String[] args) throws ParseException {
        Scanner get = new Scanner(System.in);

        SimpleDateFormat dateText = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat nowDateText = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date orderDataNow = new Date();

        System.out.println("Enter Client Data:");
        System.out.println("Name:");
        String name = get.nextLine();

        System.out.println("Email:");
        String email = get.nextLine();

        System.out.println("Birth Date:");
        String textData = get.next();
        Date birthDay = dateText.parse(textData);

        Client client;
        if (email != ""){
            client = new Client(name, email, birthDay);
        }
        else {
            client = new Client(name, birthDay);
        }

        System.out.println("Enter Order Data:");
        System.out.println("Status:");
        OrderStatus status;
        status = OrderStatus.valueOf(get.next().toUpperCase());

        Order newOrder = new Order(orderDataNow, status, client);

        System.out.println("How many items to this order?");
        int qntdItens = get.nextInt();
        get.nextLine();

        for (int n = 0; n < qntdItens; n++){
            System.out.printf("Enter #%d item data:\n", n+1);
            System.out.println("Product name:");
            String nameProduct = get.nextLine();

            System.out.println("Product price:");
            Double priceProduct = get.nextDouble();
            get.nextLine();

            System.out.println("Quantity:");
            int quantProduct = get.nextInt();
            get.nextLine();

            Product product = new Product(nameProduct, priceProduct);
            OrderItem orderItem = new OrderItem(quantProduct, product);

            newOrder.addItem(orderItem);
        }

        System.out.println(newOrder);

        //finish program(postar no github para fazer analise de melhorias)
    }
}
