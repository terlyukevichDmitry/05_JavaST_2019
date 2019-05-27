package test.by.epam.site.service;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Quest;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class QuestServiceTest {

    private ServiceFactory factory;
    private QuestService service;

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_findAll")
    public Object[][] findByRole() {
        return
                new Object[][]{
                        {5}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_save")
    public Object[][] saveQuest() {
        return
                new Object[][]{
                        {6, "lllll", 4, 3, "yaya"}
                };
    }

    @BeforeTest
    public void initData() throws ConstantException {
        factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        service = factory.getService(QuestService.class);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findAll")
    public void findAllTest(final Integer expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        List<Quest> questList = service.findAll();
        Assert.assertEquals(Integer.valueOf(questList.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_save")
    public void saveTest(final Integer expected,
                         final String title,
                         final Integer level,
                         final Integer maxPeople,
                         final String description)
            throws ConstantException, SQLException, ClassNotFoundException {
        Quest quest = new Quest();
        quest.setTitle(title);
        quest.setLevel(level);
        quest.setMaxPeople(maxPeople);
        quest.setDescription(description);

        service.save(quest);
        List<Quest> quests = service.findAll();

        Assert.assertEquals(Integer.valueOf(quests.size()), expected);
    }

    @AfterTest
    public void deleteData() {
        factory = null;
        service = null;
    }
}
