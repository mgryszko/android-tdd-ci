package es.osoco.chirp.test;

import android.test.suitebuilder.annotation.SmallTest;
import es.osoco.chirp.Chirp;
import es.osoco.chirp.ChirpRepository;
import es.osoco.chirp.TimelineLoadTask;
import org.jmock.Expectations;
import org.jmock.Mockery;
import roboguice.test.RoboUnitTestCase;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TimelineLoadTaskTest extends RoboUnitTestCase<Application> {

    private static final Chirp A_CHIRP = new Chirp();
    private static final String CHIRPER = "mgryszko";

    private Mockery context = new Mockery();

    @Override
    protected void tearDown() throws Exception {
        context.assertIsSatisfied();
        super.tearDown();
    }

    @SmallTest
    public void test_loads_timeline_successfully_and_notifies_the_listener() throws Exception {
        final ChirpRepository repository = context.mock(ChirpRepository.class);
        TimelineLoadTask task = new TimelineLoadTask(repository);
        task.setChirper(CHIRPER);
        final List<Chirp> timeline = asList(A_CHIRP);

        context.checking(new Expectations() {{
            oneOf(repository).findTimelineOf(CHIRPER);
            will(returnValue(timeline));
        }});

        assertThat(task.call(), equalTo(timeline));
    }
}
