package by.epam.site.validation;

import by.epam.site.entity.Entity;
import by.epam.site.exception.IncorrectDataException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface Validator<Type extends Entity> {
    Type validate(HttpServletRequest request) throws IncorrectDataException, IOException, ServletException;
}
