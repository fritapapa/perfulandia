package Perfulandia.Cliente_API_Spring_boot.Modelo;


import java.time.LocalDate;
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

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_venta")
    private Integer idVenta;

    @OneToMany(mappedBy = "Cliente", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")

    @OneToMany(mappedBy = "Producto", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Venta venta;
    private LocalDate fecha;
    private Integer total;

    @OneToMany(mappedBy = "Cliente", cascade = CascadeType.ALL)
    private List<Venta> HistorialCompras = new ArrayList<>();
}
