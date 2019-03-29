package by.epam.xml.dom;

import by.epam.xml.builder.AbstractVouchersBuilder;
import by.epam.xml.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class VouchersDOMBuilder extends AbstractVouchersBuilder {
    private DocumentBuilder documentBuilder;
    private Set<Voucher> vouchers;
    public VouchersDOMBuilder() {
        super();
        this.vouchers = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void setVouchers(Set<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public VouchersDOMBuilder(Set<Voucher> vouchers) {
        super(vouchers);
    }

    @Override
    public Set<Voucher> getVouchers() {
        return vouchers;
    }

    @Override
    public void buildSetVouchers(String fileName) {

    }

    public void buildSetStudents(String fileName) {
        Document doc = null;
        try {
// parsing XML-документа и создание древовидной структуры
            doc = documentBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <student>
            NodeList vouchersList = root.getElementsByTagName("voucher");
            for (int i = 0; i < vouchersList.getLength(); i++) {
                Element voucherElement = (Element) vouchersList.item(i);
                Voucher voucher = buildStudent(voucherElement);
                vouchers.add(voucher);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (org.xml.sax.SAXException e) {
            System.err.println("File error or SAX error: " + e);
        }
    }
    public Voucher buildStudent(Element voucherElement) {
        Voucher voucher = new Voucher();
        // заполнение объекта student
        voucher.setId(voucherElement.getAttribute("id"));
        voucher.setNumberNights(BigInteger.valueOf(Integer.valueOf(voucherElement.getAttribute("numberNights"))));
        voucher.setType(getElementTextContent(voucherElement, "type"));
        voucher.setCountry(getElementTextContent(voucherElement, "country"));
        voucher.setNumberDays(BigInteger.valueOf(Integer.valueOf(getElementTextContent(
                voucherElement, "numberDays"))));
        voucher.setTransport(Transport.fromValue(getElementTextContent(
                voucherElement, "transport")));
        voucher.setHotelCharacteristics(getCharacteristics(voucherElement));
        Price price = new Price();
        price.setValue(BigDecimal.valueOf(Integer.valueOf(getElementTextContent(voucherElement, "cost"))));
        price.setCurrency(Currency.fromValue(getCurrency(voucherElement)));
        voucher.setCost(price);
        voucher.setDataStart(getElementTextContent(voucherElement, "data-start"));
        voucher.setDataFinish(getElementTextContent(voucherElement, "data-finish"));

        return voucher;
    }

    private Characteristics getCharacteristics(Element voucherElement) {
        Characteristics characteristics = new Characteristics();
        characteristics.setStars(Integer.parseInt(
                getElementTextContent(voucherElement, "stars")));
        characteristics.setNutrition(Nutrition.fromValue(
                getElementTextContent(voucherElement, "nutrition")));
        characteristics.setRoom(BigInteger.valueOf(
                Integer.valueOf(getElementTextContent(voucherElement, "room"))));
        characteristics.setTV(Boolean.parseBoolean(
                getElementTextContent(voucherElement, "TV")));
        characteristics.setWIFI(Boolean.parseBoolean(getElementTextContent(voucherElement, "WI-FI")));
        characteristics.setAirConditioning(Boolean.parseBoolean(getElementTextContent(voucherElement, "air-conditioning")));
        return characteristics;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }

    private String getCurrency(Element element) {
        return String.valueOf(element.getElementsByTagName("cost").item(0).getAttributes().item(0).getTextContent());
    }
}