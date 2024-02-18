package db_objs;

public class DetailedOrderItem {
    private int orderNumber;
    private String orderDate;
    private String orderDetails;

    public DetailedOrderItem(int orderNumber, String orderDate, String orderDetails) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }

    // Getters
    public int getOrderNumber() {
        return orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    @Override
    public String toString() {
        return "Order Number: " + orderNumber + ", Date: " + orderDate + ", Details: " + orderDetails;
    }
}
