package es.osoco.chirp;

import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

public class ChirpJsonRepository implements ChirpRepository {
    public List<Chirp> findTimelineOf(String chirper) {
        return executeJsonRequest("http://10.0.2.2:8080/chirp-server/chirp/timeline?chirper={chirper}", chirper);
    }

    private List<Chirp> executeJsonRequest(String uri, Object... requestParams) {
        RestTemplate restTemplate = new RestTemplate();
        return asList(restTemplate.getForObject(uri, Chirp[].class, requestParams));
    }
}
