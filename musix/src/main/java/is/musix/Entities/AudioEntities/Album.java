package is.musix.Entities.AudioEntities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Album() {
    }

    public Album(String title, LocalDate releaseDate, Artist artist) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }
}
