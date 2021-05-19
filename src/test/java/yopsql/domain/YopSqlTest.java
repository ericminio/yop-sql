package yopsql.domain;

import org.junit.Before;
import org.junit.Test;
import yopsql.logging.LogSink;
import yopsql.support.PropertyProviderUsingMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class YopSqlTest {

    YopSql yopSql;
    LogSink logSink;

    @Before
    public void sut() {
        yopSql = new YopSql();
        logSink = new LogSink();
        yopSql.logger = logSink.getLogger();
    }

    @Test
    public void startingLogMessage() {
        yopSql.start();
        assertThat(logSink.getLog(), containsString("Starting YopSql"));
    }

    @Test
    public void disclosesConfiguration() {
        PropertyProviderUsingMap propertyProvider = new PropertyProviderUsingMap();
        propertyProvider.setConfig("/this/config");
        yopSql.environment.setPropertyProvider(propertyProvider);
        yopSql.start();
        assertThat(logSink.getLog(), containsString("config = /this/config"));
    }

    @Test
    public void disclosesInputFile() {
        PropertyProviderUsingMap propertyProvider = new PropertyProviderUsingMap();
        propertyProvider.setInput("/this/input");
        yopSql.environment.setPropertyProvider(propertyProvider);
        yopSql.start();
        assertThat(logSink.getLog(), containsString("input = /this/input"));
    }

    @Test
    public void disclosesOutputFile() {
        PropertyProviderUsingMap propertyProvider = new PropertyProviderUsingMap();
        propertyProvider.setOutput("/this/output");
        yopSql.environment.setPropertyProvider(propertyProvider);
        yopSql.start();
        assertThat(logSink.getLog(), containsString("output = /this/output"));
    }
}
