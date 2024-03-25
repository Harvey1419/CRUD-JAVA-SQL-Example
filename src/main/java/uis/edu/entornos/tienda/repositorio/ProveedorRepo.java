package uis.edu.entornos.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.tienda.modelo.Proveedor;

public interface ProveedorRepo extends JpaRepository<Proveedor, Long> {
}
