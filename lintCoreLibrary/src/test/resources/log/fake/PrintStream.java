package java.io;

/**
 * Created by chentong on 16/8/16.
 */
public class PrintStream {
    public synchronized void println(String str) {
        print(str);
        newline();
    }
}
