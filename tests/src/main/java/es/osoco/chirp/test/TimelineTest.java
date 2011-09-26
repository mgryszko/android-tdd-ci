package es.osoco.chirp.test;

import android.test.ActivityInstrumentationTestCase2;
import es.osoco.chirp.TimelineActivity;

public class TimelineTest extends ActivityInstrumentationTestCase2<TimelineActivity> {

    public static final String PKG = "es.osoco.chirp";

    public TimelineTest() {
        super(PKG, TimelineActivity.class);
    }

    public void testActivity() {
        TimelineActivity activity = getActivity();
        assertNotNull(activity);
    }
}
