package br.ZonaFit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data //metodos get y set
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//null si no hay valor
    private String nombre;
    private String apellido;
    private Integer membresia;




}
