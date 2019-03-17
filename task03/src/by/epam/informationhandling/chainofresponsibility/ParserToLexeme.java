package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.Leaf;
import by.epam.informationhandling.entity.TextComposite;

import java.util.ArrayList;

public class ParserToLexeme implements TextParser {

    private static final String LEXEME_SPLIT_REGEX = "[\\s\\n]+";

    private static final String WORD_SPLIT_REGEX =  "[a-zA-Z]+";

    private static final String EXPRESSION_SPLIT_REGEX = "[^a-zA-Z]+";

    private TextParser textParser;

    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(TextComposite wholeLexeme,
                                   String sentence) {

        TextComposite compositesOfWord = new TextComposite();
        TextComposite compositesOfMark= new TextComposite();
        TextComposite compositesOfExpression = new TextComposite();

        for (String lexeme : sentence.split(LEXEME_SPLIT_REGEX)) {
            if (lexeme.matches(WORD_SPLIT_REGEX)) {
                textParser = new ParserToSymbol();
                TextComposite compositeHelper = new TextComposite();
                compositeHelper = textParser.parseText(compositeHelper,
                        lexeme.trim());
                compositeHelper.setStr(lexeme);
                compositesOfWord.addElement(compositeHelper);

            } else if (lexeme.matches(EXPRESSION_SPLIT_REGEX)) {
//                textParser = new ParserToExpression();
                TextComposite compositeHelper = new TextComposite();
//                compositeHelper = textParser.parseText(compositeHelper,
//                        lexeme.trim());
                compositeHelper.setStr(lexeme);
                compositesOfExpression.addElement(compositeHelper);
            } else {
                textParser = new ParserToWordWithMark();
                TextComposite compositeHelper = new TextComposite();
                compositeHelper = textParser.parseText(compositeHelper,
                        lexeme.trim());
                compositeHelper.setStr(lexeme);
                compositesOfMark.addElement(compositeHelper);
            }
        }
        wholeLexeme.addElement(compositesOfWord);
        wholeLexeme.addElement(compositesOfMark);
        wholeLexeme.addElement(compositesOfExpression);
        return wholeLexeme;
    }
}
