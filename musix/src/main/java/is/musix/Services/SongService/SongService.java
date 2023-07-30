package is.musix.Services.SongService;

import is.musix.Entities.AudioEntities.Album;
import is.musix.Entities.AudioEntities.Artist;
import is.musix.Entities.AudioEntities.AudioFile;
import is.musix.Entities.AudioEntities.Song;
import is.musix.Repositories.AudioRepository.AlbumRepository;
import is.musix.Repositories.AudioRepository.ArtistRepository;
import is.musix.Repositories.AudioRepository.SongRepository;
import is.musix.dto.SongRequestDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is responsible for handling the business logic for songs.
 * It is used by the SongController to handle requests from the frontend.
 * @see is.musix.Controllers.SongController.SongController
 * @see is.musix.dto.SongRequestDto
 * @see is.musix.Entities.AudioEntities.Song
 * @see is.musix.Repositories.AudioRepository.SongRepository
 * @author eggert
 */
@Service
public class SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

     @Autowired
    public SongService(SongRepository songRepository, AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    /**
     * Creates a song and saves it to the database.
     * @param songRequest The song to be created.
     * @return The created song.
     */
    @Transactional
    public Song createSong(SongRequestDto songRequest) {
        // Expect the album and artist to exist
        Album album = albumRepository.findById(songRequest.getAlbumId())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Album with id %d not found", songRequest.getAlbumId())));
        Artist artist = artistRepository.findById(songRequest.getArtistId())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Artist with id %d not found", songRequest.getArtistId())));

        // Create the song
        Song song = new Song();
        song.setTitle(songRequest.getTitle());
        song.setTrackNumber(songRequest.getTrackNumber());
        song.setAlbum(album);
        song.setArtist(artist);

        // Create the audio file
        AudioFile audioFile = new AudioFile();
        audioFile.setUrl(songRequest.getAudioFileUrl());
        song.setAudioFile(audioFile);
        songRepository.save(song);
        return song;
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Song with id %d not found", id)));
    }

    public Iterable<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Iterable<Song> getSongsByArtistId(Long id) {
        return songRepository.findByArtistId(id);
    }

    public Iterable<Song> getSongsByAlbumId(Long id) {
        return songRepository.findByAlbumId(id);
    }
}
