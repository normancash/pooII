package com.uam.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="Libro")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name="Libro.all",query="select e from Libro e")
})
public class Libro {
    @Id
    private Long id;
    private String nombre;
}
