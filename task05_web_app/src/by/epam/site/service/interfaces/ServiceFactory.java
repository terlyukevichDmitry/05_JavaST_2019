package by.epam.site.service.interfaces;

public interface ServiceFactory {
    <Type extends Service> Type getService(Class<Type> key);
    void close();
}
