package yopsql.logging;

import java.io.ByteArrayOutputStream;
import java.util.logging.*;

public class LogSink {

    private final Logger logger;
    private ByteArrayOutputStream inMemoryLogData;
    private StreamHandler inMemoryHandler;

    public LogSink() {
        logger = Logger.getAnonymousLogger();
        logger.setUseParentHandlers(false);
        inMemoryLogData = new ByteArrayOutputStream();
        inMemoryHandler = new StreamHandler(inMemoryLogData, new YopFormatter());
        logger.addHandler(inMemoryHandler);
    }

    public Logger getLogger() {
        return logger;
    }

    public String getLog() {
        inMemoryHandler.flush();
        return inMemoryLogData.toString();
    }
}
