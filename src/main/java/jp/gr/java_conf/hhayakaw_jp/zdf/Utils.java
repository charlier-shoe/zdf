package jp.gr.java_conf.hhayakaw_jp.zdf;

import java.util.Optional;

/**
 * @author hhayakaw
 *
 */
public class Utils {

    static void printException(Exception e) {
        Optional<Throwable> cause = Optional.ofNullable(e.getCause());
        cause.ifPresent(c -> {
            System.out.println("CAUSE: " + c.getMessage());
            c.printStackTrace();
        });
        System.out.println("EXCEPTION: " + e.getMessage());
        e.printStackTrace();
    }

}
