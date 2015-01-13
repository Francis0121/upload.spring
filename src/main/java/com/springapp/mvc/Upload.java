package com.springapp.mvc;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by pi on 15. 1. 12.
 */
public class Upload {

    private CommonsMultipartFile file;

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "file=" + file +
                '}';
    }
}
