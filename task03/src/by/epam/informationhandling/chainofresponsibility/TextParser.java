package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public interface TextParser {
    TextComposite parseText(TextComposite composite, String string, TextElementType textElementType) throws IncorrectDataException;
}
