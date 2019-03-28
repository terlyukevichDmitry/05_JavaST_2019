package by.epam.xml.dom;

import by.epam.xml.builder.AbstractVouchersBuilder;
import by.epam.xml.entity.Voucher;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
        return super.getVouchers();
    }

    @Override
    public void buildSetVouchers(String fileName) {

    }

    public void buildSetStudents(String fileName) {
        Document doc = null;
        try {
// parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <student>
            NodeList studentsList = root.getElementsByTagName("student");
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element studentElement = (Element) studentsList.item(i);
                Student student = buildStudent(studentElement);
                students.add(student);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }
}
