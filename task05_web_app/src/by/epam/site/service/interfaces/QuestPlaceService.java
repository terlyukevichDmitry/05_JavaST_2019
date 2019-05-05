package by.epam.site.service.interfaces;

import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;

import java.sql.SQLException;
import java.util.List;

public interface QuestPlaceService extends Service {
    List<QuestPlace> findAll() throws ConstantException,
            SQLException, ClassNotFoundException;
    void save(QuestPlace user) throws ConstantException, ClassNotFoundException;
    void delete(Integer id) throws ClassNotFoundException, ConstantException;
}
