package by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComposite;

/**
 * Interface for sorting data.
 */
public interface SortComparator {
    /**
     * Method for sort.
     * @param textComposite object witch we will be sort.
     */
    void sortingData(TextComposite textComposite);
}