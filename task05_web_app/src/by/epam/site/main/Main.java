package by.epam.site.main;

import by.epam.site.dao.*;
import by.epam.site.entity.*;
import by.epam.site.exception.ConstantException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ConstantException {
        AbstractDAO<Quest> abstractDAO = new QuestDAO();
        List<Quest> l = abstractDAO.readAll();
        for (Quest q :l) {
            if (q.getAuthorQuest().getId().equals(q.getId())) {
                ((QuestDAO) abstractDAO).initializeAuthorQuest(q);
            }
        }
        for (Quest quest :l) {
            System.out.println(quest);
        }
        abstractDAO.delete(2);
        l = abstractDAO.readAll();
        for (Quest quest :l) {
            System.out.println(quest);
        }
    }
}
