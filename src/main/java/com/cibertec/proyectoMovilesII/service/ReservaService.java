package com.cibertec.proyectoMovilesII.service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.proyectoMovilesII.enums.EstadoReserva;
import com.cibertec.proyectoMovilesII.models.Hotel;
import com.cibertec.proyectoMovilesII.models.Reserva;
import com.cibertec.proyectoMovilesII.repository.HotelRepository;
import com.cibertec.proyectoMovilesII.repository.ReservaRepositorio;


@Service
public class ReservaService {
	@Autowired
	private ReservaRepositorio reservaRepo;
	@Autowired
	private HotelRepository hotelRepo;
	
	public List<Reserva> listar(){
		return reservaRepo.findAll();
	}
	
	public List<Reserva> listarPorUsuario(String idUsuario){
		return reservaRepo.findByIdUsuario(idUsuario);
	}
	
	public Optional<Reserva> obtenerPorId(Long id){
		return reservaRepo.findById(id);
	}
	
	@Transactional
	public Reserva registrar(Reserva reserva) {
		if (reserva.getFechaIngreso() == null || reserva.getFechaSalida() == null) {
			throw new RuntimeException("Las fechas de ingreso y salida son obligatorias.");
		}
		Long idHotel = reserva.getHotel().getIdHotel();
		Hotel hotel = hotelRepo.findById(idHotel).orElseThrow(() -> 
				new RuntimeException("Hotel no encontrado"));
		long noches = ChronoUnit.DAYS.between(reserva.getFechaIngreso(), reserva.getFechaSalida());
		if (noches <= 0) {
            throw new RuntimeException("La fecha de salida debe ser posterior a la fecha de ingreso.");
        }
		
		BigDecimal precioNocheBD = hotel.getPrecioNoche();
		BigDecimal nochesBD = BigDecimal.valueOf(noches);
		BigDecimal montoTotalBD = precioNocheBD.multiply(nochesBD);
		
		reserva.setHotel(hotel);
		reserva.setMontoNoche(precioNocheBD);
		reserva.setMontoTotal(montoTotalBD);
		
		if (reserva.getEstado() == null) {
            reserva.setEstado(EstadoReserva.CONFIRMADO);
        }
		return reservaRepo.save(reserva);
	}
	
	public List<Reserva> listarPorUsuarioEstado(String idUsuario, EstadoReserva estado){
		return reservaRepo.findByIdUsuarioAndEstado(idUsuario, estado);
	}
}
