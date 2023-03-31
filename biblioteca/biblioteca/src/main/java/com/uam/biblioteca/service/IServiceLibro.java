package com.uam.biblioteca.service;

import com.uam.biblioteca.model.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceLibro {

    public List<Libro> getAll();

}
