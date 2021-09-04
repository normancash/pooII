package com.demo.schedule.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Telephone")
public class Phone {
    @ApiModelProperty(notes="Work,Movil,Home")
    private TypePhone type;
    @ApiModelProperty(notes="country code, ex: NIC")
    private String countryCode;
    @ApiModelProperty(notes="Telephone with code area, ex:+50543354395")
    @Size(max=15, message="Field cannot exceed 15 characters in length.")
    private String number;
}

