package br.Agenda.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class contacto {
@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer idContacto;
    String nombre;
    String celular;
    String email;


}
