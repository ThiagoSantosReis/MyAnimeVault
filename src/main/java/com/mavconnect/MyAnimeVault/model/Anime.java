package com.mavconnect.MyAnimeVault.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "anime")
@Table(name = "anime")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;


}
