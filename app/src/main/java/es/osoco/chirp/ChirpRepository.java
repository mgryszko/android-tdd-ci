package es.osoco.chirp;

import java.util.List;

public interface ChirpRepository {
    List<Chirp> findTimelineOf(String chirper);
}
