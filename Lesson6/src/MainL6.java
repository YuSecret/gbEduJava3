import java.io.IOException;
import java.util.logging.*;

public class MainL6 {
    private static final Logger logger = Logger.getLogger(MainL6.class.getName());

    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.ALL);
        logger.getHandlers()[0].setLevel(Level.ALL);
        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });
//
//        logger.getHandlers()[0].setFilter(new Filter() {
//            @Override
//            public boolean isLoggable(LogRecord record) {
//                return record.getMessage().startsWith("Java");
//            }
//        });

        Handler handler = new FileHandler("mylog.log", true);
        handler.setLevel(Level.ALL);
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });
      //  handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);

        logger.log(Level.SEVERE, "Java");
        logger.log(Level.INFO, "C#");
        logger.log(Level.CONFIG, "python");
        logger.log(Level.FINE, "sql");
    }
}
