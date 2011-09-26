package es.osoco.chirp;

import roboguice.util.RoboAsyncTask;

import java.util.List;

public class TimelineLoadTask extends RoboAsyncTask<List<Chirp>> {
    private ChirpRepository repository;
    private String chirper;

    public TimelineLoadTask(ChirpRepository repository) {
        this.repository = repository;
    }

    public void setChirper(String chirper) {
        this.chirper = chirper;
    }

    public List<Chirp> call() throws Exception {
        return repository.findTimelineOf(chirper);
    }
}
