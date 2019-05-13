package by.epam.site.dao.daointerfaces;

import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.Quest;
import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;

public interface QuestDAO extends DaoPattern<Quest> {
    void read(Quest quest)
            throws ConstantException;
    Quest read(String title) throws ConstantException;
}
