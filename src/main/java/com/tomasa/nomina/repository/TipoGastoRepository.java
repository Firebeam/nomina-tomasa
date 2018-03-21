package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.TipoGasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoGastoRepository extends JpaRepository<TipoGasto, Integer> {
}
