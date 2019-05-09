package by.epam.site.main;


import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.*;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {

//        System.out.println();
//        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
//        UserService service = factory.getService(UserService.class);
//        User user = service.findByLoginAndPassword("admin", "21232F297A57A5A743894A0E4A801FC3");
//        System.out.println(user);

//        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
//        UserService service = factory.getService(UserService.class);
//        List<User> list = service.findAll();
//        for (User l :list) {
//            System.out.println(l.getLogin().length());
//        }




        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
        UserService service = factory.getService(UserService.class);
        User user = new User();
        user.setId(1);
        user.setLogin("admin");
        user.setRole(Role.ADMINISTRATOR);
        user.setPassword("D4842D5376778C931DF35D6D4074442D");
        service.save(user);

        String st = "BB7FF6177EE612EF9DC6ACD3A9EA7EA9";
        byte[] digest = new byte[0];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new ConstantException();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        StringBuilder mdHex = new StringBuilder(bigInt.toString(16).toUpperCase());

        while( mdHex.length() < 32 ){
            mdHex.insert(0, "0");
        }
        System.out.println(mdHex);

    }
}
