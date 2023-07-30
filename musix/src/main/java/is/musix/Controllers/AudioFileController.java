package is.musix.Controllers;

import is.musix.Entities.AudiioEntities.AudioFile;
import is.musix.Services.AudioFileService.AudioFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/audiofile")
public class AudioFileController {
    private final AudioFileService audioFileService;

    @Autowired
    public AudioFileController(AudioFileService audioFileService) {
        this.audioFileService = audioFileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<AudioFile> createAudiFile(@RequestBody AudioFile audioFile) {
        AudioFile savedAudioFile = audioFileService.saveAudioFile(audioFile);
        if (savedAudioFile == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedAudioFile, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AudioFile> getAudioFileById(@PathVariable Long id) {
        AudioFile audioFile = audioFileService.getAudioFileById(id);
        if (audioFile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(audioFile, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudioFile(@PathVariable Long id) {
        audioFileService.deleteAudioFile(id);
        return ResponseEntity.noContent().build();
    }
}
