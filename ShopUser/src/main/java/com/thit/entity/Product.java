package com.thit.entity;

/**
 * @author :huyiju
 * @date :2020-04-09 17:23
 */
public class Product {

    private int pid;
    private String pname;//商品名字

    private Double pprice;//商品价格

    private String stock;//库存

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
