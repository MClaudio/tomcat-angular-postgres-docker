package com.claudiomldo.apibooks.service;

import com.claudiomldo.apibooks.model.Libro;
import com.claudiomldo.apibooks.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    LibroService(){

    }

    public Libro create (Libro libro){
        return libroRepository.save(libro);
    }

    public List<Libro> getAllLibros(){
        return libroRepository.findAll();
    }

    public void delete (Libro libro){
         libroRepository.delete(libro);
    }

    public Libro getLibro (Long id){
        return libroRepository.getById(id);
    }
}
