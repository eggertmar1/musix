package is.musix.Entities.AudioEntities;

import jakarta.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int trackNumber;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "audio_file_id")
    private AudioFile audioFile;

    public Song() {
    }

    public Song(String title, int trackNumber, Album album, Artist artist, AudioFile audioFile) {
        this.title = title;
        this.trackNumber = trackNumber;
        this.album = album;
        this.artist = artist;
        this.audioFile = audioFile;
    }

    public String getTitle() {
        return title;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public Artist getArtist() {
        return artist;
    }

    public AudioFile getAudioFile() {
        return audioFile;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setAudioFile(AudioFile audioFile) {
        this.audioFile = audioFile;
    }

    public Long getId() {
        return id;
    }
}

