package es.osoco.chirp.test;

import android.widget.ListView;
import android.widget.TableRow;
import com.jayway.android.robotium.solo.Solo;
import es.osoco.chirp.Chirp;
import es.osoco.chirp.R;

import java.util.ArrayList;
import java.util.List;

public class TimelineDriver {
    private static final int TIMEOUT = 5000;

    private Solo solo;

    public TimelineDriver(Solo solo) {

        this.solo = solo;
    }

    public void waitUntilTimelineLoaded(int timelineSize) {
        solo.waitForView(TableRow.class, timelineSize, TIMEOUT);
    }

    public List<Chirp> getDisplayedTimeline() {
        ListView timelineView = (ListView) solo.getView(R.id.timelineView);
        List<Chirp> chirps = new ArrayList<Chirp>();
        for (int i = 0; i < timelineView.getCount(); i++) {
            chirps.add((Chirp) timelineView.getItemAtPosition(i));
        }
        return chirps;
    }
}
