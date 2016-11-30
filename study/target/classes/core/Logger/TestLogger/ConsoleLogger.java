package core.Logger.TestLogger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/5.
 * ConsoleLogger
 */
public class ConsoleLogger implements Logger {

    private byte level;
    private String name;

    public ConsoleLogger(Class<?> clazz, byte level) {
        this.name = clazz.getName();
        this.level = level;
    }

    public void info(String msg) {
        if (level >= LEVEL_INFO) {
            return;
        }
        System.out.println("[Spiderman][消息][" + name + "]" + formatNow() + "\r\n" + msg + "\r\n");
    }

    public void debug(String msg) {
        if (level >= LEVEL_DEBUG) {
            return;
        }
        System.out.println("[Spiderman][调试][" + name + "]" + formatNow() + "\r\n" + msg + "\r\n");
    }

    public void warn(String msg) {
        if (level >= LEVEL_WARN) {
            return;
        }
        System.err.println("[Spiderman][警告][" + name + "]" + formatNow() + "\r\n" + msg + "\r\n");
    }

    public void error(String err, Throwable e) {
        if (level >= LEVEL_ERROR) {
            return;
        }

        System.err.println("[Spiderman][错误][" + name + "]" + formatNow() + "\r\n" + err + "\r\n");
        e.printStackTrace();
    }

    private String formatNow(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}

