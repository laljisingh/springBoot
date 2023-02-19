package com.laljisingh.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @Column(name = "order_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;
    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product productId;
    @JoinColumn(name = "address_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private  Address addressId;
    @Column(name = "product_Quantity")
    private Integer productQuantity;

    public Integer getOrderID() {
        return orderId;
    }

    public void setOrderID(Integer orderID) {
        this.orderId = orderID;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Order() {
    }

    public Order(Integer orderId, User userId, Product productId, Address addressId, Integer productQuantity) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.addressId = addressId;
        this.productQuantity = productQuantity;
    }
}
