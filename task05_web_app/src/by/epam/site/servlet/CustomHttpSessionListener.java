package by.epam.site.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CustomHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event){
        event.getSession().setMaxInactiveInterval(15*60);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent event){
        HttpServletRequest request = (HttpServletRequest) event;
        request.getSession().invalidate();
    }
}
