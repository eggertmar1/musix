package is.musix.Repositories.AudioRepository;

import is.musix.Entities.AudioEntities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Iterable<Album> findAllByArtistId(Long id);
    Iterable<Album> findAllByArtistName(String name);
    Iterable<Album> findAllByArtistNameContaining(String name);
}
