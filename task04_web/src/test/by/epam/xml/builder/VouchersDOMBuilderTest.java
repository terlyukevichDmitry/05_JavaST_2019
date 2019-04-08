package test.by.epam.xml.builder;

import by.epam.xml.builder.VouchersDOMBuilder;
import by.epam.xml.entity.Voucher;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

/**
 *An public class for testing Vouchers DOM Builder.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class VouchersDOMBuilderTest {
    /**
     * {@inheritDoc}
     * @return object with data for checking dom method.
     */
    @DataProvider(name = "xml_dom")
    public Object[][] createCorrectDataForDomBuilder() {
        return
                new Object[][]{
                        {"data" + File.separator + "test1.xml",
                        "[Voucher{country='Egypt', numberDays=10, "
                                +
                                "transport=PLANE, "
                                + "hotelCharacteristics="
                                + "Characteristics"
                                + "{stars=4, nutrition=AL, room=3, "
                                + "tv=true, wifi=true, "
                                + "airConditioning=true}, "
                                + "cost=Price{value=1000, currency=USD}, "
                                + "dataStart=2019-06-04T18:13:51.000+03:00, "
                                + "dataFinish=2019-06-06T18:13:51.000+03:00, "
                                + "id='first', numberNights=3, "
                                + "type='weekend'}]"}
                };
    }

    /**
     * Test for checking good works for creating set with dom builder method.
     * @param fileXml example string for creating object with data of xml file.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "xml_dom")
    public void buildSetVouchersTest(final String fileXml,
                                     final String expected) {
        VouchersDOMBuilder domBuilder = new VouchersDOMBuilder();
        domBuilder.buildSetVouchers(fileXml);
        Set<Voucher> actual = domBuilder.getVouchers();
        Assert.assertEquals(actual.toString(), expected);
    }
}
