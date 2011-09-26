package es.osoco.chirp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.inject.Inject;

import java.util.List;

public class TimelineAdapter extends BaseAdapter {
    @Inject
    private LayoutInflater inflater;

    private List<Chirp> chirps;

    public ListAdapter withChirps(List<Chirp> chirps) {
        this.chirps = chirps;
        return this;
    }

    public int getCount() {
        return chirps.size();
    }

    public Chirp getItem(int i) {
        return chirps.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View chirpView = inflater.inflate(R.layout.timeline_item, null);

        Chirp chirp = getItem(i);

        TextView who = (TextView) chirpView.findViewById(R.id.who);
        who.setText(chirp.getWho());

        TextView message = (TextView) chirpView.findViewById(R.id.message);
        message.setText(chirp.getMessage());

        TextView timestamp = (TextView) chirpView.findViewById(R.id.timestamp);
        timestamp.setText(chirp.getTimestamp().toString());

        return chirpView;
    }
}
