package com.example.foodiefaster.ordermodel;

public class orderlistmodel {
    int orderimage;

    public orderlistmodel(int orderimage, String orderprice, String orderfoodname, String orderdescription) {
        this.orderimage = orderimage;
        this.orderprice = orderprice;
        this.orderfoodname = orderfoodname;
        this.orderdescription = orderdescription;
    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrderfoodname() {
        return orderfoodname;
    }

    public void setOrderfoodname(String orderfoodname) {
        this.orderfoodname = orderfoodname;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    String orderprice;
    String orderfoodname;
    String orderdescription;


    public orderlistmodel(){}
}
