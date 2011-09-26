package es.osoco.chirp.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import es.osoco.chirp.TimelineActivity;

import static es.osoco.chirp.test.ChirpAsserts.assertTimelineEqualTo;
import static es.osoco.chirp.test.ChirpFixtures.mgryszkosChirps;

public class TimelineTest extends ActivityInstrumentationTestCase2<TimelineActivity> {

    public static final String PKG = "es.osoco.chirp";

    private UberSolo solo;
    private TimelineDriver timelineDriver;

    public TimelineTest() {
        super(PKG, TimelineActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new UberSolo(getInstrumentation(), getActivity());
        timelineDriver = new TimelineDriver(solo);
    }

    @Override
    protected void tearDown() {
        try {
            solo.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @LargeTest
    public void test_chirps_are_displayed_timely_ordered() throws Exception {
        solo.setPortraitScreen();
        waitAndAssertTimelineEqualTo();

        solo.setLandscapeScreen();
        waitAndAssertTimelineEqualTo();
    }

    private void waitAndAssertTimelineEqualTo() {
        timelineDriver.waitUntilTimelineLoaded(mgryszkosChirps().size());
        assertTimelineEqualTo(timelineDriver.getDisplayedTimeline(), mgryszkosChirps());
    }
}
