package by.epam.site.main;


import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.io.File;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException, ClassNotFoundException {
        File file = new File("web/css/logo.png");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
    }
}
