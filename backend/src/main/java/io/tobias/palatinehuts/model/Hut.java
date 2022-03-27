package io.tobias.palatinehuts.model;
import io.tobias.palatinehuts.model.generic.Image;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
public class Hut {
    @Id
    @GeneratedValue
    UUID id;
    String name;

    String place;
    double latitude;
    double longitude;
    String primaryImage;
    @OneToMany
    @Cascade(CascadeType.ALL)
    List<Image> images = new ArrayList<>();
    double  price;
    double  diameter;
    boolean active;
    boolean playground;


    public Hut() {

    }
    public Hut(UUID id, String name, String place, double latitude, double longitude, String primaryImage, List<Image> images, double price, double diameter) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.latitude = latitude;
        this.longitude = longitude;
        this.primaryImage = primaryImage;
        this.images = images;
        this.price = price;
        this.diameter = diameter;
    }


    public boolean isPlayground() {
        return playground;
    }


    public void setPlayground(boolean playground) {
        this.playground = playground;
    }


    public boolean isActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPlace() {
        return place;
    }


    public void setPlace(String place) {
        this.place = place;
    }


    public double getLatitude() {
        return latitude;
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public double getLongitude() {
        return longitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getPrimaryImage() {
        return primaryImage;
    }


    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }


    public List<Image> getImages() {
        return images;
    }


    public void setImages(List<Image> images) {
        this.images = images;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public double getDiameter() {
        return diameter;
    }


    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }


    public boolean isValid() {
        return this.name != null && place != null;
    }
}
