package com.h2.h2api.repositorio;

import com.h2.h2api.modelo.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioArticulo extends JpaRepository<Articulo,Long> {
}
