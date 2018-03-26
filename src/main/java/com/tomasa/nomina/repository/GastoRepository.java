package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GastoRepository extends JpaRepository<Gasto, Integer> {
}
