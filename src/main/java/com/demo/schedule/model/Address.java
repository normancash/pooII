package com.demo.schedule.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Address")
public class Address {
    @ApiModelProperty(notes="country, ex: Nicaragua")
    private String country;
    @ApiModelProperty(notes="state, ex: Managua")
    private String state;
    @ApiModelProperty(notes="address")
    private String address;
}
