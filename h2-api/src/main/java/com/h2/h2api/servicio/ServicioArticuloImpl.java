package com.h2.h2api.servicio;

import com.h2.h2api.modelo.Articulo;
import com.h2.h2api.repositorio.RepositorioArticulo;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class ServicioArticuloImpl implements ServicioArticulo{

    private final RepositorioArticulo repositorioArticulo;

    @Override
    public Articulo createArticulo(Articulo articulo) {
        return repositorioArticulo.save(articulo);
    }

    @Override
    @Cacheable(cacheNames = "headers")
    public Articulo getArticulo(Long id){
        return repositorioArticulo.findById(id).orElseThrow(()-> new EntityNotFoundException(String.valueOf(id)));
    }

    @Override
    @CachePut(cacheNames = "headers")
    public Articulo updateAticulo(Long id, Articulo articulo) {
        Articulo encontrado = repositorioArticulo.findById(id).get();
        encontrado.setNombre(articulo.getNombre());
        encontrado.setPrecio(articulo.getPrecio());
        return repositorioArticulo.save(encontrado);
    }

    @Override
    public boolean deleteArticulo(Long id) {
        try{
            repositorioArticulo.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    @CacheEvict(cacheNames = "headers",allEntries = true)
    public void flushCache(){ }

}
