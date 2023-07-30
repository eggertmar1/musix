package is.musix.Repositories.AudioRepository;

import is.musix.Entities.AudiioEntities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
