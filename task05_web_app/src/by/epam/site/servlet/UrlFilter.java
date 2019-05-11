package by.epam.site.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UrlFilter implements Filter {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(UrlFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest
                    = (HttpServletRequest) request;
            String contextPath = httpServletRequest.getContextPath();
            String url = httpServletRequest.getRequestURI();
            LOGGER.debug(String.format("Starting of processing of request for URI \"%s\"", url));
            int beginAction = contextPath.length();
            int endAction = url.lastIndexOf('.');
            String actionName;
            if(endAction >= 0) {
                actionName = url.substring(beginAction, endAction);
            } else {
                actionName = url.substring(beginAction);
            }
            if (actionName.isEmpty()) {
                actionName += '/';
            }
            httpServletRequest.setAttribute("action", actionName);
            chain.doFilter(request, response);
        } else {
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
