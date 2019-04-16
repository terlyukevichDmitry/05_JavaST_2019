package by.epam.site.main;

import by.epam.site.dao.daoimpl.AbstractDAOImpl;
import by.epam.site.dao.daoimpl.UserDAOImpl;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {
        AbstractDAOImpl<User> abstractDAO = new UserDAOImpl();
        List<User> list = abstractDAO.readAll();
        for (User client : list) {
            System.out.println(client.toString());
        }

    }
}
