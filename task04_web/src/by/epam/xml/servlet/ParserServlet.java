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

public class ParserServlet extends HttpServlet {

    //private static final String FI = "C:\\05_JavaST_2019\\task04_web\\data\\vouchers.xml";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String element = request.getParameter("browser");
        String file = "C:\\05_JavaST_2019\\task04_web\\data\\" + new File(request.getParameter("fload"));

        switch (element) {
            case "dom":
                VouchersDOMBuilder vouchersDOMBuilder = new VouchersDOMBuilder();
                vouchersDOMBuilder.buildSetVouchers(file);
                request.setAttribute("lst", vouchersDOMBuilder.getVouchers());
                break;
            case "sax":
                VouchersSAXBuilder vouchersSAXBuilder = new VouchersSAXBuilder();
                vouchersSAXBuilder.buildSetVouchers(file);
                request.setAttribute("lst", vouchersSAXBuilder.getVouchers());
                break;
            case "stax":
                VouchersStAXBuilder vouchersStAXBuilder = new VouchersStAXBuilder();
                vouchersStAXBuilder.buildSetVouchers(file);
                request.setAttribute("lst", vouchersStAXBuilder.getVouchers());
                break;
                default: break;
        }
        request.getRequestDispatcher(
                "jsp/result.jsp").forward(request, response);
    }
}