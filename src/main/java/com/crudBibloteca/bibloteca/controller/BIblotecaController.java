/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudBibloteca.bibloteca.controller;

import com.crudBibloteca.bibloteca.model.Libro;
import com.crudBibloteca.bibloteca.service.LibroService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String viewHomePage(Model model) {

        objLibroService.getAllLibros().forEach(
                l
                -> LOG.info(l.getNombreLibro() + " " + l.getEditorial() + " " + l.getAutor())
        );

        model.addAttribute("listaLibros", objLibroService.getAllLibros());
        return "index";
    }

    @GetMapping("/mostrarFormNuevoLibro")
    public String mostrarFormNuevoLibro(Model model) {
        Libro objLibro = new Libro();
        model.addAttribute("libro", objLibro);
        return "new_libro";

    }
    @PostMapping("/guardarLibro")
    public String guardarLibro(@ModelAttribute("libro") Libro objLibro, Model model){
    
        objLibroService.crearLibro(objLibro);
        model.addAttribute("mensaje", "Se ha creado de manera correcta el libro " + objLibro.getNombreLibro());
        return "new_libro";
    }
    @GetMapping("/mostrarFormEditarLibro/{id}")
    public String mostrarFormEditarLibro(@PathVariable(value = "id") Long id,Model model){
    
        Libro objLibro = objLibroService.getLibroId(id);
        model.addAttribute("libro", objLibro);
        return "actualizar_libro";
    }
    
     @PostMapping("/updateLibro")
    public String updateLibro(@ModelAttribute("libro") Libro objLibro, Model model){
    
        objLibroService.crearLibro(objLibro);
        model.addAttribute("mensaje", "Se ha actualizado de manera correcta el libro " + objLibro.getNombreLibro());
        return "actualizar_libro";
    }
    
     @GetMapping("/eliminarLibro/{id}")
    public String eliminarLibro(@PathVariable(value = "id") Long id,Model model){
       Libro objLibro = objLibroService.getLibroId(id);
       objLibroService.eliminarLibroById(id);
       model.addAttribute("listaLibros", objLibroService.getAllLibros());
       model.addAttribute("mensaje", "Se ha eliminado de manera correcta el libro " +objLibro.getNombreLibro());
       return "index";
    }
    

}
