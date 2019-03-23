package by.epam.informationhandling.action;

import by.epam.informationhandling.entity.TextComposite;

/**
 * Class for clone composite object. I can't use cloneable
 * because i'm have sonarLint.
 */
public class CloneComposite {
    /**
     * Method for clone object.
     * @param textComposite object for clone.
     * @return clone composite.
     */
    public TextComposite cloneComposite(final TextComposite textComposite) {
        TextComposite composite = new TextComposite();
        composite.setComponents(textComposite.getComponents());
        composite.setTextElementType(textComposite.getTextElementType());
        return composite;
    }
}
