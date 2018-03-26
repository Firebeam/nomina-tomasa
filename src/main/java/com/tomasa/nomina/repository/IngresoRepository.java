package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IngresoRepository extends JpaRepository<Ingreso, Integer> {
}
