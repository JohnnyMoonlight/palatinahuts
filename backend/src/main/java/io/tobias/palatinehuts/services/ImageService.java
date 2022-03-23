package io.tobias.palatinehuts.services;
import io.tobias.palatinehuts.model.Hut;
import io.tobias.palatinehuts.model.generic.Image;
import io.tobias.palatinehuts.repository.HutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;


@Service
public class ImageService {
    public static final String IMAGE = "image";
    final char separatorChar = File.separatorChar;

    HutService hutService = new HutService();
    @Autowired
    HutRepository hutRepository;


    private String createFileNameForImage(MultipartFile img, Hut hut) {
        final String fileName = img.getOriginalFilename();
        final int indexOfFileTypeSeparator = fileName.lastIndexOf(".");
        final String fileTypeEnding = fileName.substring(indexOfFileTypeSeparator);
        long date = new Date().getTime();
        return hutService.getFolderForHut(hut).getAbsolutePath() + separatorChar + date + fileTypeEnding;
    }


    public void saveImageForHut(MultipartFile img, Hut hut) {
        File newFile = new File(createFileNameForImage(img, hut));
        try {
            img.transferTo(newFile);
            Integer imageId = getIdForNextImageForHut(hut);
            String downloadPathForImage = "/api/resources/" + hut.getId() + "/" + imageId.toString();
            Image newImage = new Image(newFile.getAbsolutePath());
            newImage.setDownloadPath(downloadPathForImage);
            newImage.setSerialNumber(imageId);
            hut.getImages().add(newImage);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public File createImageDirectoryForHut(Hut hut) {
        final File folderForHut = hutService.getFolderForHut(hut);
        folderForHut.mkdirs();
        return folderForHut;
    }


    public Integer getIdForNextImageForHut(Hut hut) {
        final Hut byId = hutRepository.findById(hut.getId()).get();
        return byId.getImages().size() + 1;
    }


    public Image getImageForHutByIdAndSerialNumber(UUID id, int nr) {
        final Optional<Hut> byId = hutRepository.findById(id);
        if (byId.isPresent()) {
            Hut hut = byId.get();
            for (Image img : hut.getImages()) {
                if (img.getSerialNumber() == nr) {
                    return img;
                }
            }
        }
        return null;
    }

    public File getFileForImage(Image img) {
        File file = new File(img.getPath());
        if (file.exists()) {
            return file;
        } else {
            return null;
        }
    }

    public String getMimeType(File file) {
        FileNameMap map = URLConnection.getFileNameMap();
        return map.getContentTypeFor(file.getName());
    }

    public boolean fileIsImage(File file) {
        return getMediaTypeForFile(file).getType().equals(IMAGE);
    }

    public MediaType getMediaTypeForFile(File file){
        final String mimeType = getMimeType(file);
        return new MediaType(mimeType.substring(0,mimeType.lastIndexOf("/")) , mimeType.substring(mimeType.lastIndexOf("/")+1));
    }
}