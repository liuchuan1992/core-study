package core.Logger.TestLogger;

/**
 * Created by Administrator on 2016/9/5.
 */
public class TestLogger
{
    public static final Logger logger = Loggers.getLogger(TestLogger.class);

    public static void main(String[] args){

        logger.debug("hello");
    }
}
