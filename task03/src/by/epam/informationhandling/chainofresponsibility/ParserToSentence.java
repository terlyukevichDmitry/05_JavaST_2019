package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToSentence extends AbstractParser implements TextParser{

    private static final String SENTENCE_SPLIT_REGEX = ("[.!?]\\s*");


    private TextParser textParser;
    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(TextComposite wholeSentence, String paragraph) {

        textParser = new ParserToLexeme();
        ParserToSentence parserToSentence = new ParserToSentence();
        wholeSentence = parserToSentence.parse(paragraph, SENTENCE_SPLIT_REGEX,
                textParser, wholeSentence);
        //System.out.println("ParserToSentence = " + wholeSentence.getComponents().size());
        return wholeSentence;
    }
}
