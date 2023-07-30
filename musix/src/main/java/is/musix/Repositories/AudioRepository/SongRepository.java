package is.musix.Repositories.AudioRepository;

import is.musix.Entities.AudioEntities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
    Iterable<Song> findByArtistId(Long id);
    Iterable<Song> findByAlbumId(Long id);
}
