package by.epam.xml.servlet;

import by.epam.xml.builder.VouchersDOMBuilder;
import by.epam.xml.builder.VouchersSAXBuilder;
import by.epam.xml.builder.VouchersStAXBuilder;

import java.io.IOException;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class we use for working in web parts.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ParserServlet extends HttpServlet {

    //private static final String FI
    // = "C:\\05_JavaST_2019\\task04_web\\data\\vouchers.xml";

    /**
     * Method for get information on web part.
     * {@inheritDoc}
     * @param request object.
     * @param response object.
     * @throws ServletException for checking exception moments.
     * @throws IOException for checking exception moments.
     */
    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Method for post information on web part.
     * {@inheritDoc}
     * @param request object.
     * @param response object.
     * @throws ServletException for checking exception moments.
     * @throws IOException for checking exception moments.
     */
    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Method for decide different moments.
     * @param request object.
     * @param response object.
     * @throws ServletException for checking exception moments.
     * @throws IOException for checking exception moments.
     */
    private void processRequest(final HttpServletRequest request,
                                final HttpServletResponse response)
            throws ServletException, IOException {
        String element = request.getParameter("browser");
        String file = "C:\\05_JavaST_2019\\task04_web\\data\\"
                + new File(request.getParameter("fload"));

        switch (element) {
            case "dom":
                VouchersDOMBuilder vouchersDOMBuilder
                        = new VouchersDOMBuilder();
                vouchersDOMBuilder.buildSetVouchers(file);
                request.setAttribute("lst",
                        vouchersDOMBuilder.getVouchers());
                break;
            case "sax":
                VouchersSAXBuilder vouchersSAXBuilder
                        = new VouchersSAXBuilder();
                vouchersSAXBuilder.buildSetVouchers(file);
                request.setAttribute("lst",
                        vouchersSAXBuilder.getVouchers());
                break;
            case "stax":
                VouchersStAXBuilder vouchersStAXBuilder
                        = new VouchersStAXBuilder();
                vouchersStAXBuilder.buildSetVouchers(file);
                request.setAttribute("lst",
                        vouchersStAXBuilder.getVouchers());
                break;
                default: break;
        }
        request.getRequestDispatcher(
                "jsp/result.jsp").forward(request, response);
    }
}
