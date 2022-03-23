package io.tobias.palatinehuts.controller;

import io.tobias.palatinehuts.model.generic.Image;
import io.tobias.palatinehuts.repository.HutRepository;
import io.tobias.palatinehuts.services.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.UUID;


@RestController
@RequestMapping("/api/resources")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(value = "/{id}/{nr}")
    public ResponseEntity<byte[]> getImage(@PathVariable UUID id, @PathVariable int nr, HttpServletResponse response) throws IOException {
        final Image imageForHutByIdAndSerialNumber = imageService.getImageForHutByIdAndSerialNumber(id, nr);
        final File fileForImage = imageService.getFileForImage(imageForHutByIdAndSerialNumber);
        if (imageService.fileIsImage(fileForImage)) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(imageService.getMediaTypeForFile(fileForImage));
            InputStream is = new FileInputStream(fileForImage);
            return new ResponseEntity<byte[]>(is.readAllBytes(), responseHeaders, HttpStatus.OK);
        } else {
            return new ResponseEntity<byte[]>(HttpStatus.FORBIDDEN);
        }
    }

}
