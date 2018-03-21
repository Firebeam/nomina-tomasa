package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {
}
