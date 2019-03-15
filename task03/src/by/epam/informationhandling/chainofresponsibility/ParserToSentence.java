package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.Leaf;
import by.epam.informationhandling.entity.TextComposite;

public class ParserToSentence implements TextParser {

    private static final String SENTENCE_SPLIT_REGEX = ("[.!?]\\s*");


    private TextParser textParser;
    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(TextComposite composite, String paragraph) {

        for (String sentence : paragraph.split(SENTENCE_SPLIT_REGEX)) {

            TextComposite compositeHelper = new TextComposite();
            compositeHelper.addElement(new Leaf(sentence.trim()));
            textParser = new ParserToLexeme();
            TextComposite textComposite =
                    textParser.parseText(compositeHelper, sentence.trim());
            composite.addElement(textComposite);
        }
        return composite;
    }
}
