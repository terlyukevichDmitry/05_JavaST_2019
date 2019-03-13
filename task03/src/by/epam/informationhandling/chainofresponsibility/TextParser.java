package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public interface TextParser {
    TextComposite getPars(TextComposite composite, String string);
}
