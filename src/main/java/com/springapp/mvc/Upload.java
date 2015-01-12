package com.springapp.mvc;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by pi on 15. 1. 12.
 */
public class Upload {

    private CommonsMultipartFile file;

    private String path;

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "file=" + file +
                ", path='" + path + '\'' +
                '}';
    }
}
