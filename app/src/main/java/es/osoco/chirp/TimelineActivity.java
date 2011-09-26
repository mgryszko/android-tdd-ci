package es.osoco.chirp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

public class TimelineActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        List<Chirp> chirps = loadTimeline();
        displayTimeline(chirps);
    }

    private List<Chirp> loadTimeline() {
        return executeJsonRequest("http://10.0.2.2:8080/chirp-server/chirp/timeline?chirper={chirper}", "mgryszko");
    }

    private List<Chirp> executeJsonRequest(String uri, Object... requestParams) {
        RestTemplate restTemplate = new RestTemplate();
        return asList(restTemplate.getForObject(uri, Chirp[].class, requestParams));
    }

    private void displayTimeline(List<Chirp> chirps) {
        TimelineAdapter adapter = new TimelineAdapter();
        adapter.setActivity(this);
        adapter.setChirps(chirps);
        ListView timelineView = (ListView) findViewById(R.id.timelineView);
        timelineView.setAdapter(adapter);
    }
}

