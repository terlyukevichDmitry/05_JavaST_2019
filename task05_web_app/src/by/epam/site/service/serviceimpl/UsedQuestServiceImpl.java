package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daointerfaces.UsedQuestDAO;
import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.UsedQuestService;

import java.sql.SQLException;
import java.util.List;

public class UsedQuestServiceImpl extends ServiceImpl implements UsedQuestService {
    @Override
    public List<UsedQuest> findAll() throws ConstantException, SQLException, ClassNotFoundException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        return dao.readAll();
    }

    @Override
    public void save(UsedQuest usedQuest) throws ConstantException, ClassNotFoundException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        if(usedQuest.getId() != null) {
            dao.update(usedQuest);
        } else {
            usedQuest.setId(dao.create(usedQuest));
        }
    }

    @Override
    public void delete(Integer id) throws ClassNotFoundException, ConstantException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        dao.delete(id);
    }
}
