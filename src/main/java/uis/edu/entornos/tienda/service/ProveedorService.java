package uis.edu.entornos.tienda.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.tienda.modelo.Proveedor;
import uis.edu.entornos.tienda.repositorio.ProveedorRepo;

import java.util.List;

@Service
@Transactional

public class ProveedorService implements IproveedorService{

    @Autowired
    ProveedorRepo proveedorRepo;

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorRepo.findAll();
    }

    @Override
    public Proveedor nuevoProveedor(Proveedor proveedor) {
        return proveedorRepo.save(proveedor);
    }

    @Override
    public Proveedor buscarProveedor(Long id) {
        Proveedor proveedor = null;
        proveedor = proveedorRepo.findById(id).orElse(null);
        if(proveedor == null){
            return null;
        }
        return proveedor;
    }

    @Override
    public int borrarUsuario(Long id) {
        proveedorRepo.deleteById(id);
        return 1;
    }
}
