package com.claudiomldo.apibooks.repository;

import com.claudiomldo.apibooks.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
