package by.epam.xml.datetime;

import by.epam.xml.validation.ValidatorSAX;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeConverter {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(DateTimeConverter.class);
    public XMLGregorianCalendar getDataTime(final String string) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = format.parse(getTrueDateTimeString(string));
        } catch (ParseException e) {
            LOGGER.error("We have incorrect data for parse: ", e);
        }

        GregorianCalendar cal = new GregorianCalendar();
        assert date != null;
        cal.setTime(date);

        XMLGregorianCalendar xmlGregCal = null;
        try {
            xmlGregCal= DatatypeFactory.newInstance().newXMLGregorianCalendar(
                    cal);
        } catch (DatatypeConfigurationException e) {
            LOGGER.error("We have incorrect data creating xmlGregCal: ", e);
        }
        return xmlGregCal;
    }

    private String getTrueDateTimeString(final String string) {
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == 'T') {
                stringBuilder.append(' ');
            } else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }
}
