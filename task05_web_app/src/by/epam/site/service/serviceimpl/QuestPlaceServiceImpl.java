package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daointerfaces.QuestPlaceDAO;
import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;

import java.sql.SQLException;
import java.util.List;

public class QuestPlaceServiceImpl
        extends ServiceImpl implements QuestPlaceService {
    @Override
    public List<QuestPlace> findAll() throws ConstantException,
            SQLException, ClassNotFoundException {
        QuestPlaceDAO dao = transaction.createDaoImpl(QuestPlaceDAO.class);
        return dao.readAll();
    }

    @Override
    public void save(QuestPlace questPlace) throws ConstantException,
            ClassNotFoundException {
        QuestPlaceDAO dao = transaction.createDaoImpl(QuestPlaceDAO.class);
        if(questPlace.getId() != null) {
            dao.update(questPlace, transaction);
        } else {
            questPlace.setId(dao.create(questPlace, transaction));
        }
    }

    @Override
    public void delete(Integer id) throws ClassNotFoundException,
            ConstantException {
        QuestPlaceDAO dao = transaction.createDaoImpl(QuestPlaceDAO.class);
        dao.delete(id);
    }
}
