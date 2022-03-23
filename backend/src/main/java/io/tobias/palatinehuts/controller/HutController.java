package io.tobias.palatinehuts.controller;
import io.tobias.palatinehuts.dtos.HutDTO;
import io.tobias.palatinehuts.model.Hut;
import io.tobias.palatinehuts.repository.HutRepository;
import io.tobias.palatinehuts.services.HutService;
import io.tobias.palatinehuts.services.ImageService;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class HutController {

    @Autowired
    HutRepository repository;

    @Autowired
    HutService   hutService;
    @Autowired
    ImageService imageService;


    @PostMapping("/hut")
    public ResponseEntity<?> createHut(@RequestParam("hut") String string, @RequestParam(value = "image",required = false) MultipartFile[] images) {
        Gson gson = new Gson();
        final Hut hut = gson.fromJson(string, Hut.class);
        if (!hut.isValid()) {
            return ResponseEntity.badRequest().body("Hut not valid ");
        } if (!hutNotExistsInDatabase(hut)) {
            return ResponseEntity.badRequest().body("Hut already exists in database");
        }
        else {
            final Hut savedHut = repository.save(hut);
            imageService.createImageDirectoryForHut(hut);
            if (images!=null && images.length>0) {
                for (MultipartFile img : images) {
                    try {
                        imageService.saveImageForHut(img, savedHut);
                        repository.save(savedHut);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        //ToDo:proper error message
                        return new ResponseEntity<Hut>(hut, HttpStatus.BAD_REQUEST);
                    }
                }
            }
            return new ResponseEntity<HutDTO>(new HutDTO(savedHut), HttpStatus.CREATED);
        }

    }


    @GetMapping("/hut")
    List<HutDTO> getAllHuts() {
        final List<Hut> all = repository.findAll();
        List<HutDTO> huts = new ArrayList<>();
        all.forEach(h -> huts.add(new HutDTO(h)));
        return huts;
    }


    private boolean hutNotExistsInDatabase(Hut hut) {
        final List<Hut> byName = repository.findByName(hut.getName());
        return byName.isEmpty();
    }

}
