package com.JC.model;

public class HouseModel {
    long id;
    String nameOfProperty;
    String location;
    Integer squareFeet;
    String dateOfConstruction;
    String photoFileName;
    String description;
    Double value;
    
    
    public HouseModel(long id, String nameOfProperty, String location, Integer squareFeet, String dateOfConstruction,
            String photoFileName, String description, Double value) 
            {
        super();
        this.id = id;
        this.nameOfProperty = nameOfProperty;
        this.location = location;
        this.squareFeet = squareFeet;
        this.dateOfConstruction = dateOfConstruction;
        this.photoFileName = photoFileName;
        this.description = description;
        this.value = value;
    }

    public HouseModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfProperty() {
        return nameOfProperty;
    }
    public void setNameOfProperty(String nameOfProperty) {
        this.nameOfProperty = nameOfProperty;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Integer getSquareFeet() {
        return squareFeet;
    }
    public void setSquareFeet(Integer squareFeet) {
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

    @Override
    public String toString() {
        return "HouseModel [nameOfProperty=" + nameOfProperty + ", location=" + location + ", squareFeet=" + squareFeet
                + ", dateOfConstruction=" + dateOfConstruction + ", photoFileName=" + photoFileName + ", description="
                + description + ", value=" + value + "]";
    }

}
