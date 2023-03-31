package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="ESTUDIANTE")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name="Estudiante.all",query = "select e from Estudiante e")
})
public class Estudiante {

    @Id
    @SequenceGenerator(name = "estudiante_seq",sequenceName = "estudiante_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "estudiante_seq")
    private Long id;

    private String nombre;

    private String apellido;
}
