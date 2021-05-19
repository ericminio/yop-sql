package yopsql.domain;

import yopsql.logging.YopLogger;

import java.util.logging.Logger;

public class YopSql {
    public Logger logger = YopLogger.please();
    public Environment environment = new Environment();

    public void start() {
        logger.info("Starting YopSql");
        logger.info("config = " + environment.getConfig());
        logger.info("input = " + environment.getInput());
        logger.info("output = " + environment.getOutput());
    }
}
