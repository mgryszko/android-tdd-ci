package es.osoco.chirp;

import android.os.Bundle;
import android.widget.ListView;
import com.google.inject.Inject;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import java.util.List;

public class TimelineActivity extends RoboActivity implements TimelineLoadListener {
    @Inject
    private TimelineLoadTask loadTask;

    @InjectView(R.id.timelineView)
    private ListView timelineView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        loadTimeline();
    }

    private void loadTimeline() {
        loadTask.setLoadListener(this);
        loadTask.setChirper("mgryszko");
        loadTask.execute();
    }

    private void displayTimeline(List<Chirp> chirps) {
        timelineView.setAdapter(getInjector().getInstance(TimelineAdapter.class).withChirps(chirps));
    }

    public void timelineLoading() {
    }

    public void timelineLoaded(List<Chirp> timeline) {
        displayTimeline(timeline);
    }

    public void timelineLoadError() {
    }
}

