package com.diekinari.demo.entities;

import lombok.NoArgsConstructor;

import java.util.List;


// wrapper class for second method
@NoArgsConstructor
public class PicturesList {
    public PicturesList(String name, List<String> picsList) {
        this.picsList = picsList;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPicsList() {
        return picsList;
    }

    public void setPicsList(List<String> picsList) {
        this.picsList = picsList;
    }

    private String name; // PathVariable String, instead of header parameter
    private List<String> picsList;

    public PicturesList(List<String> picsList) {
        this.picsList = picsList;
    }

    public PicturesList(String name){
        this.name = name;
    }

}
