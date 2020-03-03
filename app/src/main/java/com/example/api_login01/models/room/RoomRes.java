package com.example.api_login01.models.room;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoomRes {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("rcode")
    @Expose
    private String rcode;
    @SerializedName("rname")
    @Expose
    private String rname;
    @SerializedName("rphoto")
    @Expose
    private String rphoto;
    @SerializedName("rprice")
    @Expose
    private String rprice;
    @SerializedName("rdiscount")
    @Expose
    private String rdiscount;
    @SerializedName("address")
    @Expose
    private String address;

    public RoomRes(Integer id, String rname, String rphoto, String rprice, String address) {
        this.id = id;
        this.rname = rname;
        this.rphoto = rphoto;
        this.rprice = rprice;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRphoto() {
        return rphoto;
    }

    public void setRphoto(String rphoto) {
        this.rphoto = rphoto;
    }

    public String getRprice() {
        return rprice;
    }

    public void setRprice(String rprice) {
        this.rprice = rprice;
    }

    public String getRdiscount() {
        return rdiscount;
    }

    public void setRdiscount(String rdiscount) {
        this.rdiscount = rdiscount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}