package com.example.drop;

public class Cards {

    private String tankID;
    private String address;
    private int levelImage;
    private String status;

    public Cards(String tankID, String address, int levelImage, String status) {
        this.tankID = tankID;
        this.address = address;
        this.levelImage = levelImage;
        this.status = status;
    }

    public String getTankID() {
        return tankID;
    }

    public String getAddress() {
        return address;
    }

    public int getLevelImage() {
        return levelImage;
    }

    public String getStatus() {
        return status;
    }
}
