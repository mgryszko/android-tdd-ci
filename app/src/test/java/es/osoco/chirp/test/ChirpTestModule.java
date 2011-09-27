package es.osoco.chirp.test;

import es.osoco.chirp.AsyncTimelineLoader;
import roboguice.config.AbstractAndroidModule;

public class ChirpTestModule extends AbstractAndroidModule {
    @Override
    protected void configure() {
        bind(AsyncTimelineLoader.class).to(AsyncTimelineLoaderStub.class);
    }
}
