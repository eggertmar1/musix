package is.musix.Services.AudioFileService;

import is.musix.Entities.AudioEntities.AudioFile;
import is.musix.Repositories.AudioRepository.AudioFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioFileService {
    private final AudioFileRepository audioFileRepository;

    @Autowired
    public AudioFileService(AudioFileRepository audioFileRepository) {
        this.audioFileRepository = audioFileRepository;
    }

    public AudioFile saveAudioFile(AudioFile audioFile) {
        return audioFileRepository.save(audioFile);
    }

    public AudioFile getAudioFileById(Long audioFileId) {
        return audioFileRepository.findById(audioFileId).orElse(null);
    }

    public List<AudioFile> getAllAudioFiles() {
        return audioFileRepository.findAll();
    }

    public void deleteAudioFile(Long audioFileId) {
        audioFileRepository.deleteById(audioFileId);
    }
}
