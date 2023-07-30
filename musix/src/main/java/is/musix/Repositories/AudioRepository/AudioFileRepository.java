package is.musix.Repositories.AudioRepository;

import is.musix.Entities.AudioEntities.AudioFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioFileRepository extends JpaRepository<AudioFile, Long> {
    // Custom query methods can be added here if needed
}