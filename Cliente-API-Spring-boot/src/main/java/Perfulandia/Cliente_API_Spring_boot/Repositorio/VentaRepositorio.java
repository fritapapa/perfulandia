package Perfulandia.Cliente_API_Spring_boot.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Perfulandia.Cliente_API_Spring_boot.Modelo.Venta;

public interface VentaRepositorio extends JpaRepository<Venta, Integer> {

}
