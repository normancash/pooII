package com.uam.biblioteca.controller;

import com.uam.biblioteca.model.Libro;
import com.uam.biblioteca.service.IServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class ControllerLibro {
    @Autowired
    private IServiceLibro service;

    @GetMapping("/all")
    public List<Libro> getAll() {
         return service.getAll();
    }
}
