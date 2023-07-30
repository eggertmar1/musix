package is.musix.Services.ArtistService;

import is.musix.Entities.AudioEntities.Artist;
import is.musix.Repositories.AudioRepository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

    public Artist updateArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Iterable<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Iterable<Artist> getArtistsByName(String name) {
        return artistRepository.findAllByName(name);
    }

    public Iterable<Artist> getArtistsByNameContaining(String name) {
        return artistRepository.findAllByNameContaining(name);
    }
}
