package test.by.epam.task01.validator;

import by.epam.task01.validator.ListFilter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class ListFilterTest {

    private List<String> stringList;

    private ListFilter listFilter;

    private List<String> trueList;

    @BeforeTest
    public void initListFilter(){
        listFilter = new ListFilter();
        stringList = new ArrayList<>(new ArrayList<String>() {
            {
                add("1 2 3 4 5 6 7 8");
                add("2 3 4 5 7 1 5 9");
                add("1 2 3sd 4g 56rhf 56yhg h56hh");
                add("1 2d 42sd 34f 3");
                add("1 23 4 6 7 8");
            }
        });
        trueList = new ArrayList<>(new ArrayList<String>() {
            {
                add("1 2 3 4 5 6 7 8");
                add("2 3 4 5 7 1 5 9");
            }
        });
    }

    @Test
    public void filterListTest(){

        List<String> actual = listFilter.filterList(stringList);
        List<String> expected = trueList;
        Assert.assertEquals(expected, actual);
    }

    @AfterTest
    public void deleteListFilter(){
        listFilter = null;
    }
}
