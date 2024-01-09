package entities;

public class OrderItem {
    private Integer quantity;
    private Double subTotal;

    private Product product;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.subTotal = subTotal();
    }

    @Override
    public String toString() {
        return product.getName() + "," + " $" + product.getPrice() + "," +
                " Quantity: " + getQuantity() + "," +
                " Subtotal: " + getSubTotal() + "\n";
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public Double subTotal(){
        return quantity * product.getPrice();
    }
}
