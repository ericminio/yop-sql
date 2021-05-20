package yopsql.domain;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database {
    Connection connection(Configuration configuration) throws SQLException;
}
