package com.tomasa.nomina.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Salario")
public class Salario {

	@EmbeddedId
	private SalarioPK salarioPK;

	@Size(max = 200)
	@Column(name = "descripcion")
	private String descripcion;

	@NotNull
	@Column(name = "monto", nullable = false, precision = 20, scale = 2)
	private BigDecimal monto;

	public SalarioPK getSalarioPK() {
		return salarioPK;
	}

	public void setSalarioPK(SalarioPK salarioPK) {
		this.salarioPK = salarioPK;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Salario salario = (Salario) o;
		return Objects.equals(salarioPK, salario.salarioPK) &&
				Objects.equals(descripcion, salario.descripcion) &&
				Objects.equals(monto, salario.monto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(salarioPK, descripcion, monto);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Salario{");
		sb.append("salarioPK=").append(salarioPK);
		sb.append(", descripcion='").append(descripcion).append('\'');
		sb.append(", monto=").append(monto);
		sb.append('}');
		return sb.toString();
	}
}

