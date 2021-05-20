package yopsql.domain;

import org.junit.Before;
import org.junit.Test;
import yopsql.logging.LogSink;
import yopsql.support.PropertyProviderUsingMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class YopSqlStartTest {

    YopSql yopSql;
    LogSink logSink;
    private PropertyProviderUsingMap propertyProvider;

    @Before
    public void sut() {
        yopSql = new YopSql();
        logSink = new LogSink();
        yopSql.logger = logSink.getLogger();
        yopSql.connectionTest.logger = logSink.getLogger();

        propertyProvider = new PropertyProviderUsingMap();
        propertyProvider.setConfig("/this/config");
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
        assertThat(logSink.getLog(), containsString("config = /this/config"));
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
        propertyProvider.setConfig("src/test/resources/local-oracle.json");
        yopSql.start();
        assertThat(logSink.getLog(), containsString("Connection test to jdbc:oracle:thin:@localhost:1521:XE"));
        assertThat(logSink.getLog(), containsString("Connection test successful"));
    }

    @Test
    public void disclosesConnectionTestFailure() {
        propertyProvider.setConfig("src/test/resources/broken-connection.json");
        yopSql.start();
        assertThat(logSink.getLog(), containsString("Connection test to broken-url"));
        assertThat(logSink.getLog(), containsString("Connection test failed"));
        assertThat(logSink.getLog(), containsString("Done"));
    }
}
