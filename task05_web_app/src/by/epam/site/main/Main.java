package by.epam.site.main;


import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.User;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.Service;
import by.epam.site.service.interfaces.ServiceFactory;
import by.epam.site.service.interfaces.UserService;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;
import by.epam.site.service.serviceimpl.UserServiceImpl;

import java.sql.*;
import java.io.File;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {

        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        UserService service = factory.getService(UserService.class);
        User user = service.findByLoginAndPassword("admin", "21232F297A57A5A743894A0E4A801FC3");
        System.out.println(user);

    }
}
