package io.tobias.palatinehuts.dtos;
import io.tobias.palatinehuts.json.HutDTOSerializer;
import io.tobias.palatinehuts.model.Hut;
import io.tobias.palatinehuts.model.generic.Image;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HutDTO {

    UUID id;
    String name;
    String place;
    double latitude;
    double longitude;
    String primaryImage;
    List<ImageDTO> images = new ArrayList<>();
    double price;
    double diameter;
    boolean active;


    public boolean isActive() {
        return active;
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


    public List<ImageDTO> getImages() {
        return images;
    }


    public void setImages(List<ImageDTO> images) {
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


    public HutDTO(Hut hut) {
        this.id = hut.getId();
        this.name=hut.getName();
        this.place=hut.getPlace();
        this.latitude=hut.getLatitude();
        this.longitude=hut.getLongitude();
        this.primaryImage=hut.getPrimaryImage();
        hut.getImages().forEach(img -> this.images.add(new ImageDTO(img)));
        this.price=hut.getPrice();
        this.diameter=hut.getDiameter();
        this.active=hut.isActive();
    }

}
