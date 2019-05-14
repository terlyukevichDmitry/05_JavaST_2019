package by.epam.site.dao.daointerfaces;

import by.epam.site.dao.transaction.SqlTransaction;
import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;

import java.util.List;

public interface UsedQuestDAO extends DaoPattern<UsedQuest> {
    List<UsedQuest> read(Integer id) throws ConstantException;
    void delete(Integer clientId, Integer usedQuestId) throws ConstantException;
    UsedQuest readById(Integer usedQuestId) throws ConstantException;
    void deleteByQuestPlaceId(Integer questPlaceId) throws ConstantException;
}
