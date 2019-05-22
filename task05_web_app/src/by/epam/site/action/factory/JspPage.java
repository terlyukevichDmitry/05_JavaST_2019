package by.epam.site.action.factory;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Calendar;

/**
 * This class we use to save jsp page, tag name and message.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class JspPage {
    /**
     * Final value.
     */
    private final int ten = 10;
    /**
     * Page to the next forwarding or send redirecting.
     */
    private String page;
    /**
     * Tag name to get value.
     */
    private String tagName;
    /**
     * message to getting on page.
     */
    private String messageManager;
    /**
     * teg.
     */
    private final String model = "model";

    /**
     * Method to get page.
     * @return page.
     */
    public String getPage() {
        return page;
    }

    /**
     * Method to set page.
     * @param newPage to the next action.
     */
    public void setPage(final String newPage) {
        this.page = newPage;
    }
    /**
     * Method to set page.
     * @param tag to the getting on page info in this tag.
     */
    public void setTagName(final String tag) {
        this.tagName = tag;
    }

    /**
     * Method to encode data.
     * @param encodeMessage message to encode.
     * @return encoded message.
     */
    public String encode(final String encodeMessage) {
        return Base64.getEncoder().encodeToString(encodeMessage.getBytes());
    }

    /**
     * Method to decode data.
     * @param encodedMessage message to encode.
     * @return decoded message.
     */
    private String decode(final String encodedMessage) {
        return new String(Base64.getDecoder().decode(encodedMessage));
    }

    /**
     * Method to getting information on page in tag.
     * @param jspPage page.
     * @param encode message.
     * @param request message.
     */
    public void getModel(final JspPage jspPage,
                            final String encode,
                            final HttpServletRequest request) {
        if (encode == null || encode.length() > ten) {
            request.getSession().setAttribute(model, false);
        } else {
            int encodedSeconds = Integer.parseInt(jspPage.decode(encode));
            Calendar calendar = Calendar.getInstance();
            int secondsNow = calendar.get(Calendar.SECOND);
            if (encodedSeconds + ten > secondsNow) {
                String text = String.valueOf(
                        request.getSession().getAttribute("modelTextInfo"));
                request.getSession().setAttribute("modelText", text);
                request.getSession().setAttribute(model, true);
            } else {
                request.getSession().setAttribute(model, false);
            }
        }
    }

}
