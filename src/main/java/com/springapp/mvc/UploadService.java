package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * Created by pi on 15. 1. 12.
 */
@Service
public class UploadService {

    private @Value("${upload.fileUploadPath}") String fileUploadPath;

    public String getFreeFilePath(String ... paths) {
        String path = this.fileUploadPath + "/";

        for (int i = 0; i < paths.length; ++i) {
            path += paths[i] + "/";
        }

        String randomPath = null;
        while (randomPath == null) {
            UUID randomUUID = UUID.randomUUID();
            File testPath = new File(path + randomUUID);
            if (testPath.exists() == false) {
                randomPath = testPath.getPath();

                testPath = new File(path);
                if (testPath.exists() == false) {
                    testPath.mkdirs();
                }
            }
        }
        return randomPath;
    }

    public String transferFile(CommonsMultipartFile upload, String originalFileName, String ... paths) {
        String filePath = getFreeFilePath(paths);

        File dest = new File(filePath + '_' + originalFileName);
        try {
            upload.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

}
