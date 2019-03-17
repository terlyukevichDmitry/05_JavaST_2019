package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToSentence implements TextParser {

    private static final String SENTENCE_SPLIT_REGEX = ("[.!?]\\s*");


    private TextParser textParser;
    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(TextComposite wholeSentence, String paragraph) {

        textParser = new ParserToLexeme();
        for (String sentence : paragraph.split(SENTENCE_SPLIT_REGEX)) {

            TextComposite textComposite = new TextComposite();
            textComposite = textParser.parseText(textComposite, sentence.trim());
            textComposite.setStr(sentence);
            wholeSentence.addElement(textComposite);
        }
        //System.out.println("ParserToSentence = " + wholeSentence.getComponents().size());
        return wholeSentence;
    }
}
