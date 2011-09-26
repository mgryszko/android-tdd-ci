package es.osoco.chirp.test;

import android.test.suitebuilder.annotation.MediumTest;
import es.osoco.chirp.ChirpJsonRepository;
import es.osoco.chirp.ChirpRepository;
import junit.framework.TestCase;

import static es.osoco.chirp.test.ChirpAsserts.assertTimelineEqualTo;
import static es.osoco.chirp.test.ChirpFixtures.mgryszkosChirps;

public class ChirpJsonRepositoryTest extends TestCase {
    private ChirpRepository repository = new ChirpJsonRepository();

    @MediumTest
    public void test_returns_the_timeline_of_a_chirper() {
        assertTimelineEqualTo(repository.findTimelineOf("mgryszko"), mgryszkosChirps());
    }
}
