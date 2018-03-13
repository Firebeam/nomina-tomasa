package com.tomasa.nomina.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

@Embeddable
public class SalarioPK implements Serializable {

	private static final long serialVersionUID = 615862717843889487L;

	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "fecha", nullable = false, columnDefinition = "timestamp")
	private OffsetDateTime fecha;

	public SalarioPK() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		SalarioPK salarioPK = (SalarioPK) o;
		return id == salarioPK.id &&
				Objects.equals(fecha, salarioPK.fecha);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fecha);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("SalarioPK{");
		sb.append("id=").append(id);
		sb.append(", fecha=").append(fecha);
		sb.append('}');
		return sb.toString();
	}
}
