package es.osoco.chirp;

import android.app.ProgressDialog;
import android.content.Context;
import com.google.inject.Inject;
import com.google.inject.Provider;
import roboguice.inject.InjectResource;

import static android.app.ProgressDialog.STYLE_SPINNER;

public class LoadingDialogProvider implements Provider<ProgressDialog> {
    @Inject
    private Context context;

    @InjectResource(R.string.loading)
    private String loading;

    public ProgressDialog get() {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(STYLE_SPINNER);
        progressDialog.setMessage(loading);
        return progressDialog;
    }
}
