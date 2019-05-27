package test.by.epam.site.service;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Image;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ImageService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class ImageServiceTest {

    private ServiceFactory factory;
    private ImageService service;
    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_findAll")
    public Object[][] findAll() {
        return
                new Object[][]{
                        {5}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_create")
    public Object[][] create() {
        return
                new Object[][]{
                        {6}
                };
    }

    @BeforeTest
    public void initData() throws ConstantException {
        factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        service = factory.getService(ImageService.class);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findAll")
    public void findAllTest(final Integer expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        List<Image> images = service.findAll();
        Assert.assertEquals(Integer.valueOf(images.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_create")
    public void createTest(final Integer expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        Image image = new Image();
        image.setFilePath("images/1.jpg");
        service.create(image);
        List<Image> images = service.findAll();
        Assert.assertEquals(Integer.valueOf(images.size()), expected);
    }

    @AfterTest
    public void deleteData() {
        factory = null;
        service = null;
    }
}
