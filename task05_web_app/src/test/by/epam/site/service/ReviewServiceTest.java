package test.by.epam.site.service;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.QuestPlace;
import by.epam.site.entity.Review;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ReviewService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ReviewServiceTest {

    private ServiceFactory factory;
    private ReviewService service;

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_findAll")
    public Object[][] findAll() {
        return
                new Object[][]{
                        {3}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_save")
    public Object[][] saveTest() {
        return
                new Object[][]{
                        {4, "New message"}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_delete")
    public Object[][] deleteTest() {
        return
                new Object[][]{
                        {4, 3}
                };
    }
    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_deleteByClientId")
    public Object[][] db_deleteByClientIdTest() {
        return
                new Object[][]{
                        {1, 2}
                };
    }

    @BeforeTest
    public void initData() throws ConstantException {
        factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        service = factory.getService(ReviewService.class);
    }

    /**
     * Test for checking good works for reading all users of the db.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findAll")
    public void findAllTest(final Integer expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        List<Review> reviews = service.findAll();
        Assert.assertEquals(Integer.valueOf(reviews.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_save")
    public void saveTest(final Integer expected,
                         final String string)
            throws ConstantException, SQLException, ClassNotFoundException {
        Review review = new Review();
        Client client = new Client();
        client.setId(1);
        review.setClient(client);
        QuestPlace questPlace = new QuestPlace();
        questPlace.setId(1);
        review.setQuestPlace(questPlace);
        review.setMessage(string);
        review.setDate(LocalDate.now());

        service.save(review);
        List<Review> reviews = service.findAll();
        Assert.assertEquals(Integer.valueOf(reviews.size()), expected);
    }


    /**
     * Test for checking good works for reading all users of the db.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_delete")
    public void deleteTest(final Integer id,
                           final Integer expected)
            throws ConstantException, ClassNotFoundException, SQLException {
        service.delete(id);
        List<Review> reviews = service.findAll();
        Assert.assertEquals(Integer.valueOf(reviews.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_deleteByClientId")
    public void deleteByClientIdTest(final Integer id,
                           final Integer expected)
            throws ConstantException, ClassNotFoundException, SQLException {
        service.deleteByClientId(id);
        List<Review> reviews = service.findAll();
        Assert.assertEquals(Integer.valueOf(reviews.size()), expected);
    }

    @AfterTest
    public void deleteData() {
        factory = null;
        service = null;
    }
}
