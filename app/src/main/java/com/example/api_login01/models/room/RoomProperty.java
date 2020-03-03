package com.example.api_login01.models.room;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class RoomProperty {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sqfeet")
    @Expose
    private String sqfeet;
    @SerializedName("no_of_bed")
    @Expose
    private Integer noOfBed;
    @SerializedName("no_of_bathroom")
    @Expose
    private Integer noOfBathroom;
    @SerializedName("food")
    @Expose
    private Boolean food;
    @SerializedName("rules")
    @Expose
    private String rules;
    @SerializedName("capacity")
    @Expose
    private Integer capacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSqfeet() {
        return sqfeet;
    }

    public void setSqfeet(String sqfeet) {
        this.sqfeet = sqfeet;
    }

    public Integer getNoOfBed() {
        return noOfBed;
    }

    public void setNoOfBed(Integer noOfBed) {
        this.noOfBed = noOfBed;
    }

    public Integer getNoOfBathroom() {
        return noOfBathroom;
    }

    public void setNoOfBathroom(Integer noOfBathroom) {
        this.noOfBathroom = noOfBathroom;
    }

    public Boolean getFood() {
        return food;
    }

    public void setFood(Boolean food) {
        this.food = food;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

}