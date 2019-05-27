package test.by.epam.site.service;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.QuestPlaceService;
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

public class QuestPlaceServiceTest {

    private ServiceFactory factory;
    private QuestPlaceService service;
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
    @DataProvider(name = "db_findById")
    public Object[][] findById() {
        return
                new Object[][]{
                        {1}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_findByName")
    public Object[][] findByName() {
        return
                new Object[][]{
                        {"Topkvest", 1}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_create")
    public Object[][] delete() {
        return
                new Object[][]{
                        {"New Place", "298619783", "New Address", 6}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_update")
    public Object[][] update() {
        return
                new Object[][]{
                        {3, "Allo"}
                };
    }

    @BeforeTest
    public void initData() throws ConstantException {
        factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        service = factory.getService(QuestPlaceService.class);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findAll")
    public void findAllTest(final Integer expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        List<QuestPlace> questPlaces = service.findAll();
        Assert.assertEquals(Integer.valueOf(questPlaces.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findById")
    public void findByIdTest(final Integer expected)
            throws ConstantException {
        QuestPlace questPlace = service.findById(expected);
        Assert.assertEquals(questPlace.getId(), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findByName")
    public void findByNameTest(final String name,
                               final Integer expected)
            throws ConstantException {
        List<QuestPlace> questPlace = service.findByName(name);
        Assert.assertEquals(Integer.valueOf(questPlace.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_create")
    public void createTest(final String name,
                           final String phone,
                           final String address,
                           final Integer expected)
            throws ConstantException, ClassNotFoundException, SQLException {
        QuestPlace questPlace = new QuestPlace();
        Image image = new Image();
        image.setId(1);
        questPlace.setImage(image);
        Quest quest = new Quest();
        quest.setId(1);
        questPlace.setQuest(quest);
        questPlace.setName(name);
        questPlace.setPhone(phone);
        questPlace.setAddress(address);
        service.save(questPlace);
        List<QuestPlace> questPlaces = service.findAll();
        Assert.assertEquals(Integer.valueOf(questPlaces.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_update")
    public void updateTest(final Integer id,
                           final String expected)
            throws ConstantException, ClassNotFoundException, SQLException {
        QuestPlace questPlace = service.findById(id);
        questPlace.setName(expected);
        service.save(questPlace);
        questPlace = service.findById(id);
        Assert.assertEquals(questPlace.getName(), expected);
    }

    @AfterTest
    public void deleteData() {
        factory = null;
        service = null;
    }
}
