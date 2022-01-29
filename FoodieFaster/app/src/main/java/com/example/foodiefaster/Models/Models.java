package com.example.foodiefaster.Models;

public class Models {
    int pic;
    String text;
    String description;

    public Models(int pic, String text, String description) {
        this.pic = pic;
        this.text = text;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Models(int pic, String text) {
        this.pic = pic;
        this.text = text;
    }


    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
