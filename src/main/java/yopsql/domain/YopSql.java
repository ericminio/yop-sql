package yopsql.domain;

import java.util.logging.Logger;

import static java.lang.String.format;

public class YopSql {
    public Logger logger = Logger.getLogger(YopSql.class.getName());
    public Environment environment = new Environment();

    public void start() {
        logger.info("Starting YopSql");
        logger.info(format("config = %s", environment.getConfig()));
        logger.info(format("input = %s", environment.getInput()));
        logger.info(format("output = %s", environment.getOutput()));
    }
}
