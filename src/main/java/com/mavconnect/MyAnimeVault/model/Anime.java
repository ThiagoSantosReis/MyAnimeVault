package com.mavconnect.MyAnimeVault.model;

import com.mavconnect.MyAnimeVault.model.dto.AnimeApiDataDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "anime")
@Table(name = "anime")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type;
    private Boolean airing;
    private Integer episodes;
    private Double score;
    private String synopsis;
    @Column(name = "releaseYear")
    private Integer releaseYear;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;


    public Anime(AnimeApiDataDTO data) {
        this.title = data.title();
        this.type = data.type();
        this.airing = data.airing();
        this.episodes = data.episodes();
        this.score = Double.parseDouble(data.score());
        this.synopsis = data.synopsis();
        this.releaseYear = Integer.parseInt(data.releaseYear());
    }
}
