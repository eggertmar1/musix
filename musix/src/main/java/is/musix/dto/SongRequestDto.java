package is.musix.dto;

public class SongRequestDto {
    private String title;
    private int trackNumber;
    private Long albumId;
    private Long artistId;
    private String audioFileUrl;

    public SongRequestDto() {
    }

    public SongRequestDto(String title, int trackNumber, Long albumId, Long artistId, String audioFileUrl) {
        this.title = title;
        this.trackNumber = trackNumber;
        this.albumId = albumId;
        this.artistId = artistId;
        this.audioFileUrl = audioFileUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public Long getArtistId() {
        return artistId;
    }

    public String getAudioFileUrl() {
        return audioFileUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public void setAudioFileUrl(String audioFileUrl) {
        this.audioFileUrl = audioFileUrl;
    }

    @Override
    public String toString() {
        return "SongRequestDto{" +
                "title='" + title + '\'' +
                ", trackNumber=" + trackNumber +
                ", albumId=" + albumId +
                ", artistId=" + artistId +
                ", audioFileUrl='" + audioFileUrl + '\'' +
                '}';
    }
}
