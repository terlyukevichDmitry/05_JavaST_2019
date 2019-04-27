package by.epam.site.main;

import by.epam.site.dao.daoimpl.*;
import by.epam.site.entity.Client;
import by.epam.site.entity.Image;
import by.epam.site.entity.Quest;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {
        AbstractDAOImpl<Image> abstractDAO = new ImageDAOImpl();
        List<Image> list = abstractDAO.readAll();
        for (Image i :list) {
            System.out.println(i);
        }
    }
}
