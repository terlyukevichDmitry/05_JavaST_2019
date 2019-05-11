package by.epam.site.action.factory;

import by.epam.site.action.command.MessageManager;

import javax.servlet.http.HttpServletRequest;

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

    public void checkMistake(HttpServletRequest request) {
        if (tagName != null && messageManager != null) {
            if (request.getParameter("a") != null && request.getParameter("a").equals("b")) {
                request.setAttribute(tagName, messageManager);
            }
        }
    }

}
