package core.Logger.TestLogger;

/**
 * Created by Administrator on 2016/9/5.
 */
public class Loggers {

    public final static Logger getLogger(Class<?> clazz) {
        final byte level = Logger.LEVEL_INFO;
        return new ConsoleLogger(clazz, level);
    }
}
