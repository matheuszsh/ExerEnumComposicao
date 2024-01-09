package entities;

import entities.enumEntities.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    StringBuilder builder = new StringBuilder();

    private Date moment;
    private OrderStatus status;

    private Client client;
    private static List<OrderItem> orderItemList = new ArrayList<>();
    private String orderItemsLog;

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem orderItem){
        orderItemList.add(orderItem);
    }

    public void makeItemsOrder(){
        for(OrderItem item : orderItemList){
            builder.append(item);
        }
        this.orderItemsLog = builder.toString();
    }

    public String getOrderItemsLog() {
        makeItemsOrder();

        return orderItemsLog;
    }

    public void setOrderItemsLog(String orderItemsLog) {
        this.orderItemsLog = orderItemsLog;
    }

    public Double total(){
        double total = 0;
        for (OrderItem item : orderItemList) {
            total += item.subTotal();
        }
        return total;
    }


    @Override
    public String toString() {
        return "Order moment: " + getMoment() + "\n" +
                "Order status: " + getStatus() + "\n" +
                getClient() + "\n" +
                "Order items:" + "\n" +
                getOrderItemsLog() + "\n" +
                "Total price: " + total();

    }
}
