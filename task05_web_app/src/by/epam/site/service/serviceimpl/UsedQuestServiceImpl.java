package by.epam.site.service.serviceimpl;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.dao.daoimpl.UsedQuestDAOImpl;
import by.epam.site.dao.daointerfaces.UsedQuestDAO;
import by.epam.site.entity.QuestPlace;
import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.QuestPlaceService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsedQuestServiceImpl extends ServiceImpl implements UsedQuestService {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(UsedQuestServiceImpl.class);
    @Override
    public List<UsedQuest> findAll() throws ConstantException, SQLException, ClassNotFoundException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        return dao.readAll();
    }

    @Override
    public void save(UsedQuest usedQuest) throws ConstantException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        try {
            if (usedQuest.getId() != null) {
                dao.update(usedQuest, transaction);
            } else {
                usedQuest.setId(dao.create(usedQuest, transaction));
            }
            transaction.commit();
        } catch (SQLException | ClassNotFoundException e) {
            transaction.rollback();
            LOGGER.error("There is no autoincremented "
                    + "index after trying to add record into table "
                    + "`used_quest`");
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
            System.out.println("element.getQuestPlace().getId() =" + element.getQuestPlace().getId());
            System.out.println("element.getClient().getId() = " + element.getClient().getId());
            ServiceFactory factory = new ServiceFactoryImpl(
                    new SqlTransactionFactoryImpl());
            QuestPlaceService service
                    = factory.getService(QuestPlaceService.class);
            element.setQuestPlace(service.findById(element.getQuestPlace().getId()));
            List<QuestPlace> questPlaces = new ArrayList<>();
            questPlaces.add(element.getQuestPlace());
            service.initData(questPlaces);
            factory.close();
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

    @Override
    public UsedQuest findById(Integer usedQuestId) throws ConstantException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        return dao.readById(usedQuestId);
    }

    @Override
    public void deleteByQuestPlaceId(Integer questPlaceId)
            throws ConstantException {
        UsedQuestDAO dao = transaction.createDaoImpl(UsedQuestDAO.class);
        dao.deleteByQuestPlaceId(questPlaceId);
    }
}
