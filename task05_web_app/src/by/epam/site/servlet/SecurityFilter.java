package by.epam.site.servlet;


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
//        HttpServletRequest httpRequest = (HttpServletRequest)request;
//        HttpServletResponse httpResponse = (HttpServletResponse)response;
//        HttpSession session = httpRequest.getSession(false);
//
//
//        User user = null;
//        if(session != null) {
//            user = (User)session.getAttribute("user");
//        } else {
//            user = new User();
//            user.setRole(Role.UNAUTHORIZED);
//        }
//        System.out.println(user.getRole());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
