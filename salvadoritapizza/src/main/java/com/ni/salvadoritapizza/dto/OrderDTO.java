package com.ni.salvadoritapizza.dto;


import com.ni.salvadoritapizza.model.ORDERSTATUS;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private Date dateOrder;
    private Long idClient;
    private List<DetailOrderDTO> detalles;
    private Double total;
    private Long idBranch;
    private ORDERSTATUS orderstatus;
}
