package by.epam.site.dao.interfaces;

import by.epam.site.entity.Quest;
import by.epam.site.exception.ConstantException;

public interface QuestDAO {
    void initializeAuthorQuest(Quest quest)
            throws ConstantException, ClassNotFoundException;
}
