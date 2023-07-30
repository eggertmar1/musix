package is.musix.Controllers.SongController;

import is.musix.Entities.AudioEntities.Artist;
import is.musix.Services.ArtistService.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        Artist savedArtist = artistService.createArtist(artist);
        if (savedArtist == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedArtist, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Artist>> getAllArtists() {
        Iterable<Artist> artists = artistService.getAllArtists();
        if (artists == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        Artist artist = artistService.getArtistById(id);
        if (artist == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        Artist updatedArtist = artistService.updateArtist(artist);
        if (updatedArtist == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedArtist, HttpStatus.OK);
    }

    /**
     * This endpoint is used to get all artists that have a name equal to the given name.
     * @param name
     * @return Iterable<Artist>
     * @see is.musix.Services.ArtistService.ArtistService
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Iterable<Artist>> getArtistsByName(@PathVariable String name) {
        Iterable<Artist> artists = artistService.getArtistsByName(name);
        if (artists == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    /**
     * This endpoint is used to get all artists that have a name containing the given name.
     * @param name
     * @return Iterable<Artist>
     * @see is.musix.Services.ArtistService.ArtistService
     */
    @GetMapping("/name/containing/{name}")
    public ResponseEntity<Iterable<Artist>> getArtistsByNameContaining(@PathVariable String name) {
        Iterable<Artist> artists = artistService.getArtistsByNameContaining(name);
        if (artists == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
}
