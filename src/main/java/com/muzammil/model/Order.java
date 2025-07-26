package com.muzammil.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "order_date")
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL ,
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<OrderItem>();

    @ManyToOne
    @JoinColumn(name = "address_id" , nullable = false)
    private Address shippingAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(name = "total_price" , nullable = false)
    private double totalPrice;

    @PrePersist
    protected void prePersist() {
        orderDate = LocalDate.now();
        this.totalPrice = items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }

    public Order() {
    }

    public Order(User user, OrderStatus status,Address shippingAddress) {
        this.user = user;
        this.status = status;
        this.shippingAddress = shippingAddress;

    }

    public Order(long id, User user, OrderStatus status, Address shippingAddress) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.shippingAddress = shippingAddress;
    }

    public Order(long id, User user, LocalDate orderDate,
                 List<OrderItem> items, Address shippingAddress,
                 OrderStatus status, double totalPrice) {
        this.id = id;
        this.user = user;
        this.orderDate = orderDate;
        this.items = items;
        this.shippingAddress = shippingAddress;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
