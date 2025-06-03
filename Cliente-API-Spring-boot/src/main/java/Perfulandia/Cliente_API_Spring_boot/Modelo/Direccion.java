package Perfulandia.Cliente_API_Spring_boot.Modelo;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "direcciones")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer id_direccion;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Direccion direccion;

    private String calle;
    private Integer numero_casa;
    private Integer comuna;

    @OneToMany(mappedBy = "Cliente", cascade = CascadeType.ALL)
    private List<Direccion> direcciones = new ArrayList<>();

}
