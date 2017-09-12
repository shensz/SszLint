package android.util;

/**
 * Created by chentong on 16/8/16.
 */
public class Log {
    public static int i(String tag, String msg) {
        return println(LOG_ID_MAIN, INFO, tag, msg);
    }
}
