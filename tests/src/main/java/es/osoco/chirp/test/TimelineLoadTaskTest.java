package es.osoco.chirp.test;

import android.test.suitebuilder.annotation.SmallTest;
import es.osoco.chirp.Chirp;
import es.osoco.chirp.ChirpRepository;
import es.osoco.chirp.TimelineLoadListener;
import es.osoco.chirp.TimelineLoadTask;
import org.jmock.Expectations;
import org.jmock.Mockery;
import roboguice.test.RoboUnitTestCase;
import roboguice.util.RoboLooperThread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.util.Arrays.asList;

public class TimelineLoadTaskTest extends RoboUnitTestCase<Application> {

    private static final Chirp A_CHIRP = new Chirp();
    private static final String CHIRPER = "mgryszko";

    private Mockery context = new Mockery();
    private ChirpRepository repository = context.mock(ChirpRepository.class);
    private TimelineLoadListener loadListener = context.mock(TimelineLoadListener.class);
    private CountDownLatch taskDone = new CountDownLatch(1);

    @Override
    protected void tearDown() throws Exception {
        context.assertIsSatisfied();
        super.tearDown();
    }

    @SmallTest
    public void test_loads_timeline_successfully_and_notifies_the_listener() throws Exception {
        TimelineLoadTask task = createTimelineLoadTask();

        context.checking(new Expectations() {{
            List<Chirp> timeline = asList(A_CHIRP);

            oneOf(loadListener).timelineLoading();
            oneOf(repository).findTimelineOf(CHIRPER); will(returnValue(timeline));
            oneOf(loadListener).timelineLoaded(with(timeline));
        }});

        executeInFakeUIThread(task);
    }

    @SmallTest
    public void test_notifies_the_listener_if_the_repository_throws_an_exception() throws Exception {
        TimelineLoadTask task = createTimelineLoadTask();

        context.checking(new Expectations() {{
            allowing(loadListener).timelineLoading();
            oneOf(repository).findTimelineOf(with(any(String.class)));
            will(throwException(new RuntimeException("failure")));
            oneOf(loadListener).timelineLoadError();
        }});

        executeInFakeUIThread(task);
    }

    private TimelineLoadTask createTimelineLoadTask() {
        return new TimelineLoadTask(repository) {
            @Override
            protected void onFinally() throws RuntimeException {
                super.onFinally();
                taskDone.countDown();
            }
        };
    }

    protected void executeInFakeUIThread(final TimelineLoadTask task) throws InterruptedException {
        new RoboLooperThread() {
            public void run() {
                task.setLoadListener(loadListener);
                task.setChirper(CHIRPER);
                task.execute();
            }
        }.start();
        taskDone.await();
    }
}
