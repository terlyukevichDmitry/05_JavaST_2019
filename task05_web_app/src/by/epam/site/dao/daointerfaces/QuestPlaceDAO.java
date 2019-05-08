package by.epam.site.dao.daointerfaces;

import by.epam.site.entity.QuestPlace;
import by.epam.site.exception.ConstantException;

import java.util.List;

public interface QuestPlaceDAO extends DaoPattern<QuestPlace> {
    List<QuestPlace> read(String title) throws ConstantException;
}
