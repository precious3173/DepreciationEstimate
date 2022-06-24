package com.example.depreciationrateestimator;

public class ConversionArray {

String text;
int image;

public ConversionArray(String text, int image){

    this.image= image;
    this.text = text;
}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
