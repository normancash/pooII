package com.ni.salvadoritapizza.dto;

import lombok.Data;

@Data
public class ClientDTO {

    private Long id;
    private String name;
    private String lastName;
    private String telephone;
    private String billAddress1;
    private String billAddress2;
    private Long idDepartment;
    private Long idMunicipio;
    private String cedula;

}
