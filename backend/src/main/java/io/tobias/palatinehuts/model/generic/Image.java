package io.tobias.palatinehuts.model.generic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;


@Entity
public class Image {

    @Id
    @GeneratedValue
    UUID id;
    int serialNumber;
    String  path;
    String  downloadPath;
    boolean isPrimaryImage;
    boolean isReviewed = false;


    public boolean isReviewed() {
        return isReviewed;
    }


    public void setReviewed(boolean reviewed) {
        isReviewed = reviewed;
    }


    public Image(String path) {
        this.path = path;
    }



    public Image() {
    }


    public int getSerialNumber() {
        return serialNumber;
    }


    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }


    public boolean isPrimaryImage() {
        return isPrimaryImage;
    }


    public void setPrimaryImage(boolean primaryImage) {
        isPrimaryImage = primaryImage;
    }


    public String getDownloadPath() {
        return downloadPath;
    }


    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getPath() {
        return path;
    }


    public void setPath(String path) {
        this.path = path;
    }
}
