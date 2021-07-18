package com.claudiomldo.apibooks.rest;

import com.claudiomldo.apibooks.model.Libro;
import com.claudiomldo.apibooks.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api/libro/")
public class LibroRest {
    @Autowired
    private LibroService libroService;

    @PostMapping
    private ResponseEntity<Libro> guardarLibro (@RequestBody Libro libro){
        Libro libtemp = libroService.create(libro);
        try {
            return ResponseEntity.created(new URI("/api/libro"+libtemp.getId())).body(libtemp);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Libro>> listarLibros (){
        return ResponseEntity.ok(libroService.getAllLibros());
    }


    @DeleteMapping(value = "/{id}")
    private ResponseEntity<Void> eliminarLibro (@PathVariable Long id){
        Libro libroTemp = libroService.getLibro(id);
        libroService.delete(libroTemp);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    private ResponseEntity<Libro> detalleLibro (@PathVariable Long id){
        return ResponseEntity.ok(libroService.getLibro(id));
    }

}
