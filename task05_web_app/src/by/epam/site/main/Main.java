package by.epam.site.main;


import by.epam.site.dao.daoimpl.SqlTransactionFactoryImpl;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;
import by.epam.site.service.interfaces.*;
import by.epam.site.service.serviceimpl.ServiceFactoryImpl;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {

//        System.out.println();
//        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
//        UserService service = factory.getService(UserService.class);
//        User user = service.findByLoginAndPassword("admin", "21232F297A57A5A743894A0E4A801FC3");
//        System.out.println(user);

//        ServiceFactory factory = new ServiceFactoryImpl(new SqlTransactionFactoryImpl());
//        UsedQuestService service = factory.getService(UsedQuestService.class);
//        List<UsedQuest> list = service.findByClientId(1);
//        for (UsedQuest l :list) {
//            System.out.println(l);
//        }MTE=




        Calendar now = Calendar.getInstance();
        String minute = String.valueOf(now.get(Calendar.MINUTE));
        String encoded = Base64.getEncoder().encodeToString(
                minute.getBytes());

        byte[] decode = Base64.getDecoder().decode("MTE=");
        String s = new String(decode);
        System.out.println(s);


//        UserService service = factory.getService(UserService.class);
//        User user = new User();
//        user.setId(1);
//        user.setLogin("admin");
//        user.setRole(Role.ADMINISTRATOR);
//        user.setPassword("terlyukevish");
//        service.save(user);

//        String st = "BB7FF6177EE612EF9DC6ACD3A9EA7EA9";
//        byte[] digest = new byte[0];
//        try {
//            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//            messageDigest.reset();
//            messageDigest.update(st.getBytes());
//            digest = messageDigest.digest();
//        } catch (NoSuchAlgorithmException e) {
//            throw new ConstantException();
//        }
//
//        BigInteger bigInt = new BigInteger(1, digest);
//        StringBuilder mdHex = new StringBuilder(bigInt.toString(16).toUpperCase());
//
//        while( mdHex.length() < 32 ){
//            mdHex.insert(0, "0");
//        }
//        System.out.println(mdHex);



    }
}
