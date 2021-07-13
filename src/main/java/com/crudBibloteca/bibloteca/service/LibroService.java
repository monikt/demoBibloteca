/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudBibloteca.bibloteca.service;

import com.crudBibloteca.bibloteca.model.Libro;
import java.util.List;

/**
 *
 * @author Monica
 */
public interface LibroService {
    List<Libro> getAllLibros();
    void crearLibro( Libro objlibro);
    Libro getLibroId(Long id);
    void eliminarLibroById(Long id);
}
