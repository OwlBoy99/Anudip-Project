package com.rent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String propertyName;

    @Column(nullable = false)
    private String propertyType;

    private Double price; // Change from 'double' to 'Double'
    private String imageUrl;

    @Column(nullable = false)
    private String contactNumber;

    // Constructors, getters, setters, etc.

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Property(Long id, String propertyName, String propertyType, Double price, String imageUrl, String contactNumber) {
        super();
        this.id = id;
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.price = price;
        this.imageUrl = imageUrl;
        this.contactNumber = contactNumber;
    }

    public Property() {
        super();
    }

    @Override
    public String toString() {
        return "Property [id=" + id + ", propertyName=" + propertyName + ", propertyType=" + propertyType + ", price="
                + price + ", imageUrl=" + imageUrl + ", contactNumber=" + contactNumber + "]";
    }

    // Rest of the code remains unchanged
}
