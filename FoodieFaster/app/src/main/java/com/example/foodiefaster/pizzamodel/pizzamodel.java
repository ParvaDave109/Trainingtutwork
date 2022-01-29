package com.example.foodiefaster.pizzamodel;

public class pizzamodel {
    int pic;
    String pizza_name;
    String pizza_price;
    String description;


    public pizzamodel(int pic, String pizza_name, String pizza_price, String description) {
        this.pic = pic;
        this.pizza_name = pizza_name;
        this.pizza_price = pizza_price;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public pizzamodel(int pic, String pizza_name, String pizza_price) {
        this.pic = pic;
        this.pizza_name = pizza_name;
        this.pizza_price = pizza_price;
    }


    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getPizza_name() {
        return pizza_name;
    }

    public void setPizza_name(String pizza_name) {
        this.pizza_name = pizza_name;
    }

    public String getPizza_price() {
        return pizza_price;
    }

    public void setPizza_price(String pizza_price) {
        this.pizza_price = pizza_price;
    }
}
