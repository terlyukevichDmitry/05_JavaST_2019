package by.epam.site.entity;

import java.sql.Blob;
import java.util.Arrays;

public class Image extends Entity {
    private byte[] imageData;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageData=" + Arrays.toString(imageData) +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
