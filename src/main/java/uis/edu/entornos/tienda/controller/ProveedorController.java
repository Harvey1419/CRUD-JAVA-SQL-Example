package uis.edu.entornos.tienda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uis.edu.entornos.tienda.modelo.Proveedor;
import uis.edu.entornos.tienda.service.ProveedorService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/list")
    public List<Proveedor> cargarProveedores(){
        return proveedorService.getProveedores();
    }

    @GetMapping("/list/{id}")
    public Proveedor getProveedorById(@PathVariable Long id){
        return proveedorService.buscarProveedor(id);
    }

    @PostMapping("/")
    public ResponseEntity<Proveedor> agregar(@RequestBody Proveedor proveedor){
        Proveedor obj = proveedorService.nuevoProveedor(proveedor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Proveedor> editar(@RequestBody Proveedor proveedor){
        Proveedor obj = proveedorService.buscarProveedor(proveedor.getId());
        if(obj != null) {
            obj.setCiudad(proveedor.getCiudad());
            obj.setDireccion(proveedor.getDireccion());
            obj.setNit(proveedor.getNit());
            obj.setNombre(proveedor.getNombre());
            obj.setTelefono(proveedor.getTelefono());
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Proveedor> eliminar(@PathVariable Long id){
        Proveedor obj = proveedorService.buscarProveedor(id);
        if(obj != null){
            proveedorService.borrarUsuario(id);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}