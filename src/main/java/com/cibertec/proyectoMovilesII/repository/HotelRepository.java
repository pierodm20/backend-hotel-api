package com.cibertec.proyectoMovilesII.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.proyectoMovilesII.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	Optional<Hotel> findByNombre(String nombre); 
	List<Hotel> findByNombreContainingIgnoreCase(String nombre);
}
