package Perfulandia.Cliente_API_Spring_boot.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Perfulandia.Cliente_API_Spring_boot.Modelo.Cliente;



public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

}
