package es.osoco.chirp.test;

import android.app.Instrumentation;
import roboguice.application.RoboApplication;

public class Application extends RoboApplication
{
    public Application()
    {
    }

    public Application(Instrumentation instrumentation)
    {
        super();
        attachBaseContext(instrumentation.getTargetContext());
    }
}
