package com.JC.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("houses")
public class HouseEntity {
    
    @Id
    Long id;

    @Column("nameOfProperty")
    String productName;

    @Column("location")
    String location;

    @Column("squareFeet")
    int squareFeet;

    @Column("dateOfConstruction")
    String dateOfConstruction;

    @Column("photoFileName")
    String photoFileName;

    @Column("description")
    String description;

    @Column("value")
    Double value;
    
    public HouseEntity() {
    }

    public HouseEntity(Long id, String nameOfProperty, String location, int squareFeet, String dateOfConstruction,
            String photoFileName, String description, Double value) {
        this.id = id;
        this.productName = nameOfProperty;
        this.location = location;
        this.squareFeet = squareFeet;
        this.dateOfConstruction = dateOfConstruction;
        this.photoFileName = photoFileName;
        this.description = description;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public String getDateOfConstruction() {
        return dateOfConstruction;
    }

    public void setDateOfConstruction(String dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    
}
