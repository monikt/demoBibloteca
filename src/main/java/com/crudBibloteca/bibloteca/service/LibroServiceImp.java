/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudBibloteca.bibloteca.service;

import com.crudBibloteca.bibloteca.model.Libro;
import com.crudBibloteca.bibloteca.repository.BiblotecaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Monica
 */
@Service

public class LibroServiceImp implements  LibroService{

    @Autowired
    private BiblotecaRepository objbiblotecaRepository;
    @Override
    public List<Libro> getAllLibros() {
      return objbiblotecaRepository.findAll();
    }

    @Override
    public void crearLibro(Libro objlibro) {
        this.objbiblotecaRepository.save(objlibro);
        
    }

    @Override
    public Libro getLibroId(Long id) {
        Optional<Libro> optionalLibro = this.objbiblotecaRepository.findById(id);
        Libro objLibro = null;
        if (optionalLibro.isPresent()) {
            objLibro = optionalLibro.get();
        }else {
        
        throw new RuntimeException(" libro no encontrado con el id: "+ id);
        }
        return objLibro;
    }

    @Override
    public void eliminarLibroById(Long id) {
      this.objbiblotecaRepository.deleteById(id);
    }
    
}
