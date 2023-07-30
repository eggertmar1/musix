package is.musix.Services.AlbumService;

import is.musix.Entities.AudioEntities.Album;
import is.musix.Repositories.AudioRepository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album getAlbumById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    public Album updateAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Iterable<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Iterable<Album> getAlbumsByArtistId(Long id) {
        return albumRepository.findAllByArtistId(id);
    }

    public Iterable<Album> getAlbumsByArtistName(String name) {
        return albumRepository.findAllByArtistName(name);
    }

    public Iterable<Album> getAlbumsByArtistNameContaining(String name) {
        return albumRepository.findAllByArtistNameContaining(name);
    }
}
