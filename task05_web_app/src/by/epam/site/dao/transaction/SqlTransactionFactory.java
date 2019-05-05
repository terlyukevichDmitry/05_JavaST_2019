package by.epam.site.dao.transaction;

public interface SqlTransactionFactory {
    void close();
    SqlTransaction createSqlTransaction();
}
