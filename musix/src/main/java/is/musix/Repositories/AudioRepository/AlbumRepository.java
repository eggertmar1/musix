package is.musix.Repositories.AudioRepository;

import is.musix.Entities.AudiioEntities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
