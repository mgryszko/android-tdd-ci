package es.osoco.chirp;

import android.os.Bundle;
import android.widget.ListView;
import com.google.inject.Inject;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import java.util.List;

public class TimelineActivity extends RoboActivity {
    @Inject
    private ChirpRepository chirpRepository;

    @InjectView(R.id.timelineView)
    private ListView timelineView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        List<Chirp> chirps = loadTimeline();
        displayTimeline(chirps);
    }

    private List<Chirp> loadTimeline() {
        return chirpRepository.findTimelineOf("mgryszko");
    }

    private void displayTimeline(List<Chirp> chirps) {
        timelineView.setAdapter(getInjector().getInstance(TimelineAdapter.class).withChirps(chirps));
    }
}
