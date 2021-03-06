package by.epam.site.validation;

import by.epam.site.entity.Image;
import by.epam.site.exception.IncorrectDataException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Objects;

public class ImageValidator implements Validator<Image> {

    private static final String PARAM_FILE_LOADER = "fileLoader";

    @Override
    public Image validate(HttpServletRequest request) throws IncorrectDataException, IOException, ServletException {

        Image image = new Image();

        Part part = request.getPart(PARAM_FILE_LOADER);
        String fileName = transferTo(part, request);
        if(fileName != null && !fileName.isEmpty()) {
            image.setFilePath("images/" + fileName);
        } else {
            throw new IncorrectDataException(PARAM_FILE_LOADER, fileName);
        }

        return image;
    }

    private String transferTo(final Part part,
                              final HttpServletRequest request)
            throws IOException {
        String fileName= Paths.get(
                part.getSubmittedFileName()).getFileName().toString();
        String absolutePath = request.getServletContext().getRealPath("");
        String[] strings = absolutePath.split("\\\\");
        StringBuilder builder = new StringBuilder();
        for (int  i = 0; i < strings.length - 3; i++) {
            builder.append(strings[i]);
            builder.append("/");
        }

        String newFilePath = absolutePath + "images/" + fileName;

        InputStream inputStream = part.getInputStream();
        OutputStream outputStream = new FileOutputStream(newFilePath);
        Objects.requireNonNull(outputStream, "out");
        byte[] buffer = new byte[8192];
        int read;
        while ((read = inputStream.read(buffer, 0, 8192)) >= 0) {
            outputStream.write(buffer, 0, read);
        }
        inputStream.close();
        outputStream.close();
        return fileName;
    }
}
