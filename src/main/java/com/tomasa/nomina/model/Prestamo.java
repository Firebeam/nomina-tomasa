package com.tomasa.nomina.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Prestamo")
public class Prestamo {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "idEmpleado", nullable = false)
	private Empleado empleado;

	@NotNull
	@Column(name = "montoTotal", nullable = false, precision = 40, scale = 2)
	private BigDecimal montoTotal;

	@NotNull
	@Column(name = "saldo", nullable = false, precision = 20, scale = 2)
	private BigDecimal saldo;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "status", nullable = false)
	private StatusPago status;

	@OneToMany(mappedBy = "prestamo")
	private Set<Ingreso> ingresoSet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public StatusPago getStatus() {
		return status;
	}

	public void setStatus(StatusPago status) {
		this.status = status;
	}

	public Set<Ingreso> getIngresoSet() {
		return ingresoSet;
	}

	public void setIngresoSet(Set<Ingreso> ingresoSet) {
		this.ingresoSet = ingresoSet;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Prestamo prestamo = (Prestamo) o;
		return id == prestamo.id &&
				Objects.equals(empleado, prestamo.empleado) &&
				Objects.equals(montoTotal, prestamo.montoTotal) &&
				Objects.equals(saldo, prestamo.saldo) &&
				status == prestamo.status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, empleado, montoTotal, saldo, status);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Prestamo{");
		sb.append("id=").append(id);
		sb.append(", empleado=").append(empleado);
		sb.append(", montoTotal=").append(montoTotal);
		sb.append(", saldo=").append(saldo);
		sb.append(", status=").append(status);
		sb.append('}');
		return sb.toString();
	}
}
