package com.shrihari.Alien;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Cacheable
public class Laptop {
    @Id
    private int lid;
    private String Brand;
    private String Model;
    private int Ram;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getRam() {
        return Ram;
    }

    public void setRam(int ram) {
        Ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", Ram=" + Ram +
                '}';
    }
}
