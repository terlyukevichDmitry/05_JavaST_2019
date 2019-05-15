package by.epam.site.action.factory;

import java.util.Base64;

public class JspPage {
    private String page;
    private String tagName;
    private String messageManager;

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

    public String decode(final String encodedMessage) {
        return new String(Base64.getDecoder().decode(encodedMessage));
    }

}
