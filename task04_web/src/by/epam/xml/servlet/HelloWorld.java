package by.epam.xml.servlet;

import by.epam.xml.builder.AbstractVouchersBuilder;
import by.epam.xml.builder.VouchersDOMBuilder;
import by.epam.xml.builder.VouchersStAXBuilder;
import by.epam.xml.entity.Voucher;
import by.epam.xml.entity.Vouchers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("HelloWorld")
public class HelloWorld extends HttpServlet {
    private String domParser;
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "vouchers.xml";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("Hello suka ajsdlkasjdl ajs das das dasd ");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        domParser = req.getParameter("browser");
        String saxParser = req.getParameter("browser");
        String staxParser = req.getParameter("browser");
        PrintWriter out = resp.getWriter();
        if(domParser.equals("dom")) {
            resp.sendRedirect("file.html");
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
