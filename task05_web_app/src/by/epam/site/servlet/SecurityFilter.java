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
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
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

        AccessController lol = new AccessController();
        if (lol.getAccess(user.getRole()).checkAccess(path)) {
            chain.doFilter(request, response);
        } else {
            httpRequest.getSession().setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("access"));
            httpResponse.sendRedirect(httpRequest.getContextPath()
                    + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}
