package devjam.emilab.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import devjam.emilab.model.SpotifyResponse;
import devjam.emilab.repo.SpotifyResponseRepo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyService {
    private final String CLIENT_ID = "34cdc8a627c84602bffdab1d5ed5c488";
    private final String CLIENT_SECRET = "9a7fec41e35b4cb7b5a67d724a13de1e";
    private final String TOKEN_URL = "https://accounts.spotify.com/api/token";

    @Autowired
    private SpotifyResponseRepo spotifyResponseRepo;

    public String getAccessToken() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(CLIENT_ID, CLIENT_SECRET);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        

        HttpEntity<String> request = new HttpEntity<>("grant_type=client_credentials", headers);
        ResponseEntity<String> response = restTemplate.exchange(TOKEN_URL, HttpMethod.POST, request, String.class);

        // Parse JSON using Jackson
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.getBody());

        return jsonNode.get("access_token").asText();
    }

    public String searchTrack(String query, String type) throws Exception {
        String accessToken = getAccessToken();
        System.out.println(accessToken);
        String url = "https://api.spotify.com/v1/search?q=" + query + "&type=" + type;

        if(spotifyResponseRepo.findByUrl(url).size() > 0) {
            return spotifyResponseRepo.findByUrl(url).get(0).getResponseBody();
        }
        
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
       
        spotifyResponseRepo.save(new SpotifyResponse(url, response.getBody(), LocalDateTime.now()));
        return response.getBody(); // Returns JSON from Spotify API
    }

    public String getTrack(String id) throws Exception {
        String accessToken = getAccessToken();
        String url = "https://api.spotify.com/v1/tracks/" + id;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody(); // Returns JSON from Spotify API
    }

    public String getPlaylist(String id) throws Exception {
        String accessToken = getAccessToken();
        String url = "https://api.spotify.com/v1/playlists/" + id;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody(); // Returns JSON from Spotify API
    }
}
