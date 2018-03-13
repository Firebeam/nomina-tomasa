package com.tomasa.nomina.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Empleado")
public class Empleado {

	@Id
	@GeneratedValue
	private int id;

	@NotEmpty
	@Size(max = 100)
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@NotEmpty
	@Size(max = 20)
	@Column(name = "cedula", nullable = false)
	private String cedula;

	@NotNull
	@Column(name = "activo", nullable = false)
	private boolean activo;

	@OneToMany(mappedBy = "empleado")
	private Set<EmpleadoXSalario> empleadoXSalarioSet;

	@OneToMany(mappedBy = "empleado")
	private Set<Prestamo> prestamoSet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<EmpleadoXSalario> getEmpleadoXSalarioSet() {
		return empleadoXSalarioSet;
	}

	public void setEmpleadoXSalarioSet(Set<EmpleadoXSalario> empleadoXSalarioSet) {
		this.empleadoXSalarioSet = empleadoXSalarioSet;
	}

	public Set<Prestamo> getPrestamoSet() {
		return prestamoSet;
	}

	public void setPrestamoSet(Set<Prestamo> prestamoSet) {
		this.prestamoSet = prestamoSet;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Empleado empleado = (Empleado) o;
		return id == empleado.id &&
				activo == empleado.activo &&
				Objects.equals(nombre, empleado.nombre) &&
				Objects.equals(cedula, empleado.cedula);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, cedula, activo);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Empleado{");
		sb.append("id=").append(id);
		sb.append(", nombre='").append(nombre).append('\'');
		sb.append(", cedula='").append(cedula).append('\'');
		sb.append(", activo=").append(activo);
		sb.append('}');
		return sb.toString();
	}
}
