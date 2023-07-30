package is.musix.Controllers.SongController;

import is.musix.Entities.AudioEntities.Album;
import is.musix.Services.AlbumService.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        Album savedAlbum = albumService.createAlbum(album);
        if (savedAlbum == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedAlbum, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Album>> getAllAlbums() {
        Iterable<Album> albums = albumService.getAllAlbums();
        if (albums == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        Album album = albumService.getAlbumById(id);
        if (album == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        Album updatedAlbum = albumService.updateAlbum(album);
        if (updatedAlbum == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedAlbum, HttpStatus.OK);
    }

    @GetMapping("/artist/{id}")
    public ResponseEntity<Iterable<Album>> getAlbumsByArtistId(@PathVariable Long id) {
        Iterable<Album> albums = albumService.getAlbumsByArtistId(id);
        if (albums == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/artist/name/{name}")
    public ResponseEntity<Iterable<Album>> getAlbumsByArtistName(@PathVariable String name) {
        Iterable<Album> albums = albumService.getAlbumsByArtistName(name);
        if (albums == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/artist/name/containing/{name}")
    public ResponseEntity<Iterable<Album>> getAlbumsByArtistNameContaining(@PathVariable String name) {
        Iterable<Album> albums = albumService.getAlbumsByArtistNameContaining(name);
        if (albums == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }
}
