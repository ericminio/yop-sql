package yopsql.domain;

import yopsql.support.BuildConfiguration;
import yopsql.support.Read;

import java.io.IOException;
import java.util.logging.Logger;

import static java.lang.String.format;

public class YopSql {
    public Logger logger = Logger.getLogger(YopSql.class.getName());
    public Environment environment = new Environment();
    public ConnectionTest connectionTest = new ConnectionTest();

    public void start() {
        logger.info("Starting YopSql");
        logger.info(format("config = %s", environment.getConfig()));
        logger.info(format("input = %s", environment.getInput()));
        logger.info(format("output = %s", environment.getOutput()));

        try {
            connectionTest.please(getConfiguration());
        } catch (Exception e) {
            logger.info("Exiting");
        }
    }

    public Configuration getConfiguration() throws IOException {
        return new BuildConfiguration().please(new Read().file(environment.getConfig()));
    }
}
