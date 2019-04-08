package test.by.epam.xml.builder;

import by.epam.xml.builder.VouchersStAXBuilder;
import by.epam.xml.entity.Voucher;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

/**
 *An public class for testing Vouchers StAX Builder.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class VouchersStAXBuilderTest {
    /**
     * {@inheritDoc}
     * @return object with data for checking stax method.
     */
    @DataProvider(name = "xml_stax")
    public Object[][] createCorrectDataForDomBuilder() {
        return
                new Object[][]{
                        {"data" + File.separator + "test3.xml",
                                "[Voucher{country='Greece', numberDays=21, "
                                        + "transport=PLANE,"
                                        + " hotelCharacteristics="
                                        + "Characteristics"
                                        + "{stars=5, nutrition=AL, room=3, "
                                        + "tv=true, wifi=true, "
                                        + "airConditioning=true}, cost=Price"
                                        + "{value=3560, currency=EUR}, "
                                        + "dataStart=2021-12-06T09:30:"
                                        + "00.000+03:00, dataFinish=2021-12"
                                        + "-26T22:45:00.000+03:00, "
                                        + "id='sixteenth', numberNights=20, "
                                        + "type='3 week'}]"}
                };
    }

    /**
     * Test for checking good works for creating set with stax builder method.
     * @param fileXml example string for creating object with data of xml file.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "xml_stax")
    public void buildSetVouchersTest(final String fileXml,
                                     final String expected) {
        VouchersStAXBuilder vouchersStAXBuilder = new VouchersStAXBuilder();
        vouchersStAXBuilder.buildSetVouchers(fileXml);
        Set<Voucher> actual = vouchersStAXBuilder.getVouchers();
        Assert.assertEquals(actual.toString(), expected);
    }
}
