package eu.mrndeign.matned.data.mySql.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="client_id")
    private int clientId;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> ordersSent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Order> ordersReceiver;

    public Client() {
    }

    public Client(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public void sendOrder(Order order){
        if(ordersSent == null) ordersSent = new LinkedList<Order>();
        ordersSent.add(order);
    }

    public void receiveOrder(Order order){
        if(ordersReceiver == null) ordersReceiver = new LinkedList<Order>();
        ordersReceiver.add(order);
    }

    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public List<Order> getOrdersSent() {
        return ordersSent;
    }
    public void setOrdersSent(List<Order> ordersSent) {
        this.ordersSent = ordersSent;
    }

    public List<Order> getOrdersReceiver() {
        return ordersReceiver;
    }
    public void setOrdersReceiver(List<Order> ordersReceiver) {
        this.ordersReceiver = ordersReceiver;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
