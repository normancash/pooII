package com.ni.salvadoritapizza.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DepartmentDTO {

    private Long id;
    private String name;
    private String description;
    private List<MunicipioDTO> municipios = new ArrayList<>();

}
