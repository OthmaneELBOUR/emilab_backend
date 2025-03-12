package devjam.emilab.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SpotifyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @Column(columnDefinition = "JSON")
    private String responseBody;
    private LocalDateTime timestamp;


    public SpotifyResponse() {
    }


    public SpotifyResponse(String url, String responseBody, LocalDateTime timestamp) {
        this.url = url;
        this.responseBody = responseBody;
        this.timestamp = timestamp;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "SpotifyResponse [id=" + id + ", url=" + url + ", responseBody=" + responseBody + ", timestamp="
                + timestamp + "]";
    }


}
