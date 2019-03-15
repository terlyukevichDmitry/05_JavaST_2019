package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public interface TextParser {
    TextComposite parseText(TextComposite composite, String string);
}
