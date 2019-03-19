package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

public interface TextParser {
    TextComposite parseText(TextComposite composite, String string, TextElementType textElementType);
}
