package com.tomasa.nomina.service.impl;

import com.tomasa.nomina.model.Empleado;
import com.tomasa.nomina.repository.EmpleadoRepository;
import com.tomasa.nomina.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository repository;

	@Override
	public Stream<Empleado> findAll() {
		return repository.findAll().stream();
	}

	@Override
	public Optional<Empleado> findById(int id) {
		return Optional.of(repository.getOne(id));
	}

	@Override
	public Stream<Empleado> findByNombreIgnoreCase(String nombre) {
		return repository.findByNombreIgnoreCase(nombre).stream();
	}

	@Override
	public void save(Empleado empleado) {
		repository.save(empleado);
	}
}
