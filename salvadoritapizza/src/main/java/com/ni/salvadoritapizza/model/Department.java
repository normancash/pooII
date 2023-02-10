package com.ni.salvadoritapizza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="DEPARTAMENTO")
public class Department {

    @Id
    @SequenceGenerator(name = "department_seq",
            sequenceName = "department_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "department_seq")
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "department",
            cascade  = CascadeType.ALL,fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Municipio> municipios = new ArrayList<>();

}
