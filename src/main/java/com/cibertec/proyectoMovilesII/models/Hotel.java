package com.cibertec.proyectoMovilesII.models;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hotel")
	private Long idHotel;

	@Column(name = "nom_hotel", nullable = false)
	private String nombre;

	@Column(name = "dir_hotel", nullable = false)
	private String direccion;

	@Column(name = "pre_hotel", nullable = false, precision = 10, scale = 2)
	private BigDecimal precioNoche;

	@Column(name = "est_hotel", nullable = false)
	private Integer estrellas;

	@Column(name = "img_hotel", nullable = false)
	private String imagenUrl;

	@OneToMany(mappedBy = "hotel")
	@JsonIgnore
	private List<Reserva> reservas;

	public Hotel() {
		super();
	}

	public Hotel(Long idHotel, String nombre, String direccion, BigDecimal precioNoche, Integer estrellas,
			String imagenUrl, List<Reserva> reservas) {
		super();
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioNoche = precioNoche;
		this.estrellas = estrellas;
		this.imagenUrl = imagenUrl;
		this.reservas = reservas;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(BigDecimal precioNoche) {
		this.precioNoche = precioNoche;
	}

	public Integer getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
}