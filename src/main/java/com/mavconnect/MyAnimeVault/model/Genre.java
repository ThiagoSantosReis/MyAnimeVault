package com.mavconnect.MyAnimeVault.model;

import com.mavconnect.MyAnimeVault.model.dto.GenreApiDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="genre")
@Table(name = "genre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private GenreEnum name;

    @OneToMany(mappedBy = "genre")
    private List<Anime> animes;

    public Genre(GenreApiDTO data){
        this.name = GenreEnum.fromString(data.name());
    }


    public Genre(GenreEnum genreEnum) {
        this.name = genreEnum;
    }
}
