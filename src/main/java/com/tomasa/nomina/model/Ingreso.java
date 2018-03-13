package com.tomasa.nomina.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "Ingreso")
public class Ingreso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "idPrestamo", nullable = false)
	private Prestamo prestamo;

	@NotNull
	@Column(name = "montoIngreso", nullable = false, precision = 20, scale = 2)
	private BigDecimal montoIngreso;

	@NotNull
	@Column(name = "fecha", nullable = false, columnDefinition = "timestamp")
	private OffsetDateTime fecha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public BigDecimal getMontoIngreso() {
		return montoIngreso;
	}

	public void setMontoIngreso(BigDecimal montoIngreso) {
		this.montoIngreso = montoIngreso;
	}

	public OffsetDateTime getFecha() {
		return fecha;
	}

	public void setFecha(OffsetDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ingreso ingreso = (Ingreso) o;
		return id == ingreso.id &&
				Objects.equals(prestamo, ingreso.prestamo) &&
				Objects.equals(montoIngreso, ingreso.montoIngreso) &&
				Objects.equals(fecha, ingreso.fecha);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, prestamo, montoIngreso, fecha);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Ingreso{");
		sb.append("id=").append(id);
		sb.append(", prestamo=").append(prestamo);
		sb.append(", montoIngreso=").append(montoIngreso);
		sb.append(", fecha=").append(fecha);
		sb.append('}');
		return sb.toString();
	}
}
