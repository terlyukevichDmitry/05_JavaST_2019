package by.epam.site.main;

import by.epam.site.dao.AbstractDAO;
import by.epam.site.dao.UserDAO;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/quest_bd?useUnicode=true&characterEncoding=UTF-8";
    public static final String DB_USER = "quest_user";
    public static final String DB_PASSWORD = "quest_password";
    public static final String DB_SELECT_ALL = "SELECT `id`, `login`, `password`, `role` FROM `user`";
//    public static final int DB_POOL_START_SIZE = 10;
//    public static final int DB_POOL_MAX_SIZE = 1000;
//    public static final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;

    public static void main(String[] args) throws SQLException, ConstantException {
        AbstractDAO<User> abstractDAO = new UserDAO();
        List<User> users = abstractDAO.readAll();
        for (User user : users) {
            System.out.println(user);
        }
        users.get(0).setPassword("KJKJSD3423J4KDJ8DK32KSDF2FWEJ239");
        abstractDAO.update(users.get(0));
        for (User user : users) {
            System.out.println(user);
        }
    }
}
