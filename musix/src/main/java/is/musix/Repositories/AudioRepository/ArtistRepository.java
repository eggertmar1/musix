package is.musix.Repositories.AudioRepository;

import is.musix.Entities.AudioEntities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Iterable<Artist> findAllByName(String name);
    Iterable<Artist> findAllByNameContaining(String name);
}
