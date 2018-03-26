package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Salario;
import com.tomasa.nomina.model.SalarioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SalarioRepository extends JpaRepository<Salario, SalarioPK> {
}
