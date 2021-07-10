/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudBibloteca.bibloteca.controller;

import com.crudBibloteca.bibloteca.service.LibroService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Monica
 */
@Controller
public class BIblotecaController {
    @Autowired
    private LibroService objLibroService;
    static Logger LOG = Logger.getLogger(BIblotecaController.class.getName());  
    
    @GetMapping("/")
    public String viewHomePage(Model model ) {
        LOG.info("bandera 1");
         
     objLibroService.getAllLibros().forEach(
        l ->     
        LOG.info(l.getNombreLibro() + " " + l.getEditorial() + " " + l.getAutor())
     );
    model.addAttribute("listaLibros",objLibroService.getAllLibros());
    return "index";
    }
}
