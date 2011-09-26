package es.osoco.chirp;

import com.google.inject.Module;
import roboguice.application.RoboApplication;

import java.util.List;

public class Application extends RoboApplication {
    @Override
    protected void addApplicationModules(List<Module> modules) {
        modules.add(new ChirpModule());
    }
}
