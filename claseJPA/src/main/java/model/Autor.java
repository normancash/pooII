package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="AUTOR")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(name="Autor.all",query="select e from Autor e")
})
public class Autor {
    @Id
    private Long id;
    private String nombre;
}
