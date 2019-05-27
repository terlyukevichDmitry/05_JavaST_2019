package test.by.epam.site.service;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.UsedQuest;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UsedQuestService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class UsedQuestServiceTest {

    private ServiceFactory factory;
    private UsedQuestService service;
    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_findAll")
    public Object[][] createDataProviderForServiceTest() {
        return
                new Object[][]{
                        {3}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_findByClientId")
    public Object[][] getParameters() {
        return
                new Object[][]{
                        {2, 1}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_findId")
    public Object[][] findId() {
        return
                new Object[][]{
                        {2}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_delete")
    public Object[][] getForRemoveUser() {
        return
                new Object[][]{
                        {1}
                };
    }

    @BeforeTest
    public void initData() throws ConstantException {
        factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        service = factory.getService(UsedQuestService.class);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findId")
    public void findByIdTest(final Integer expected)
            throws ConstantException {
        UsedQuest usedQuest = service.findById(expected);
        Assert.assertEquals(usedQuest.getId(), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findAll")
    public void findAllTest(final Integer expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        List<UsedQuest> usedQuests = service.findAll();
        Assert.assertEquals(Integer.valueOf(usedQuests.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findByClientId")
    public void findByClientIdTest(final Integer id,
                                   final Integer expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        List<UsedQuest> usedQuests = service.findByClientId(id);
        Assert.assertEquals(Integer.valueOf(usedQuests.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_delete")
    public void deleteTest(final Integer id)
            throws ConstantException, ClassNotFoundException {
        service.delete(id);
        UsedQuest usedQuest = service.findById(id);
        Assert.assertNull(usedQuest);
    }

    /**
     * Test for checking good works for reading all users of the db.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_delete")
    public void deleteByQuestPlaceIdTest(final Integer id)
            throws ConstantException {
        service.deleteByQuestPlaceId(id);
        UsedQuest usedQuest = service.findById(id);
        Assert.assertNull(usedQuest);
    }

    @AfterTest
    public void deleteData() {
        factory = null;
        service = null;
    }
}
