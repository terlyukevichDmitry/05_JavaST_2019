package by.epam.informationhandling.action;

import by.epam.informationhandling.entity.TextComposite;

public class CloneComposite {
    public TextComposite cloningComposite(final TextComposite textComposite) throws CloneNotSupportedException {
        return (TextComposite) textComposite.clone();
    }
}
