package beans;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int productId;
    private String productName;
    private double price;
    private int quantity;

    public Cart() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Logic
    public double getTotal() {
        return price * quantity;
    }
}