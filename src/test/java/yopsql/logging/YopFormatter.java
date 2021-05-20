package yopsql.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class YopFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getMessage() + "\n";
    }
}
