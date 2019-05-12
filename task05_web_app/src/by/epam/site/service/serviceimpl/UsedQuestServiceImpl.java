package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.dao.daointerfaces.UsedQuestDAO;
import by.epam.site.entity.QuestPlace;
import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsedQuestServiceImpl extends ServiceImpl implements UsedQuestService {
    @Override
    public List<UsedQuest> findAll() throws ConstantException, SQLException, ClassNotFoundException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        return dao.readAll();
    }

    @Override
    public void save(UsedQuest usedQuest) throws ConstantException, ClassNotFoundException, SQLException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        if(usedQuest.getId() != null) {
            dao.update(usedQuest, transaction);
        } else {
            usedQuest.setId(dao.create(usedQuest, transaction));
        }
    }

    @Override
    public void delete(Integer id) throws ClassNotFoundException, ConstantException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        dao.delete(id);
    }

    @Override
    public void initData(List<UsedQuest> usedQuests)
            throws ConstantException, SQLException, ClassNotFoundException {
        for (UsedQuest element : usedQuests) {
            System.out.println(element.getQuestPlace().getId());
//            ServiceFactory factory = new ServiceFactoryImpl(
//                    new SqlTransactionFactoryImpl());
//            QuestPlaceService service
//                    = factory.getService(QuestPlaceService.class);
//            List<QuestPlace> questPlaces = new ArrayList<>();
//            questPlaces.add(element.getQuestPlace());
//            service.initData(questPlaces);

        }
    }

    @Override
    public List<UsedQuest> findByClientId(final Integer id)
            throws ConstantException, SQLException, ClassNotFoundException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        List<UsedQuest> usedQuests = dao.read(id);
        initData(usedQuests);
        return usedQuests;
    }

    @Override
    public void delete(Integer clientId, Integer usedQuestId)
            throws ConstantException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        dao.delete(clientId, usedQuestId);
    }
}
