package by.epam.site.service.interfaces;

import by.epam.site.entity.Quest;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public interface QuestService extends Service {
    List<Quest> findAll() throws ConstantException,
            SQLException, ClassNotFoundException;
    void save(Quest entity) throws ConstantException, ClassNotFoundException;
    void delete(Integer id) throws ClassNotFoundException, ConstantException;
}
