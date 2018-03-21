package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	List<Empleado> findByNombreIgnoreCase(String nombre);
}
