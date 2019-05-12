package by.epam.site.dao.daointerfaces;

import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;

import java.util.List;

public interface UsedQuestDAO extends DaoPattern<UsedQuest> {
    List<UsedQuest> read(Integer id) throws ConstantException;
    void delete(Integer clientId, Integer usedQuestId) throws ConstantException;
}
