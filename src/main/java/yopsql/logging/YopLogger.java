package yopsql.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class YopLogger {

    public static Logger please() {
        Logger logger = Logger.getAnonymousLogger();
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new YopFormatter());
        logger.addHandler(consoleHandler);

        return logger;
    }
}
