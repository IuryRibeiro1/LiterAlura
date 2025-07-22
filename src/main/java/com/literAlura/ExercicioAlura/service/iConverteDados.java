package com.literAlura.ExercicioAlura.service;

public interface iConverteDados {
    <T> T obterDados(String json, Class<T> classe);

}
