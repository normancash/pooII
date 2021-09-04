package com.demo.schedule.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="contact")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Contacts")
public class Contact implements Serializable {

    @Id
    @SequenceGenerator(name = "contac_seq",
            sequenceName = "contact_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "contact_seq")
    private Integer id;
    @ApiModelProperty(notes="Name")
    private String name;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(notes="Type of Contact ")
    private TypeContact typeContact;

    @ElementCollection
    @CollectionTable(
            name = "PHONE",
            joinColumns = @JoinColumn(name = "contact_id")
    )
    @ApiModelProperty(notes="Telephones")
    private Set<Phone> phones;

    @ElementCollection
    @CollectionTable(
            name="Address",
            joinColumns = @JoinColumn(name = "contact_id")
    )
    @ApiModelProperty(notes="Address")
    private Set<Address> addresses;

    @ElementCollection
    @CollectionTable(
            name="Email",
            joinColumns = @JoinColumn(name = "contact_id")
    )
    @ApiModelProperty(notes="Email")
    private Set<EmailContact> emails;
}
