package yopsql.domain;

import org.junit.Before;
import org.junit.Test;
import yopsql.logging.LogSink;
import yopsql.support.PropertyProviderUsingMap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class YopSqlStartTest {

    YopSql yopSql;
    LogSink logSink;
    private PropertyProviderUsingMap propertyProvider;

    @Before
    public void sut() throws IOException {
        yopSql = new YopSql();
        logSink = new LogSink();
        yopSql.logger = logSink.getLogger();
        yopSql.connectionTest.logger = logSink.getLogger();

        propertyProvider = new PropertyProviderUsingMap();
        propertyProvider.setConfig("src/test/resources/configuration.json");
        propertyProvider.setInput("/this/input");
        propertyProvider.setOutput("/this/output");
        yopSql.environment.setPropertyProvider(propertyProvider);


    }

    @Test
    public void startingLogMessage() {
        yopSql.start();
        assertThat(logSink.getLog(), containsString("Starting YopSql"));
    }

    @Test
    public void disclosesConfiguration() {
        yopSql.start();
        assertThat(logSink.getLog(), containsString("config = src/test/resources/configuration.json"));
    }

    @Test
    public void disclosesInputFile() {
        yopSql.start();
        assertThat(logSink.getLog(), containsString("input = /this/input"));
    }

    @Test
    public void disclosesOutputFile() {
        yopSql.start();
        assertThat(logSink.getLog(), containsString("output = /this/output"));
    }

    @Test
    public void disclosesConnectionTestSuccess() {
        yopSql.connectionTest.database = new Database() {
            @Override
            public Connection connection(Configuration configuration) throws SQLException {
                return null;
            }
        };
        yopSql.start();
        assertThat(logSink.getLog(), containsString("Connection test to this-url"));
        assertThat(logSink.getLog(), containsString("Connection test successful"));
    }

    @Test
    public void disclosesConnectionTestFailure() {
        yopSql.connectionTest.database = new Database() {
            @Override
            public Connection connection(Configuration configuration) throws SQLException {
                throw new SQLException();
            }
        };
        yopSql.start();
        assertThat(logSink.getLog(), containsString("Connection test to this-url"));
        assertThat(logSink.getLog(), containsString("Connection test failed"));
        assertThat(logSink.getLog(), containsString("Exiting"));
    }
}
