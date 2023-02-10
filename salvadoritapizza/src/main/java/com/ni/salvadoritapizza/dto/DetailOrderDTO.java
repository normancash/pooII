package com.ni.salvadoritapizza.dto;

import lombok.Data;

import java.util.List;

@Data
public class DetailOrderDTO {
    private Long id;
    private Long idProduct;
    private int quantity;
    private List<DetailDTO> detailExtra;
}
