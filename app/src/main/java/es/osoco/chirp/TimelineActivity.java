package es.osoco.chirp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import com.google.inject.Inject;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import java.util.List;

public class TimelineActivity extends RoboActivity implements TimelineLoadListener {
    private static final int PROGRESS_DIALOG_ID = 0;

    @Inject
    private TimelineLoadTask loadTask;

    @InjectView(R.id.timelineView)
    private ListView timelineView;

    @Inject
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        loadTimeline();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        return progressDialog;
    }

    private void loadTimeline() {
        loadTask.setLoadListener(this);
        loadTask.setChirper("mgryszko");
        loadTask.execute();
    }

    public void timelineLoading() {
        showDialog(PROGRESS_DIALOG_ID);
    }

    public void timelineLoaded(List<Chirp> timeline) {
        removeDialog(PROGRESS_DIALOG_ID);
        displayTimeline(timeline);
    }

    public void timelineLoadError() {
        removeDialog(PROGRESS_DIALOG_ID);
    }

    private void displayTimeline(List<Chirp> chirps) {
        timelineView.setAdapter(getInjector().getInstance(TimelineAdapter.class).withChirps(chirps));
    }
}
