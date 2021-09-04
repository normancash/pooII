package com.demo.schedule.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Email")
public class EmailContact {
    @Email
    private String email;
}
