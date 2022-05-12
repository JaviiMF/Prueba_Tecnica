package com.h2.h2api.controlador;

import com.h2.h2api.modelo.Articulo;
import com.h2.h2api.servicio.ServicioArticulo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/articulo")
@AllArgsConstructor
@Slf4j
public class ControladorArticulo {

    private final ServicioArticulo servicioArticulo;

    @PostMapping
    public ResponseEntity createArticulo(@RequestBody Articulo articulo){
        log.info("POST Request");
        return new ResponseEntity(servicioArticulo.createArticulo(articulo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getArticulo(@PathVariable Long id){
        log.info("GET Request");
        try{
            return new ResponseEntity(servicioArticulo.getArticulo(id),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity updateArticulo(@PathVariable Long id, @RequestBody Articulo articulo){
        log.info("PUT Request");
        try{
            return new ResponseEntity(servicioArticulo.updateAticulo(id,articulo), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteArticulo(@PathVariable Long id){
        log.info("DELETE Request");
        boolean eliminado = servicioArticulo.deleteArticulo(id);

        if(eliminado == true){
            return new ResponseEntity(HttpStatus.OK);
        }

        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/flush")
    public ResponseEntity flushCache(){
        log.info("CACHE cleared");
        servicioArticulo.flushCache();
        return new ResponseEntity(HttpStatus.OK);
    }
}
