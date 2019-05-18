package by.epam.site.action.factory;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Calendar;

public class JspPage {
    private String page;
    private String tagName;
    private String messageManager;
    private final String model = "model";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getMessageManager() {
        return messageManager;
    }

    public void setMessageManager(String messageManager) {
        this.messageManager = messageManager;
    }

    public String encode(final String encodeMessage) {
        return Base64.getEncoder().encodeToString(encodeMessage.getBytes());
    }

    private String decode(final String encodedMessage) {
        return new String(Base64.getDecoder().decode(encodedMessage));
    }

    public void getModel(final JspPage jspPage,
                            final String encode,
                            final HttpServletRequest request) {
        if (encode == null || encode.length() > 10) {
            request.getSession().setAttribute(model, false);
        } else {
            int encodedSeconds = Integer.parseInt(jspPage.decode(encode));
            Calendar calendar = Calendar.getInstance();
            int secondsNow = calendar.get(Calendar.SECOND);
            if (encodedSeconds + 10 > secondsNow) {
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
