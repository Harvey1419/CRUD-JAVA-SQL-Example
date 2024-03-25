package uis.edu.entornos.tienda.service;

import uis.edu.entornos.tienda.modelo.Proveedor;

import java.util.List;

public interface IproveedorService {

    List<Proveedor> getProveedores();

    Proveedor nuevoProveedor(Proveedor proveedor);

    Proveedor buscarProveedor(Long id);

    int borrarUsuario(Long id);

}
