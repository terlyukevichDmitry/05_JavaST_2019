package by.epam.xml.sax;

import by.epam.xml.entity.Voucher;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class VouchersSAXBuilder {
    private Set<Voucher> vouchers;
    private VoucherHandler voucherHandler;
    private XMLReader reader;
    public VouchersSAXBuilder() {
        // создание SAX-анализатора
        voucherHandler = new VoucherHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(voucherHandler);
        } catch (org.xml.sax.SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    public void buildSetStudents(String fileName) {
        try {
            // разбор XML-документа
            reader.parse(fileName);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        vouchers = voucherHandler.getVouchers();
    }
}


