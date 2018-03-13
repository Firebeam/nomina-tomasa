package com.tomasa.nomina.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "EmpleadoXSalario")
public class EmpleadoXSalario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "idTipoGasto", nullable = false)
	private TipoGasto tipoGasto;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "idEmpleado", nullable = false)
	private Empleado empleado;

	@ManyToOne
	@NotNull
	@JoinColumns({
		@JoinColumn(name = "idSalario", referencedColumnName = "id"),
		@JoinColumn(name = "fecha", referencedColumnName = "fecha")
	})
	private Salario salario;

	@NotNull
	@Column(name = "cantidadDias", nullable = false)
	private int cantidadDias;

	@NotNull
	@Column(name = "fechaCalculo", nullable = false, columnDefinition = "timestamp")
	private OffsetDateTime fechaCalculo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Salario getSalario() {
		return salario;
	}

	public void setSalario(Salario salario) {
		this.salario = salario;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public OffsetDateTime getFechaCalculo() {
		return fechaCalculo;
	}

	public void setFechaCalculo(OffsetDateTime fechaCalculo) {
		this.fechaCalculo = fechaCalculo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmpleadoXSalario that = (EmpleadoXSalario) o;
		return id == that.id &&
				cantidadDias == that.cantidadDias &&
				Objects.equals(tipoGasto, that.tipoGasto) &&
				Objects.equals(empleado, that.empleado) &&
				Objects.equals(salario, that.salario) &&
				Objects.equals(fechaCalculo, that.fechaCalculo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoGasto, empleado, salario, cantidadDias, fechaCalculo);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("EmpleadoXSalario{");
		sb.append("id=").append(id);
		sb.append(", tipoGasto=").append(tipoGasto);
		sb.append(", empleado=").append(empleado);
		sb.append(", salario=").append(salario);
		sb.append(", cantidadDias=").append(cantidadDias);
		sb.append(", fechaCalculo=").append(fechaCalculo);
		sb.append('}');
		return sb.toString();
	}
}
