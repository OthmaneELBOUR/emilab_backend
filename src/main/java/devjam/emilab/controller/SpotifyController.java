package devjam.emilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import devjam.emilab.service.SpotifyService;

@RestController
@RequestMapping("/spotify")
@CrossOrigin(origins = "http://172.28.240.1:8080/")
public class SpotifyController {
    @Autowired
    private SpotifyService spotifyService;

    @GetMapping("/search")
    public String searchTrack(@RequestParam("query") String query, @RequestParam("type") String type) {
        try {
            return spotifyService.searchTrack(query, type);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error searching track");
        }
    }

}
