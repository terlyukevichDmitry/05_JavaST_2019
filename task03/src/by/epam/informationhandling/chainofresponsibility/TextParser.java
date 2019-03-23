package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

/**
 * Interface for parse text on components.
 */
public interface TextParser {
    /**
     * Method for parse text.
     * @param composite object.
     * @param string string to parse text.
     * @param textElementType type in text.
     * @return entity.
     * @throws IncorrectDataException for checking exception moments.
     */
    TextComposite parseText(TextComposite composite, String string,
                            TextElementType textElementType)
            throws IncorrectDataException;
}
