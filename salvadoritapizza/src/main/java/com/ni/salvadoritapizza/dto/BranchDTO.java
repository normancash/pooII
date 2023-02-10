package com.ni.salvadoritapizza.dto;


import lombok.Data;

@Data
public class BranchDTO {
    private Long id;

    private String name;

    private String description;

    private Long idDepartment;

    private Long idMunicipio;
}
