package es.osoco.chirp.test;

import es.osoco.chirp.Chirp;

import java.util.List;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ChirpAsserts {
    static void assertTimelineEqualTo(List<Chirp> actual, List<Chirp> expected) {
        assertThat(actual.size(), equalTo(expected.size()));
        for (Chirp chirp : expected) {
            assertThat(format("Chirp %s not in the timeline", chirp), actual, hasItem(chirp));
        }
    }
}
