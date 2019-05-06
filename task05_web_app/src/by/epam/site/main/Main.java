package by.epam.site.main;


import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.*;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {

//        System.out.println();
//        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
//        UserService service = factory.getService(UserService.class);
//        User user = service.findByLoginAndPassword("admin", "21232F297A57A5A743894A0E4A801FC3");
//        System.out.println(user);

//        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
//        QuestService service = factory.getService(QuestService.class);
//        List<Quest> list = service.findAll();
//        for (Quest l :list) {
//            System.out.println(l);
//        }

        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        QuestService service = factory.getService(QuestService.class);
        Quest quest = new Quest();
        quest.setMaxPeople(7);
        quest.setLevel(12);
        quest.setTitle("Hello, it's checking process");
        service.save(quest);
        for (Quest q : service.findAll()) {
            System.out.println(q);
        }


    }
}
