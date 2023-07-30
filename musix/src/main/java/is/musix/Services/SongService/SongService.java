package is.musix.Services.SongService;

import is.musix.Entities.AudiioEntities.Album;
import is.musix.Entities.AudiioEntities.Artist;
import is.musix.Entities.AudiioEntities.AudioFile;
import is.musix.Entities.AudiioEntities.Song;
import is.musix.Repositories.AudioRepository.AlbumRepository;
import is.musix.Repositories.AudioRepository.ArtistRepository;
import is.musix.Repositories.AudioRepository.SongRepository;
import is.musix.dto.SongRequestDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Transactional
    public Song createSong(SongRequestDto songRequest) {
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
}
