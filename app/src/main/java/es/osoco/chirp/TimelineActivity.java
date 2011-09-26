package es.osoco.chirp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TimelineActivity extends Activity {

    private static String TAG = "chirp";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.timeline);
    }
}

