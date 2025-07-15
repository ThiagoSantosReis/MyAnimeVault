package com.mavconnect.MyAnimeVault.model;

public enum GenreEnum {
    ACTION("action"),
    ADVENTURE("adventure"),
    AVANT_GARDE("avant garde"),
    AWARD_WINNING("award winning"),
    BOYS_LOVE("boys love"),
    COMEDY("comedy"),
    DRAMA("drama"),
    ECCHI("ecchi"),
    FANTASY("fantasy"),
    GIRLS_LOVE("girls love"),
    GOURMET("gourmet"),
    HORROR("horror"),
    HENTAI("hentai"),
    MYSTERY("mystery"),
    ROMANCE("romance"),
    SCI_FI("sci-fi"),
    SLICE_OF_LIFE("slice of life"),
    SPORTS("sports"),
    SUPERNATURAL("supernatural"),
    SUSPENSE("suspense");

    private String genre;

    GenreEnum(String genre){
        this.genre = genre;
    }

    public static GenreEnum fromString(String text){
        for(GenreEnum g : GenreEnum.values()){
            if(g.genre.equalsIgnoreCase(text)){
                return g;
            }
        }

        throw new IllegalArgumentException("Error: Genre not found");
    }

}
