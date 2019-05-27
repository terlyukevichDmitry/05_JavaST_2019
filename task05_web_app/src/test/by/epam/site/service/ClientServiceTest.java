package test.by.epam.site.service;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Client;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.ClientService;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceTest {
    private ServiceFactory factory;
    private ClientService service;
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
    @DataProvider(name = "db_findById")
    public Object[][] findById() {
        return
                new Object[][]{
                        {1}
                };
    }

    @BeforeTest
    public void initData() throws ConstantException {
        factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        service = factory.getService(ClientService.class);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findAll")
    public void findAllTest(final Integer expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        List<Client> clients = service.findAll();
        Assert.assertEquals(Integer.valueOf(clients.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findById")
    public void findById(final Integer expected)
            throws ConstantException {
        Client client = service.findById(expected);
        Assert.assertEquals(client.getId(), expected);
    }

    @AfterTest
    public void deleteData() {
        factory = null;
        service = null;
    }
}
