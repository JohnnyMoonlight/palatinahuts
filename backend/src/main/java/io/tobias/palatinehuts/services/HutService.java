package io.tobias.palatinehuts.services;
import io.tobias.palatinehuts.model.Hut;
import io.tobias.palatinehuts.repository.HutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.HashSet;
import java.util.Set;


@Service
public class HutService {

    private final static String IMAGE_SUB_DIRECTORY     = "img";
    private final static String RESOURCES_SUB_DIRECTORY = "resources";
    private final static String ABSOLUTE_PATH_DENOTION  = "";
    final                char   separatorChar           = File.separatorChar;

    @Autowired
    HutRepository hutRepository;


    File getFolderForHut(Hut hut) {
        final String id = hut.getId().toString();
        File workingDirectory = new File(ABSOLUTE_PATH_DENOTION);
        StringBuilder sb = new StringBuilder();
        sb.append(ABSOLUTE_PATH_DENOTION).append(separatorChar).append(RESOURCES_SUB_DIRECTORY).append(separatorChar).append(IMAGE_SUB_DIRECTORY).append(separatorChar).append(id).append(separatorChar);
        File folderForHut = new File(workingDirectory.getAbsoluteFile(), sb.toString());
        return folderForHut;
    }


    public Set<File> getFilesForHut(Hut hut) {
        final File folderForHut = getFolderForHut(hut);
        Set<File> files = new HashSet<>();

        for (File f : folderForHut.listFiles()) {
            files.add(f);
        }
        return files;
    }

}
