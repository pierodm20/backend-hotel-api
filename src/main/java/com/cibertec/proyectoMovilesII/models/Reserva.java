package com.cibertec.proyectoMovilesII.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.cibertec.proyectoMovilesII.enums.EstadoReserva;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReserva;
	@Column(name = "id_usua_reserva", nullable = false)
	private String idUsuario;
	@ManyToOne()
	@JoinColumn(name = "idHotel", nullable = false)
	private Hotel hotel;
	@Column(name = "fech_ingreso_reserva", nullable = false)
    private LocalDate fechaIngreso;
	@Column(name = "fech_salida_reserva", nullable = false)
    private LocalDate fechaSalida;
	@Column(name = "numHuesp_reserva", nullable = false)
    private Integer numHuespedes;
	@Column(name = "noche_reserva", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoNoche;
	@Column(name = "total_reserva", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoTotal;
	@Column(name = "estado_reserva", nullable = false)
	@Enumerated(EnumType.STRING)
    private EstadoReserva estado;
	
	public Reserva(Long idReserva, String idUsuario, Hotel hotel, LocalDate fechaIngreso, LocalDate fechaSalida,
			Integer numHuespedes, BigDecimal montoNoche, BigDecimal montoTotal, EstadoReserva estado) {
		super();
		this.idReserva = idReserva;
		this.idUsuario = idUsuario;
		this.hotel = hotel;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.numHuespedes = numHuespedes;
		this.montoNoche = montoNoche;
		this.montoTotal = montoTotal;
		this.estado = estado;
	}
	public Reserva() {
		super();
	}
	public Long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Integer getNumHuespedes() {
		return numHuespedes;
	}
	public void setNumHuespedes(Integer numHuespedes) {
		this.numHuespedes = numHuespedes;
	}
	public BigDecimal getMontoNoche() {
		return montoNoche;
	}
	public void setMontoNoche(BigDecimal montoNoche) {
		this.montoNoche = montoNoche;
	}
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}
	public EstadoReserva getEstado() {
		return estado;
	}
	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
