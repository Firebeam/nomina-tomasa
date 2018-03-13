package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingreso, Integer> {
}
