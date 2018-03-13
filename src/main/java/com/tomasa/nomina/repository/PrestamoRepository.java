package com.tomasa.nomina.repository;

import com.tomasa.nomina.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}
