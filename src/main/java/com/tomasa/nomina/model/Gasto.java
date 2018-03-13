package com.tomasa.nomina.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "Gasto")
public class Gasto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name = "fecha", nullable = false)
	private OffsetDateTime fecha;

	@NotEmpty
	@Size(max = 200)
	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@NotNull
	@Column(name = "monto", nullable = false, precision = 20, scale = 2)
	private BigDecimal monto;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "enum('Pagado','Pendiente')")
	private StatusPago status;

	@OneToOne
	@JoinColumn(name="idTipoGasto")
	private TipoGasto tipoGasto;

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

	public StatusPago getStatus() {
		return status;
	}

	public void setStatus(StatusPago status) {
		this.status = status;
	}

	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Gasto gasto = (Gasto) o;
		return id == gasto.id &&
				Objects.equals(fecha, gasto.fecha) &&
				Objects.equals(descripcion, gasto.descripcion) &&
				Objects.equals(monto, gasto.monto) &&
				status == gasto.status &&
				Objects.equals(tipoGasto, gasto.tipoGasto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fecha, descripcion, monto, status, tipoGasto);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Gasto{");
		sb.append("id=").append(id);
		sb.append(", fecha=").append(fecha);
		sb.append(", descripcion='").append(descripcion).append('\'');
		sb.append(", monto=").append(monto);
		sb.append(", status=").append(status);
		sb.append(", tipoGasto=").append(tipoGasto);
		sb.append('}');
		return sb.toString();
	}
}
