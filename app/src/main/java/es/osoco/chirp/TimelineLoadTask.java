package es.osoco.chirp;

import com.google.inject.Inject;
import roboguice.util.RoboAsyncTask;

import java.util.List;

public class TimelineLoadTask extends RoboAsyncTask<List<Chirp>> implements AsyncTimelineLoader {
    private ChirpRepository repository;
    private TimelineLoadListener loadListener;
    private String chirper;

    @Inject
    public TimelineLoadTask(ChirpRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void onPreExecute() throws Exception {
        loadListener.timelineLoading();
    }

    public List<Chirp> call() throws Exception {
        return repository.findTimelineOf(chirper);
    }

    @Override
    protected void onSuccess(List<Chirp> chirps) throws Exception {
        loadListener.timelineLoaded(chirps);
    }

    @Override
    protected void onException(Exception e) throws RuntimeException {
        loadListener.timelineLoadError();
    }

    public void loadChirperTimeline(String chirper, TimelineLoadListener loadListener) {
        this.chirper = chirper;
        this.loadListener = loadListener;
        this.execute();
    }
}
