package eu.mrndeign.matned.data.mySql.entity;


import eu.mrndeign.matned.data.object.OrderObject;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "order_set")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Client sender;

    @ManyToOne
    @JoinColumn(name = "package_type_id")
    private PackageType packageType;

    @Column(name = "order_set_date")
    private Date orderSetDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE,CascadeType.DETACH})
    @JoinTable(name = "product_order_connection", joinColumns = @JoinColumn (name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderId", cascade = CascadeType.ALL)
    private List<PackedPallet> pallets;



    public Order() {
    }

    public Order(Client client, Client sender, PackageType packageType) {
        this.packageType =packageType;
        this.client = client;
        this.sender = sender;
        this.orderSetDate = new Date (System.currentTimeMillis());
    }

    public Order(Client client, Client sender, int numberOfDaysAhead, PackageType packageType) {
        this.packageType =packageType;
        this.client = client;
        this.sender = sender;
        this.orderSetDate = new Date (System.currentTimeMillis()+(86400000*numberOfDaysAhead));
        // 86400000‬ is a number of milisecconds in 1 day
    }

    public Order(Client client, Client sender, Date orderSetDate, PackageType packageType) {
        this.packageType =packageType;
        this.client = client;
        this.sender = sender;
        this.orderSetDate = orderSetDate;
    }

    public void addProduct(Product product){
        if(products == null) products = new LinkedList<>();
        products.add(product);
    }

    public void addPallet(PackedPallet pallet){
        if(pallets == null) pallets = new LinkedList<>();
        pallets.add(pallet);
    }

    public void addProducts(List<Product> products){
        if(this.products == null) this.products = new LinkedList<>();
        this.products.addAll(products);
    }

    public void addPallets(List<PackedPallet> pallets){
        if(this.pallets == null) this.pallets = new LinkedList<>();
        this.pallets.addAll(pallets);
    }

    private void generatePallet(){
        OrderObject orderObject = new OrderObject(this);
    }

    public PackageType getPackageType() {
        return packageType;
    }
    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public List<PackedPallet> getPallets() {
        return pallets;
    }
    public void setPallets(List<PackedPallet> pallets) {
        this.pallets = pallets;
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Client getSender() {
        return sender;
    }
    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Date getOrderSetDate() {
        return orderSetDate;
    }
    public void setOrderSetDate(Date orderSetDate) {
        this.orderSetDate = orderSetDate;
    }

    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getOrderWeight(){
        if(products != null){
            int count = 0;
            for (Product el: products) {
                count += el.getProductDetails().getWeight();
            }
            for (PackedPallet el: pallets) {
                count += el.getPackageTypeId().getWeight();
            }
            return count;
        }
        return 0;
    }

    public int getOrderHeight() {
        return 0;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", client=" + client +
                ", sender=" + sender +
                ", orderSetDate=" + orderSetDate +
                ", products no =" + products.size() +
                '}';
    }
}
