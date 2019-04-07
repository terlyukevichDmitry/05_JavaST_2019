package test.by.epam.xml.datetime;

import by.epam.xml.datetime.DateTimeConverter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 *An public class for testing DateTime Converter.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class DateTimeConverterTest {

    /**
     * {@inheritDoc}
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "date_time")
    public Object[][] createCorrectDataForDomBuilder() {
        return
                new Object[][]{
                        {"2021-12-06T09:30:00",
                        "2021-12-06T09:30:00.000+03:00"}
                };
    }

    /**
     *Test for checking good works for creating string with data for creating
     * XMLGregorianCalendar objects.
     * @param dateTime example for checking method.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "date_time")
    public void getDateTimeTest(final String dateTime,
                                     final String expected) {
        DateTimeConverter dateTimeConverter = new DateTimeConverter();
        XMLGregorianCalendar actual
                = dateTimeConverter.getDateTime(dateTime);
        Assert.assertEquals(actual.toString(), expected);
    }
}
