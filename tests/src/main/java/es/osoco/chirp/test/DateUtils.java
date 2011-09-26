package es.osoco.chirp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date fromDatetimeStr(String d) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
