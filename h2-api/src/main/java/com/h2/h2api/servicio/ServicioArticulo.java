package com.h2.h2api.servicio;

import com.h2.h2api.modelo.Articulo;

import java.util.Optional;

public interface ServicioArticulo {

    Articulo createArticulo(Articulo articulo);

    Articulo getArticulo(Long id);

    Articulo updateAticulo(Long id, Articulo articulo);

    boolean deleteArticulo(Long id);

    void flushCache();
}
