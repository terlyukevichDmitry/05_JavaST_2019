package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.Leaf;
import by.epam.informationhandling.entity.TextComposite;

public class ParserToLexeme implements TextParser {

    private static final String LEXEME_SPLIT_REGEX = "[\\s\\n]";

    private TextParser textParser;

    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(TextComposite composite,
                                   String sentence) {
        for (String lexeme : sentence.split(LEXEME_SPLIT_REGEX)) {
            TextComposite textComposite = new TextComposite();
            TextComposite compositeHelper = new TextComposite();
            compositeHelper.addElement(new Leaf(lexeme.trim()));
            textComposite.addElement(compositeHelper);
            composite.addElement(textComposite);
        }
        return composite;
    }
}
