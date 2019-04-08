package test.by.epam.xml.builder;

import by.epam.xml.builder.VouchersSAXBuilder;
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
                        {"data" + File.separator + "test2.xml",
                                "[Voucher{country='USA', numberDays=2, "
                                        + "transport=SHIP, "
                                        + "hotelCharacteristics="
                                        + "Characteristics{stars=4, "
                                        + "nutrition=HB, room=2, tv=false, "
                                        + "wifi=true, airConditioning=true}, "
                                        + "cost=Price{value=1500, "
                                        + "currency=null}, "
                                        + "dataStart=2019-12-04T"
                                        + "18:13:51.000+03:00, dataFinish="
                                        + "2019-12-14T18:13:51.000+03:00, "
                                        + "id='second', numberNights=3, "
                                        + "type='weekend'}]"}
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
        VouchersSAXBuilder vouchersSAXBuilder = new VouchersSAXBuilder();
        vouchersSAXBuilder.buildSetVouchers(fileXml);
        Set<Voucher> actual = vouchersSAXBuilder.getVouchers();
        Assert.assertEquals(actual.toString(), expected);
    }
}
