package by.epam.site.main;

import by.epam.site.dao.*;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {
        AbstractDAO<User> abstractDAO = new UserDAO();
        List<User> list = abstractDAO.readAll();
        for (User client : list) {
            System.out.println(client.toString());
        }

    }
}
