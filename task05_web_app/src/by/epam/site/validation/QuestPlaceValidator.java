package by.epam.site.validation;

import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.IncorrectDataException;

import javax.servlet.http.HttpServletRequest;

public class QuestPlaceValidator implements Validator<QuestPlace> {

    private static final String PARAM_PLACE_NAME = "placeName";
    private static final String PARAM_ADDRESS_NAME = "addressName";
    private static final String PARAM_PHONE_NUMBER = "phoneNumber";
    private static final String REGEX = "\\d+";

    @Override
    public QuestPlace validate(HttpServletRequest request)
            throws IncorrectDataException {

        QuestPlace questPlace = new QuestPlace();

        String placeName = request.getParameter(PARAM_PLACE_NAME);
        if(placeName != null && !placeName.isEmpty()) {
            questPlace.setName(placeName);
        } else {
            throw new IncorrectDataException(PARAM_PLACE_NAME, placeName);
        }

        String address = request.getParameter(PARAM_ADDRESS_NAME);
        if(address != null && !address.isEmpty()) {
            questPlace.setAddress(address);
        } else {
            throw new IncorrectDataException(PARAM_ADDRESS_NAME, address);
        }

        String phoneNumber = request.getParameter(PARAM_PHONE_NUMBER);
        if(phoneNumber != null && !phoneNumber.isEmpty()
        && phoneNumber.matches(REGEX)) {
            questPlace.setPhone(phoneNumber);
        } else {
            throw new IncorrectDataException(PARAM_PHONE_NUMBER, phoneNumber);
        }
        return questPlace;
    }
}
