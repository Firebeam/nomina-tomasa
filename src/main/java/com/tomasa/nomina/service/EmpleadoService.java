package com.tomasa.nomina.service;

import com.tomasa.nomina.model.Empleado;

import java.util.Optional;
import java.util.stream.Stream;

public interface EmpleadoService {
	Stream<Empleado> findAll();
	Optional<Empleado> findById(int id);
	Stream<Empleado> findByNombreIgnoreCase(String nombre);
	void save(Empleado empleado);
}
