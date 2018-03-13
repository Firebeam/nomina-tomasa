package com.tomasa.nomina.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "TipoGasto")
public class TipoGasto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Size(max = 200)
	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@NotNull
	@Column(name = "activo", nullable = false)
	private boolean activo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TipoGasto tipoGasto = (TipoGasto) o;
		return id == tipoGasto.id &&
				activo == tipoGasto.activo &&
				Objects.equals(descripcion, tipoGasto.descripcion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, descripcion, activo);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TipoGasto{");
		sb.append("id=").append(id);
		sb.append(", descripcion='").append(descripcion).append('\'');
		sb.append(", activo=").append(activo);
		sb.append('}');
		return sb.toString();
	}
}
