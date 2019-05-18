package by.epam.site.validation;

import by.epam.site.entity.Client;
import by.epam.site.exception.IncorrectDataException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientValidator implements Validator<Client> {

    private static final String PARAM_NAME = "name";
    private static final String PARAM_SURNAME = "surname";
    private static final String PARAM_PATRONYMIC = "patronymic";
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_PHONE = "phone";
    private static final String PARAM_DATE_OF_BIRTH = "dateOfBirth";
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String REGEX = "\\d+";

    @Override
    public Client validate(final HttpServletRequest request)
            throws IncorrectDataException {
        Client client = new Client();

        String name = request.getParameter(PARAM_NAME);
        if(name != null && !name.isEmpty()) {
            client.setName(name);
        } else {
            throw new IncorrectDataException(PARAM_NAME, name);
        }

        String surname = request.getParameter(PARAM_SURNAME);
        if(surname != null && !surname.isEmpty()) {
            client.setSurname(surname);
        } else {
            throw new IncorrectDataException(PARAM_SURNAME, surname);
        }

        String patronymic = request.getParameter(PARAM_PATRONYMIC);
        if(patronymic != null && !patronymic.isEmpty()) {
            client.setPatronymic(patronymic);
        } else {
            throw new IncorrectDataException(PARAM_PATRONYMIC, patronymic);
        }

        String email = request.getParameter(PARAM_EMAIL);
        if(email != null && !email.isEmpty()) {
            client.setEmail(email);
        } else {
            throw new IncorrectDataException(PARAM_EMAIL, email);
        }

        String phone = request.getParameter(PARAM_PHONE);
        if(phone != null && !phone.isEmpty() && phone.matches(REGEX)) {
            client.setPhone(surname);
        } else {
            throw new IncorrectDataException(PARAM_PHONE, phone);
        }

        String dateOfBirth = request.getParameter(PARAM_DATE_OF_BIRTH);
        try {
            DateTimeFormatter newYorkDateFormatter
                    = DateTimeFormatter.ofPattern(YYYY_MM_DD);
            LocalDate localDate = LocalDate.from(newYorkDateFormatter.parse(
                    dateOfBirth));
            client.setDateOfBirth(localDate);
        } catch(NumberFormatException e) {
            throw new IncorrectDataException(PARAM_DATE_OF_BIRTH, dateOfBirth);
        }

        return client;
    }
}
