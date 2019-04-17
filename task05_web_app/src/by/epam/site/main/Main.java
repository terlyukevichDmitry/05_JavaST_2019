package by.epam.site.main;

import by.epam.site.dao.daoimpl.*;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {
        AbstractDAOImpl<Client> abstractDAO = new ClientDAOImpl();
        List<Client> list = abstractDAO.readAll();
        for (Client client : list) {
            System.out.println(client.toString());
        }
    }
}
