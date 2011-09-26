package es.osoco.chirp.test;

import android.app.Activity;
import android.app.Instrumentation;
import com.jayway.android.robotium.solo.Solo;

public class UberSolo extends Solo {
    public UberSolo(Instrumentation instrumentation, Activity activity) {
        super(instrumentation, activity);
    }

    public void setPortraitScreen() {
        setActivityOrientation(PORTRAIT);
    }

    public void setLandscapeScreen() {
        setActivityOrientation(LANDSCAPE);
    }
}
