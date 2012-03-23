package es.osoco.chirp.test;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.google.inject.Inject;
import com.xtremelabs.robolectric.Robolectric;
import es.osoco.chirp.R;
import es.osoco.chirp.TimelineActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(InjectingTestRunner.class)
public class TimelineUnitTest {
    private static final Bundle NO_SAVED_INSTANCE_STATE = null;

    @Inject
    private TimelineActivity activity;

    @Inject
    private AsyncTimelineLoaderStub timelineLoader;

    @Inject
    private ProgressDialog progressDialog;

    @Test
    public void checks_application_name() throws Exception {
        String appName = activity.getResources().getString(R.string.app_name);
        assertThat(appName, equalTo("Chirp"));
    }

    @Test
    public void triggers_timeline_loading() {
        activity.onCreate(NO_SAVED_INSTANCE_STATE);
        assertThat(timelineLoader.isTimelineLoaded(), is(true));
    }

    @Test
    public void progress_dialog_is_displayed_when_timeline_is_loaded() {
        activity.timelineLoading();
        assertThat(Robolectric.shadowOf(activity).getLastShownDialogId(), is(TimelineActivity.PROGRESS_DIALOG_ID));
    }
}
