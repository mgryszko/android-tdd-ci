package es.osoco.chirp;

public interface AsyncTimelineLoader
{
    void loadChirperTimeline(String chirper, TimelineLoadListener loadListener);
}
