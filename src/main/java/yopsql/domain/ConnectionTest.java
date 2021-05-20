package yopsql.domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import static java.lang.String.format;

public class ConnectionTest {
    public Logger logger = Logger.getLogger(ConnectionTest.class.getName());

    public Connection please(Configuration configuration) {
        logger.info(format("Connection test to %s", configuration.getUrl()));
        Connection connection = null;
        try {
            connection = new Database().connection(configuration);
        } catch (SQLException throwables) {
            logger.info("Connection test failed");
        }
        finally {
            logger.info("Connection test successful");
            return connection;
        }
    }
}
