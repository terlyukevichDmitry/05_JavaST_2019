package test.by.epam.site.service;

import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
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

public class UserServiceTest {
    private ServiceFactory factory;
    private UserService service;
    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_findAll")
    public Object[][] createDataProviderForServiceTest() {
        return
                new Object[][]{
                        {5}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_findId")
    public Object[][] findId() {
        return
                new Object[][]{
                        {1}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_login")
    public Object[][] getLogin() {
        return
                new Object[][]{
                        {"admin"}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_create")
    public Object[][] getForCreateUser() {
        return
                new Object[][]{
                        {"anton", "1234", Role.CLIENT, 6}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_update")
    public Object[][] getForUpdateUser() {
        return
                new Object[][]{
                        {3, "newLogin"}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "md_five")
    public Object[][] mdFiveMethod() {
        return
                new Object[][]{
                        {"new string", "B200A3ADBE85FE848B920DC35D5A69B2"}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_delete")
    public Object[][] getForRemoveUser() {
        return
                new Object[][]{
                        {5}
                };
    }

    /**
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "db_role")
    public Object[][] findByRole() {
        return
                new Object[][]{
                        {Role.ADMINISTRATOR, 1}
                };
    }

    @BeforeTest
    public void initData() throws ConstantException {
         factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
         service = factory.getService(UserService.class);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findAll")
    public void findAllTest(final Integer expected) throws ConstantException, SQLException, ClassNotFoundException {
        List<User> users = service.findAll();
        Assert.assertEquals(Integer.valueOf(users.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_findId")
    public void findByIdTest(final Integer expected)
            throws ConstantException {
        User user = service.findById(expected);
        Assert.assertEquals(user.getId(), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_login")
    public void findByLoginTest(final String expected)
            throws ConstantException {
        User user = service.findByLogin(expected);
        Assert.assertEquals(user.getLogin(), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param login f.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_create")
    public void createUserTest(final String login,
                               final String password,
                               final Role role,
                               final Integer expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);

        service.save(user);
        List<User> users = service.findAll();

        Assert.assertEquals(Integer.valueOf(users.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     * @param id f.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_update")
    public void updateUserTest(final Integer id,
                               final String expected)
            throws ConstantException, SQLException, ClassNotFoundException {
        User user = service.findById(id);
        user.setLogin("newLogin");
        service.save(user);
        user = service.findByLogin(expected);
        Assert.assertEquals(user.getLogin(), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_delete")
    public void deleteTest(final Integer id)
            throws ConstantException, ClassNotFoundException {
        service.delete(id);
        User user = service.findById(id);
        Assert.assertNull(user);
    }

    /**
     * Test for checking good works for reading all users of the db.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "db_role")
    public void findByRoleTest(final Role role,
                               final Integer expected)
            throws ConstantException {
        List<User> user = service.findByRole(role);
        Assert.assertEquals(Integer.valueOf(user.size()), expected);
    }

    /**
     * Test for checking good works for reading all users of the db.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "md_five")
    public void mdFiveMethodTest(final String string,
                                 final String expected)
            throws ConstantException {
        String actual = service.mdFiveMethod(string);
        Assert.assertEquals(actual, expected);
    }


    @AfterTest
    public void deleteData() {
        factory = null;
        service = null;
    }
}
