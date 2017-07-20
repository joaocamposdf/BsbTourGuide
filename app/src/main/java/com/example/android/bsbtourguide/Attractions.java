package com.example.android.bsbtourguide;

/**
 * Created by Note on 16/07/2017.
 */

public class Attractions {
    private String name;
    private String location;
    private int image;

    public Attractions(String name, String location, int image) {
        this.name = name;
        this.location = location;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getImage() {
        return image;
    }
}
