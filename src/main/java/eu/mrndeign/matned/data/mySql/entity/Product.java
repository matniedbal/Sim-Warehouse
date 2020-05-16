package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int productId;

    @Column(name="name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="product_details_id")
    private ProductDetails productDetails;

    @Column(name="value")
    private int value;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE,CascadeType.DETACH})
    @JoinTable(name = "product_order_connection", joinColumns = @JoinColumn (name = "product_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    public Product() {
    }

    public Product(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }
    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
