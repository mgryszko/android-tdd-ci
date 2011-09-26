package es.osoco.chirp;

import android.app.ProgressDialog;
import roboguice.config.AbstractAndroidModule;

public class ChirpModule extends AbstractAndroidModule {
    @Override
    protected void configure() {
        bind(ChirpRepository.class).to(ChirpJsonRepository.class);
        bind(ProgressDialog.class).toProvider(LoadingDialogProvider.class);
    }
}
