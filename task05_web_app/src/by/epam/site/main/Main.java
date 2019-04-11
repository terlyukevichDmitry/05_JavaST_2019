package by.epam.site.main;

import by.epam.site.entity.Role;
import by.epam.site.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/quest_bd?useUnicode=true&characterEncoding=UTF-8";
    public static final String DB_USER = "quest_user";
    public static final String DB_PASSWORD = "quest_password";
    public static final String DB_SELECT_ALL = "SELECT `id`, `login`, `password`, `role` FROM `user`";
//    public static final int DB_POOL_START_SIZE = 10;
//    public static final int DB_POOL_MAX_SIZE = 1000;
//    public static final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;

    public static void main(String[] args) throws SQLException {
        Connection connection
                = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        Statement st = connection.createStatement();//  статический запрос, выполянется в том виде, какой есть.
        ResultSet resultSet = st.executeQuery(DB_SELECT_ALL);
        User user = null;
        List<User> userList = new ArrayList<>();
        while(resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(Role.getByIdentity(resultSet.getInt("role")));
            userList.add(user);
        }
        for (User us :userList) {
            System.out.println(us);
        }
        st.close();
        connection.close();
    }
}
