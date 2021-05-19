package yopsql.domain;

import org.junit.Before;
import org.junit.Test;
import yopsql.logging.LogSink;

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
}
