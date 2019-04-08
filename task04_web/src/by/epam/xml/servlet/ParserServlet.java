package by.epam.xml.servlet;

import by.epam.xml.builder.AbstractVouchersBuilder;
import by.epam.xml.builder.VouchersDOMBuilder;
import by.epam.xml.builder.VouchersSAXBuilder;
import by.epam.xml.builder.VouchersStAXBuilder;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
    private static final long serialVersionUID = 1L;

    //private static final String FI
    // = "C:\\05_JavaST_2019\\task04_web\\data\\vouchers.xml";
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ParserServlet.class);
    private File file;

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
                         final HttpServletResponse response) {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException ignored) {
            LOGGER.error("We have exception ServletException | IOException");
        }
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
                          final HttpServletResponse response) {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException ignored) {
            LOGGER.error("We have exception ServletException | IOException");
        }
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

        String file_name = null;
        String file = null;
        response.setContentType("text/html");
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent) {
            return;
        }
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List < FileItem > fields = upload.parseRequest(request);
            Iterator < FileItem > it = fields.iterator();
            if (!it.hasNext()) {
                return;
            }
            while (it.hasNext()) {
                FileItem fileItem = it.next();
                boolean isFormField = fileItem.isFormField();
                if (isFormField) {
                    if (file_name == null) {
                        if (fileItem.getFieldName().equals("browser")) {
                            file_name = fileItem.getString();
                        }
                    }
                } else {
                    if (fileItem.getSize() > 0) {
                        fileItem.write(new File("C:\\05_JavaST_2019\\task04_web\\web\\xml\\" + fileItem.getName()));
                        file = "C:\\05_JavaST_2019\\task04_web\\web\\xml\\" + fileItem.getName();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (file_name) {
            case "dom":
                AbstractVouchersBuilder vouchersDOMBuilder
                        = new VouchersDOMBuilder();
                vouchersDOMBuilder.buildSetVouchers(file);
                request.setAttribute("lst",
                        vouchersDOMBuilder.getVouchers());
                break;
            case "sax":
                AbstractVouchersBuilder vouchersSAXBuilder
                        = new VouchersSAXBuilder();
                vouchersSAXBuilder.buildSetVouchers(file);
                request.setAttribute("lst",
                        vouchersSAXBuilder.getVouchers());
                break;
            case "stax":
                AbstractVouchersBuilder vouchersStAXBuilder
                        = new VouchersStAXBuilder();
                vouchersStAXBuilder.buildSetVouchers(file);
                request.setAttribute("lst",
                        vouchersStAXBuilder.getVouchers());
                break;
            default:
                break;
        }

        request.getRequestDispatcher(
                "jsp/result.jsp").forward(request, response);
    }
}
