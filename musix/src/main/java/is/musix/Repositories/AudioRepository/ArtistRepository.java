package is.musix.Repositories.AudioRepository;

import is.musix.Entities.AudiioEntities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
