package es.osoco.chirp.test;

import com.google.inject.Singleton;
import es.osoco.chirp.AsyncTimelineLoader;
import es.osoco.chirp.TimelineLoadListener;

@Singleton
public class AsyncTimelineLoaderStub implements AsyncTimelineLoader
{
    private boolean timelineLoaded = false;

    public boolean isTimelineLoaded() {
        return timelineLoaded;
    }

    public void loadChirperTimeline(String chirper, TimelineLoadListener loadListener) {
        timelineLoaded = true;
    }
}
