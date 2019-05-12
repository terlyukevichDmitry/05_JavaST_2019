package by.epam.site.service.interfaces;

import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public interface UsedQuestService extends Service {
    List<UsedQuest> findAll() throws ConstantException,
            SQLException, ClassNotFoundException;
    void save(UsedQuest usedQuest)
            throws ConstantException, ClassNotFoundException, SQLException;
    void delete(Integer id) throws ClassNotFoundException, ConstantException;
    List<UsedQuest> findByClientId(Integer id)
            throws ConstantException, SQLException, ClassNotFoundException;
    void initData(List<UsedQuest> usedQuests)
            throws ConstantException, SQLException, ClassNotFoundException;
    void delete(Integer clientId, Integer usedQuestId) throws ConstantException;
    UsedQuest findById(Integer usedQuestId) throws ConstantException;
}
