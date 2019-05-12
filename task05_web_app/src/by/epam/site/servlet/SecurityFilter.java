package by.epam.site.servlet;


import by.epam.site.action.access.AccessController;
import by.epam.site.action.command.MessageManager;
import by.epam.site.entity.Role;
import by.epam.site.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String path = (String) request.getAttribute("action");

        HttpSession session = httpRequest.getSession(false);
        User user = null;
        if (session == null || session.getAttribute("user") == null) {
            user = new User();
            user.setRole(Role.UNAUTHORIZED);
        } else {
            user = (User) session.getAttribute("user");
        }

        AccessController controller = new AccessController();
        if (controller.getAccess(user.getRole()).checkAccess(path)) {
            chain.doFilter(request, response);
        } else {
            httpRequest.getSession().setAttribute("notAccess",
                    MessageManager.getProperty("access"));
            httpResponse.sendRedirect(httpRequest.getContextPath()
                    + "/login?a=problemWithYourAccess");
        }
    }

    @Override
    public void destroy() {
    }
}
