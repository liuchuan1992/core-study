package core.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lvcf on 2016/9/20 19:12
 * study
 */
public class TestLog {

    private static final Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) {
        logger.info("hello");
    }
}
