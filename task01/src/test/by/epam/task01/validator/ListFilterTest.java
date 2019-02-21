package test.by.epam.task01.validator;

import by.epam.task01.validator.ListFilter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *An public class for testing many different methods of ListFilter Test class.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ListFilterTest {
    /**
     * stringList for filter data.
     */
    private List<String> stringList;
    /**
     * filter data for next things.
     */
    private ListFilter listFilter;
    /**
     * for check list.
     */
    private List<String> trueList;
    /**
     * {@inheritDoc}.
     */
    @BeforeTest
    public void initListFilter() {
        listFilter = new ListFilter();
        stringList = new ArrayList<>(new ArrayList<String>() {
            {
                add("3 1 0 3 25 0 4 10 6");
                add("2 3 0 0 4 5 1 5 9");
                add("1 2 3sd 4g 56rhf 56yhg h56hh");
                add("1 2d 42sd 34f 3");
                add("1 23 4 6 7 8");
            }
        });
        trueList = new ArrayList<>(new ArrayList<String>() {
            {
                add("3 1 0 3 25 0 4 10 6");
                add("2 3 0 0 4 5 1 5 9");
            }
        });
    }
    /**
     * {@inheritDoc}.
     */
    @Test
    public void filterListTest() {
        List<String> actual = listFilter.filterList(stringList);
        List<String> expected = trueList;
        Assert.assertEquals(expected, actual);
    }
    /**
     * @ for remove objects.
     */
    @AfterTest
    public void deleteListFilter() {
        listFilter = null;
        stringList = null;
        trueList = null;
    }
}
