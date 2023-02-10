package com.ni.salvadoritapizza.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="CLIENTE")
public class Client {

    @Id
    @SequenceGenerator(name = "cliente_seq",
            sequenceName = "cliente_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cliente_seq")
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;

    private String telephone;

    private String billAddress1;

    private String billAddress2;

    private String cedula;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_departamento",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Department department;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_municipio",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Municipio municipio;
}
