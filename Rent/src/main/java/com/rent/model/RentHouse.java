package com.rent.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RentHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String propertyType;

    private Double rentPrice;
    private Integer numberOfTenants;
    private String imageUrl;

    @Column(nullable = false)
    private String contactNumber;
    // Constructors, getters, setters, etc.

    public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Integer getNumberOfTenants() {
        return numberOfTenants;
    }

    public void setNumberOfTenants(Integer numberOfTenants) {
        this.numberOfTenants = numberOfTenants;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

	

	@Override
	public String toString() {
		return "RentHouse [id=" + id + ", propertyType=" + propertyType + ", rentPrice=" + rentPrice
				+ ", numberOfTenants=" + numberOfTenants + ", imageUrl=" + imageUrl + ", contactNumber=" + contactNumber
				+ "]";
	}

	public RentHouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RentHouse(Long id, String propertyType, Double rentPrice, Integer numberOfTenants, String imageUrl,
			String contactNumber) {
		super();
		this.id = id;
		this.propertyType = propertyType;
		this.rentPrice = rentPrice;
		this.numberOfTenants = numberOfTenants;
		this.imageUrl = imageUrl;
		this.contactNumber = contactNumber;
	}

	

    // Constructors, getters, setters, etc.
}
