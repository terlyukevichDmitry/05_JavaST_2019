package by.epam.site.main;

import by.epam.site.action.logic.ConfigurationManager;
import by.epam.site.dao.daoimpl.*;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {
        ResourceBundle bundle = ResourceBundle.getBundle("messages");
        System.out.println(bundle.getString("hi"));
    }

}
