/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudBibloteca.bibloteca.repository;

import com.crudBibloteca.bibloteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Monica
 */
@Repository
public interface BiblotecaRepository extends JpaRepository<Libro, Long>{
    
    
}
