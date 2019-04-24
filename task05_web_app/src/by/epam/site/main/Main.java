package by.epam.site.main;

import by.epam.site.dao.daoimpl.AbstractDAOImpl;
import by.epam.site.dao.daoimpl.ClientDAOImpl;
import by.epam.site.dao.daoimpl.QuestDAOImpl;
import by.epam.site.dao.daoimpl.UserDAOImpl;
import by.epam.site.entity.Client;
import by.epam.site.entity.Quest;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {

        AbstractDAOImpl<Client> abstractDAO = new ClientDAOImpl();
        List<Client> clientList = abstractDAO.readAll();
        for (Client c :clientList) {
            System.out.println(c);
        }


    }

}
