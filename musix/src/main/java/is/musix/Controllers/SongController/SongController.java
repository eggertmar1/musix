package is.musix.Controllers.SongController;

import is.musix.Entities.AudioEntities.Song;
import is.musix.Services.SongService.SongService;
import is.musix.dto.SongRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    ResponseEntity<Song> createSong(@RequestBody SongRequestDto song) {
        Song savedSong = songService.createSong(song);
        if (savedSong == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedSong, HttpStatus.CREATED);
    }
}
