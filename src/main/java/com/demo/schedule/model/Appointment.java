package com.demo.schedule.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="Appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Entity of Appointment")
public class Appointment implements Serializable {

    @Id
    @SequenceGenerator(name = "appointment_seq",
            sequenceName = "appointment_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "appointment_seq")
    private Integer id;

    @ApiModelProperty(notes="Name of appointment")
    private String name;

    @ApiModelProperty(notes="Telephone of Contact")
    private String telephoneContact;

    @ApiModelProperty(notes="Date of appointment")
    @Column(columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ApiModelProperty(notes="Time of appointment")
    @Column(columnDefinition = "TIME")
    @Temporal(TemporalType.TIME)
    private Date Time;

    @ApiModelProperty(notes="Abstract of appointment")
    private String abstractR;
}
