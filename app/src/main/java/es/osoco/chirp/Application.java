package es.osoco.chirp;

import com.google.inject.Module;
import roboguice.application.RoboApplication;

import java.util.List;

public class Application extends RoboApplication {
    private Module module = new ChirpModule();

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    protected void addApplicationModules(List<Module> modules) {
        modules.add(module);
    }
}
