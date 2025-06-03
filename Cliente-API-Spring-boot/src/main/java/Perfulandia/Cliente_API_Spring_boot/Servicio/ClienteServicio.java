package Perfulandia.Cliente_API_Spring_boot.Servicio;

import java.util.List;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.stereotype.Service;


import Perfulandia.Cliente_API_Spring_boot.Modelo.Cliente;
import Perfulandia.Cliente_API_Spring_boot.Repositorio.ClienteRepositorio;
import Perfulandia.Cliente_API_Spring_boot.Repositorio.DireccionRepositorio;
import Perfulandia.Cliente_API_Spring_boot.Repositorio.VentaRepositorio;
import Perfulandia.Cliente_API_Spring_boot.dto.Clientedto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServicio {

    private final ClienteRepositorio clienteRepo;
    private final DireccionRepositorio direccionRepo;
    private final VentaRepositorio ventaRepo;

    public Clientedto buscarClientePorId(Integer id){
        Cliente cliente = clienteRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado por ID:" + id));
        
        return mapper.clienteToDto(cliente);
    }

    public Clientedto actualizarCliente(Integer id, Clientedto dto){
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado por ID:" + id));
        
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setTipo(dto.getTipo());
        cliente.setRut(dto.getRut());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        
        Cliente guardado = clienteRepo.save(cliente);
        return mapper.Clientedto(guardado);
    }
}
