package by.epam.site.teg;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Locale;

@SuppressWarnings("serial")
public class InfoTimeTag extends TagSupport {
    private String role;
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public int doStartTag() throws JspException {
        try {
            String to = null;
            if ("administrator".equalsIgnoreCase(role)) {
                pageContext.getOut().write("Hello, " + role);
            }
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

}
