package io.tobias.palatinehuts.dtos;
import io.tobias.palatinehuts.model.generic.Image;


public class ImageDTO {
    String  downloadPath;
    boolean isPrimary;
    boolean isReviewed;


    public boolean isReviewed() {
        return isReviewed;
    }


    public ImageDTO() {
    }


    ImageDTO(Image image) {
        this.downloadPath = image.getDownloadPath();
        this.isPrimary = image.isPrimaryImage();
        this.isReviewed = image.isReviewed();
    }


    public boolean isPrimary() {
        return isPrimary;
    }


    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }


    public String getDownloadPath() {
        return downloadPath;
    }


    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }
}
