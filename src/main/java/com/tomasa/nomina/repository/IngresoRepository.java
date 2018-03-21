package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoRepository extends JpaRepository<Ingreso, Integer> {
}
