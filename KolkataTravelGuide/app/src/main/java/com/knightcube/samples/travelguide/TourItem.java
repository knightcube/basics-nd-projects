package com.knightcube.samples.travelguide;

public class TourItem {

    String name;
    String address;
    int imageId;
    String description;

    public TourItem(String name, String address, int imageId, String description) {
        this.name = name;
        this.address = address;
        this.imageId = imageId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
