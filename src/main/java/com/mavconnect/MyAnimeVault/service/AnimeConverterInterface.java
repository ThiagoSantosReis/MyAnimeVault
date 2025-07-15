package com.mavconnect.MyAnimeVault.service;

public interface AnimeConverterInterface {
    <T> T getData(String json, Class<T> cls);
}
