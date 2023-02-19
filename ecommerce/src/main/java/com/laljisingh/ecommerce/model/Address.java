package com.laljisingh.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "address_table")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "address_name")
    private String addressName;
    @Column(name = "address_landmark")
    private String landMark;
    @Column(name = "address_phoneNumber")
    private String phoneNumber;
    @Column(name = "address_zipcode")
    private String zipcode;
    @Column(name = "address_state")
    private String state;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Address() {
    }

    public Address(Integer addressId, String addressName, String landMark, String phoneNumber, String zipcode, String state, User userId) {
        this.addressId = addressId;
        this.addressName = addressName;
        this.landMark = landMark;
        this.phoneNumber = phoneNumber;
        this.zipcode = zipcode;
        this.state = state;
        this.userId = userId;
    }
}
