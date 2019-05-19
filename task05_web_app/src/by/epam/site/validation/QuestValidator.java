package by.epam.site.validation;

import by.epam.site.entity.Quest;
import by.epam.site.exception.IncorrectDataException;

import javax.servlet.http.HttpServletRequest;

public class QuestValidator implements Validator<Quest> {

    private static final String PARAM_TITLE = "title";
    private static final String PARAM_LEVEL = "level";
    private static final String PARAM_PEOPLE = "maxOfPeople";
    private static final String PARAM_DESCRIPTION = "description";
    private static final String REGEX = "\\d+";

    @Override
    public Quest validate(HttpServletRequest request)
            throws IncorrectDataException {

        Quest quest = new Quest();

        String title = request.getParameter(PARAM_TITLE);
        if(title != null && !title.isEmpty()) {
            quest.setTitle(title);
        } else {
            throw new IncorrectDataException(PARAM_TITLE, title);
        }

        String level = request.getParameter(PARAM_LEVEL);
        if(level != null && !level.isEmpty() && level.matches(REGEX)) {
            quest.setLevel(Integer.parseInt(level));
        } else {
            throw new IncorrectDataException(PARAM_TITLE, level);
        }

        String maxOfPeople = request.getParameter(PARAM_PEOPLE);
        if(maxOfPeople != null && !maxOfPeople.isEmpty()
                && maxOfPeople.matches(REGEX)) {
            quest.setMaxPeople(Integer.parseInt(maxOfPeople));
        } else {
            throw new IncorrectDataException(PARAM_PEOPLE, maxOfPeople);
        }

        String description = request.getParameter(PARAM_DESCRIPTION);
        if(description != null && !description.isEmpty()) {
            quest.setDescription(description);
        } else {
            throw new IncorrectDataException(PARAM_DESCRIPTION, description);
        }

        return quest;
    }
}
