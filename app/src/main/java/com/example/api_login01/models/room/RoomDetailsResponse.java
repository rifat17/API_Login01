package com.example.api_login01.models.room;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoomDetailsResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("rhotel")
    @Expose
    private HotelResponse rhotel;
    @SerializedName("rProperty")
    @Expose
    private RoomProperty rProperty;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HotelResponse getRhotel() {
        return rhotel;
    }

    public void setRhotel(HotelResponse rhotel) {
        this.rhotel = rhotel;
    }

    public RoomProperty getRProperty() {
        return rProperty;
    }

    public void setRProperty(RoomProperty rProperty) {
        this.rProperty = rProperty;
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

}