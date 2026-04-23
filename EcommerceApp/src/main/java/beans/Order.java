package beans;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int userId;
    private double totalAmount;

    public Order() {}

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}