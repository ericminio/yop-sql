package yopsql.domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import static java.lang.String.format;

public class ConnectionTest {
    public Logger logger = Logger.getLogger(ConnectionTest.class.getName());
    public Database database = new DatabaseUsingOjdbc();

    public Connection please(Configuration configuration) {
        logger.info(format("Connection test to %s", configuration.getUrl()));
        Connection connection = null;
        try {
            connection = database.connection(configuration);
        } catch (SQLException connecting) {
            logger.info("Connection test failed");
            throw new RuntimeException(connecting);
        }
        logger.info("Connection test successful");
        return connection;
    }
}
