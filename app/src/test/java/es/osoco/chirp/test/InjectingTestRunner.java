package es.osoco.chirp.test;

import com.google.inject.Injector;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import es.osoco.chirp.Application;
import org.junit.runners.model.InitializationError;
import roboguice.inject.ContextScope;

public class InjectingTestRunner extends RobolectricTestRunner {

    public InjectingTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected android.app.Application createApplication() {
        Application application = (Application) super.createApplication();
        application.setModule(new ChirpTestModule());
        return application;
    }

    @Override
    public void prepareTest(Object test) {
        Application application = (Application) Robolectric.application;

        Injector injector = application.getInjector();
        ContextScope scope = injector.getInstance(ContextScope.class);
        scope.enter(application);

        injector.injectMembers(test);
    }
}
