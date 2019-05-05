package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daointerfaces.QuestDAO;
import by.epam.site.entity.Quest;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestService;

import java.sql.SQLException;
import java.util.List;

public class QuestServiceImpl extends ServiceImpl implements QuestService {
    @Override
    public List<Quest> findAll()
            throws ConstantException, SQLException, ClassNotFoundException {
        QuestDAO dao = transaction.createDaoImpl(QuestDAO.class);
        return dao.readAll();    }

    @Override
    public void save(Quest quest)
            throws ConstantException, ClassNotFoundException {
        QuestDAO dao = transaction.createDaoImpl(QuestDAO.class);
        if(quest.getId() != null) {
            dao.update(quest);
        } else {
            quest.setId(dao.create(quest));
        }
    }

    @Override
    public void delete(Integer id)
            throws ClassNotFoundException, ConstantException {
        QuestDAO dao = transaction.createDaoImpl(QuestDAO.class);
        dao.delete(id);
    }
}
