package yopsql.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class YopFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StackTraceElement from = null;
        try {
            throw new RuntimeException("inspect");
        }
        catch (RuntimeException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i=0; i<stackTrace.length; i++) {
                StackTraceElement element = stackTrace[i];
                if (element.getClassName().startsWith("yopsql") &&
                    element.getClassName().indexOf(this.getClass().getName()) == -1) {
                    from = element;
                    break;
                }
            }
        }
        return "[" + record.getLevel().getName() + "] " + from + " - " + record.getMessage() + "\n";
    }
}
