package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Salario;
import com.tomasa.nomina.model.SalarioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, SalarioPK> {
}
