package com.cibertec.proyectoMovilesII.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.proyectoMovilesII.enums.EstadoReserva;
import com.cibertec.proyectoMovilesII.models.Reserva;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long>{
	List<Reserva> findByIdUsuario(String idUsuario);
	List<Reserva> findByIdUsuarioAndEstado(String idUsuario,EstadoReserva estado);
}
