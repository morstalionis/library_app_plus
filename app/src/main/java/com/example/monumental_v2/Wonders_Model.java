package com.example.monumental_v2;

public class Wonders_Model {

    String wondersName;
    String wonder_details;
    String wonder_quotes;
    int wonderImage;

    public Wonders_Model(String wondersName, String wonder_details, String wonder_quotes, int wonderImage) {
        this.wondersName = wondersName;
        this.wonder_details = wonder_details;
        this.wonder_quotes = wonder_quotes;
        this.wonderImage = wonderImage;
    }

    public String getWondersName() {
        return wondersName;
    }

    public int getWonderImage() {
        return wonderImage;
    }

    public String getWonder_details() {
        return wonder_details;
    }

    public String getWonder_quotes() {
        return wonder_quotes;
    }
}
