package by.epam.xml.servlet;

import by.epam.xml.builder.VouchersDOMBuilder;

import java.io.IOException;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

    private static final String fi = "C:\\05_JavaST_2019\\task04_web\\data\\vouchers.xml";

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
        GregorianCalendar gc = new GregorianCalendar();
        String timeJsp = request.getParameter("time");
        float delta = ((float)(gc.getTimeInMillis() - Long.parseLong(timeJsp)))/ 1_000;
        //request.setAttribute("res", delta);

        VouchersDOMBuilder vouchersDOMBuilder = new VouchersDOMBuilder();
        vouchersDOMBuilder.buildSetVouchers(fi);
        request.setAttribute("lst", vouchersDOMBuilder.getVouchers());
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
    }
}