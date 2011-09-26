package es.osoco.chirp.test;

import es.osoco.chirp.DateFormatter;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DateFormatterTest {
    @Test
    public void test_formats_a_datetime_using_the_ISO8601_extended_date_format() {
        Calendar date = new GregorianCalendar(2011, Calendar.JUNE, 15, 20, 5, 15);
        assertThat(DateFormatter.toDatetimeStr(date.getTime()), equalTo("2011-06-15 20:05:15"));
    }
}
