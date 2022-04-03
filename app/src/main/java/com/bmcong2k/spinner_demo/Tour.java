package com.bmcong2k.spinner_demo;

public class Tour {
    private int img;
    private String ten, sogio;

    public Tour() {
    }

    public Tour(int img, String ten, String sogio) {
        this.img = img;
        this.ten = ten;
        this.sogio = sogio;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSogio() {
        return sogio;
    }

    public void setSogio(String sogio) {
        this.sogio = sogio;
    }
}
