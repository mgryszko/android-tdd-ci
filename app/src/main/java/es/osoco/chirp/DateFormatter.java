package es.osoco.chirp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static String toDatetimeStr(Date dt) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt);
    }
}
