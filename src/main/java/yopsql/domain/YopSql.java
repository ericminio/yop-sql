package yopsql.domain;

import yopsql.logging.YopLogger;

import java.util.logging.Logger;

public class YopSql {
    public Logger logger = YopLogger.please();

    public void start() {
        logger.info("Starting YopSql");
    }
}
