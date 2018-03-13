package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Integer> {
}
