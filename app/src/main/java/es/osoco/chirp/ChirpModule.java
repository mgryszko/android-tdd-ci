package es.osoco.chirp;

import roboguice.config.AbstractAndroidModule;

public class ChirpModule extends AbstractAndroidModule {
    @Override
    protected void configure() {
        bind(ChirpRepository.class).to(ChirpJsonRepository.class);
    }
}
