package devjam.emilab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import devjam.emilab.model.SpotifyResponse;
import java.util.List;


public interface SpotifyResponseRepo extends JpaRepository<SpotifyResponse, Long> {
    List<SpotifyResponse> findByUrl(String url);
}
