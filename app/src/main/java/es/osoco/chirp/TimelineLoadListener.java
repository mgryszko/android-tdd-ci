package es.osoco.chirp;

import java.util.List;

public interface TimelineLoadListener {
    void timelineLoading();

    void timelineLoaded(List<Chirp> timeline);

    void timelineLoadError();
}
