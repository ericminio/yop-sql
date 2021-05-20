package yopsql.domain;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private OracleDataSource dataSource;

    public Connection connection(Configuration configuration) throws SQLException {
        return getDataSource(configuration).getConnection();
    }

    private OracleDataSource getDataSource(Configuration configuration) throws SQLException {
        if (this.dataSource == null) {
            this.dataSource = new OracleDataSource();
            this.dataSource.setURL(configuration.getUrl());
            this.dataSource.setUser(configuration.getUsername());
            this.dataSource.setPassword(configuration.getPassword());
        }
        return dataSource;
    }
}
