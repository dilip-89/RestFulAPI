package org.restfulapi.getListOfObjectdeserialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class data {
    public String color;
    public String Capacity;
    @JsonProperty("capacity GB")
    public Integer capacity_GB;
    public double price;
    @SerializedName("Screen size")
    public double screenSize;

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacity() {
        return Capacity;
    }
    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
    }

    public Integer getCapacityGB() {
        return capacity_GB;
    }
    public void setCapacityGB(Integer capacity_GB) {
        this.capacity_GB = capacity_GB;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getScreen_size() {
        return screenSize;
    }
    public void setScreen_size(double screenSize) {
        this.screenSize = screenSize;
    }
}
