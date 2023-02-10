package com.ni.salvadoritapizza.dto;


import lombok.Data;

@Data
public class DetailDTO {
    private Long id;
    private Long idProducto;
    private int quantity;
}
