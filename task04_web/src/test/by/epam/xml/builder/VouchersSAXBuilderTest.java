package test.by.epam.xml.builder;

import by.epam.xml.builder.VouchersStAXBuilder;
import by.epam.xml.entity.Voucher;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

/**
 *An public class for testing Vouchers SAX Builder.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class VouchersSAXBuilderTest {
    /**
     * {@inheritDoc}
     * @return object with data for checking sax method.
     */
    @DataProvider(name = "xml_sax")
    public Object[][] createCorrectDataForDomBuilder() {
        return
                new Object[][]{
                        {"data" + File.separator + "vouchers.xml",
                                "[Voucher{country='USA', numberDays=2, "
                                        + "transport=SHIP, "
                                        + "hotelCharacteristics="
                                        + "Characteristics{"
                                        + "stars=4, nutrition=HB, room=2, "
                                        + "tv=false, "
                                        + "wifi=true, airConditioning=true}, "
                                        + "cost=Price{value=1500, "
                                        + "currency=EUR}, "
                                        + "dataStart='12.04.2019', "
                                        + "dataFinish='24.04.2019', "
                                        + "id='second', "
                                        + "numberNights=3, type='weekend'}, "
                                        + "Voucher{country='Egypt', "
                                        + "numberDays=10, "
                                        + "transport=PLANE, "
                                        + "hotelCharacteristics="
                                        + "Characteristics{"
                                        + "stars=5, nutrition=AL, room=3, "
                                        + "tv=true, "
                                        + "wifi=true, airConditioning=true}, "
                                        + "cost=Price{value=1000, "
                                        + "currency=USD}, "
                                        + "dataStart='18.04.2019', "
                                        + "dataFinish='28.04.2019', "
                                        + "id='first', "
                                        + "numberNights=3, type='weekend'}]"}
                };
    }

    /**
     * Test for checking good works for creating set with sax builder method.
     * @param fileXml example string for creating object with data of xml file.
     * @param expected true result.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "xml_sax")
    public void buildSetVouchersTest(final String fileXml,
                                     final String expected) {
        VouchersStAXBuilder staxBuilder = new VouchersStAXBuilder();
        staxBuilder.buildSetVouchers(fileXml);
        Set<Voucher> actual = staxBuilder.getVouchers();
        Assert.assertEquals(actual.toString(), expected);
    }
}
