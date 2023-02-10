package com.ni.salvadoritapizza.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="MUNICIPIO")
public class Municipio {

    @Id
    @SequenceGenerator(name = "municipio_seq",
            sequenceName = "municipio_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "municipio_seq")
    private Long id;

    private String name;

    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_departamento",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Department department;
}
